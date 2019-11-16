/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textplayer;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.ManagedPlayer;
import org.jfugue.player.Player;

/**
 *
 * @author bardini
 */
public class Manager {

    private String executionStatus = "stopped";
    private String rawText;
    private Interpreter interpreter;

    public Manager() {
    }

    public Manager(String rawText, Interpreter interpreter) {
        this.rawText = rawText;
        this.interpreter = interpreter;
    }

    public void playSong(ManagedPlayer managedPlayer, Sequence sequence) {
        Thread playSong = new Thread() {
            public void run() {
                System.out.println("Play Pressed");
                try {
                    managedPlayer.start(sequence);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MidiUnavailableException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
                setExecutionStatus("executing");
            }
        };
        playSong.start();
    }

    public void stopSong(ManagedPlayer managedPlayer, Sequence sequence) {
        Thread stopSong = new Thread() {
            public void run() {
                System.out.println("Stop Pressed");
                managedPlayer.finish();
                setExecutionStatus("stopped");
            }
        };
        stopSong.start();
    }

    public void pauseSong(ManagedPlayer managedPlayer, Sequence sequence) {
        Thread pauseSong = new Thread() {
            public void run() {
                System.out.println("Pause Pressed");

                if (getExecutionStatus().equals("executing")) {
                    managedPlayer.pause();
                    setExecutionStatus("paused");
                }
            }
        };
        pauseSong.start();
    }

    public void resumeSong(ManagedPlayer managedPlayer, Sequence sequence) {
        Thread resumeSong = new Thread() {
            public void run() {
                System.out.println("Play (resume) Pressed");
                managedPlayer.resume();
                setExecutionStatus("executing");
            }
        };
        resumeSong.start();
    }

    public void saveMidi(String formattedText) {
        Pattern pattern = new Pattern(formattedText);
        try {
            MidiFileManager.savePatternToMidi(pattern, new File("JFugue.mid"));
        } catch (Exception e) {
            System.out.println("Error saving MIDI file");
            System.exit(0);
        }
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

}
