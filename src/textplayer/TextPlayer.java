/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package textplayer;

/**
 *
 * @author bardini
 */
public class TextPlayer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String rawText = "CDEFGAB";

        CurrentStatus currentStatus = new CurrentStatus();
        Interpreter interpreter = new Interpreter(rawText, currentStatus);
        Manager manager = new Manager(interpreter.getRawText(), interpreter);

        String playable = interpreter.translate();
        System.out.println(playable);
//        manager.playSong(playable);
        manager.playTestSong();
    }
}
