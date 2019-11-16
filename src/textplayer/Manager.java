/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textplayer;

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

    public void playSong(ManagedPlayer managedPlayer, Sequence sequence) throws InvalidMidiDataException, MidiUnavailableException {
        managedPlayer.start(sequence);
        setExecutionStatus("executing");
    }

    public void stopSong(ManagedPlayer managedPlayer, Sequence sequence) {
        managedPlayer.finish();
        setExecutionStatus("stopped");
    }

    public void pauseSong(ManagedPlayer managedPlayer, Sequence sequence) {
        managedPlayer.pause();
        setExecutionStatus("paused");
    }

    public void resumeSong(ManagedPlayer managedPlayer, Sequence sequence) {
        managedPlayer.resume();
        setExecutionStatus("executing");
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
