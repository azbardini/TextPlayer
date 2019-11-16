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
public class PlaySong implements Runnable {

    private ManagedPlayer player;
    private Sequence sequence;

    public PlaySong(ManagedPlayer player, Sequence sequence) {
        this.player = player;
        this.sequence = sequence;
    }

    public void run() {
        System.out.println("Play");
        try {
            player.start(sequence);
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(PlaySong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(PlaySong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
