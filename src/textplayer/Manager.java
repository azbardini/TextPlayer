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
import org.jfugue.theory.ChordProgression;

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
            System.out.println("fudeu");
        }
    }

    public void playGeneralSong() {
        Player player = new Player();
        Pattern p1 = new Pattern("C4 Fb4 A4 C5 Fb5 A5 C6 Fb6 A6 Fb6 C6 A5 Fb5 C5 A4 Fb4 ")
                .setVoice(0).setInstrument("Flute").setTempo(500);
        Pattern p2 = new Pattern("C4 Fb4 A4 C5 Fb5 A5 C6 Fb6 A6 Fb6 C6 A5 Fb5 C5 A4 Fb4 ")
                .setVoice(1).setInstrument("Flute").setTempo(500);
//
//        Pattern p3 = new Pattern("C4 Fb4 A4 C5 Fb5 A5 C6 Fb6 A6 Fb6 C6 A5 Fb5 C5 A4 Fb4 ")
//                .setVoice(0).setInstrument("Flute").setTempo(800);
//        Pattern p4 = new Pattern("Fb4 A4 C5 Fb5 A5 C6 Fb6 A6 C7 C6 A5 Fb5 C5 A4 Fb4 C4 ")
//                .setVoice(1).setInstrument("Flute").setTempo(500);
//        
//        Pattern p5 = new Pattern("Fb6 C6 A5 Fb6 C6 A5 Fb6 C6 A5 Fb6 C6 A5 F#6 A5 F6 A5 ")
//                .setVoice(0).setInstrument("Flute").setTempo(500);
//        Pattern p6 = new Pattern("Fb6 C6 A5 Fb6 C6 A5 Fb6 C6 A5 Fb6 C6 A5 F#6 A5 F6 A5 ")
//                .setVoice(1).setInstrument("Flute").setTempo(500);
// 
//        Pattern p7 = new Pattern("Fb6 C6 A5 Fb6 C6 A5 Fb6 C6 A5 Fb6 C6 A5 F#6 A5 F6 A5 Fb6qqq Fb6qqq Fb6")
//                .setVoice(0).setInstrument("Flute").setTempo(500);
//        Pattern p8 = new Pattern("A6 Fb6 C6 A6 Fb6 C6 A6 Fb6 C6 A6 Fb6 C6 B6 B5 G#6 ")
//                .setVoice(1).setInstrument("Flute").setTempo(500);
    }
}
