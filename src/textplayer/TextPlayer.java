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
        String rawtext = "tirolirotiroliro";
        
        CurrentStatus currentStatus = new CurrentStatus();
        Interpreter interpreter = new Interpreter(rawtext, currentStatus);
        Manager manager = new Manager(interpreter.getRawText(), interpreter);
        
        System.out.println("Tempo = " + Integer.toString(currentStatus.getTempo()));
        manager.playSong();
    }    
}
