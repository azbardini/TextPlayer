/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textplayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import org.jfugue.player.ManagedPlayer;

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
        Thread playSong;
        playSong = new Thread() {
            @Override
            public void run() {
                try {
                    managedPlayer.start(sequence);
                } catch (InvalidMidiDataException | MidiUnavailableException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
                setExecutionStatus("executing");
            }
        };
        playSong.start();
    }

    public void stopSong(ManagedPlayer managedPlayer, Sequence sequence) {
        Thread stopSong;
        stopSong = new Thread() {
            @Override
            public void run() {
                managedPlayer.finish();
                setExecutionStatus("stopped");
            }
        };
        stopSong.start();
    }

    public void pauseSong(ManagedPlayer managedPlayer, Sequence sequence) {
        Thread pauseSong;
        pauseSong = new Thread() {
            @Override
            public void run() {
                if (getExecutionStatus().equals("executing")) {
                    managedPlayer.pause();
                    setExecutionStatus("paused");
                }
            }
        };
        pauseSong.start();
    }

    public void resumeSong(ManagedPlayer managedPlayer, Sequence sequence) {
        Thread resumeSong;
        resumeSong = new Thread() {
            @Override
            public void run() {
                managedPlayer.resume();
                setExecutionStatus("executing");
            }
        };
        resumeSong.start();
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
