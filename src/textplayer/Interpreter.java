/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textplayer;

import java.util.HashMap;

/**
 *
 * @author bardini
 */
public class Interpreter {

    private String rawText;
    private String formattedText;
    private CurrentStatus currentStatus;
    static String space = " ";
    static HashMap notesDictionary = new HashMap();
    static HashMap instrumentsDictionary = new HashMap();

    public Interpreter(String rawText, CurrentStatus currentStatus) {
        this.rawText = rawText;
        this.currentStatus = currentStatus;
    }

    public String translate() {
        notesDictionary.put('A', "A");
        notesDictionary.put('B', "B");
        notesDictionary.put('C', "C");
        notesDictionary.put('D', "D");
        notesDictionary.put('E', "E");
        notesDictionary.put('F', "F");
        notesDictionary.put('G', "G");

        instrumentsDictionary.put('!', "I114");
        instrumentsDictionary.put('o', "I7");
        instrumentsDictionary.put('O', "I7");
        instrumentsDictionary.put('i', "I7");
        instrumentsDictionary.put('I', "I7");
        instrumentsDictionary.put('u', "I7");
        instrumentsDictionary.put('U', "I7");
        instrumentsDictionary.put('\n', "I15");
        instrumentsDictionary.put(';', "I76");
        instrumentsDictionary.put(',', "I20");

        String onBuildString = "";
        String currentCharacter = "";

        for (char charactere : this.rawText.toCharArray()) {
            //Try to translate from the instruments map
            try {

                currentCharacter = mapInstrumentToString(charactere);
                onBuildString = onBuildString.concat(currentCharacter);
            } catch (Exception noInstrumentException) {
                //Try to translate from the notes map
                try {
                    currentCharacter = mapNoteToString(charactere);
                    onBuildString = onBuildString.concat(currentCharacter);
                    //Adds on the current octave
                    onBuildString = onBuildString.concat(this.currentStatus.getOctaveString());
                    currentStatus.setLastCharacter(currentCharacter);
                } catch (Exception noNoteException) {
                    currentCharacter = getDoubleOrRest(charactere);
                }
            }
            onBuildString = onBuildString.concat(space);
        }
        return onBuildString;
    }

    public String mapNoteToString(char charactere) {
        return notesDictionary.get(charactere).toString();
    }

    public String mapInstrumentToString(char charactere) {
        return instrumentsDictionary.get(charactere).toString();
    }

    public String getDoubleOrRest(char currentCharacter) {
        String restBeat = "R";
        String lastCharacter = this.currentStatus.getLastCharacterString();
        String currentTreatedCharacter = Character.toString(currentCharacter).toUpperCase();

        return (lastCharacter.equals(currentTreatedCharacter) ? currentTreatedCharacter : restBeat);
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public String getFormattedText() {
        return formattedText;
    }

    public void setFormattedText(String formattedText) {
        this.formattedText = formattedText;
    }

    public CurrentStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(CurrentStatus currentStatus) {
        this.currentStatus = currentStatus;
    }
}
