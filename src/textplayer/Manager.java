/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textplayer;

import java.io.File;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

/**
 *
 * @author bardini
 */
public class Manager {

    private String executionStatus;
    private String rawText;
    private Interpreter interpreter;

    public Manager(String rawText, Interpreter interpreter) {
        this.executionStatus = "stopped";
        this.rawText = rawText;
        this.interpreter = interpreter;
    }

    public void playSong(String formattedText) {
        Pattern pattern = new Pattern(formattedText);
        Player player = new Player();
        player.play(pattern);
        //REMOVE
        saveMidi(formattedText);
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

    public void playTestSong(){
        Player player = new Player();
        Pattern p1 = new Pattern(":CON(4, 63) C5 C5 C5 :CON(7, 127) C5 C5 C5");
        player.play(p1);
    }
}
