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

        instrumentsDictionary.put('!', "114");
        instrumentsDictionary.put('o', "7");
        instrumentsDictionary.put('O', "7");
        instrumentsDictionary.put('i', "7");
        instrumentsDictionary.put('I', "7");
        instrumentsDictionary.put('u', "7");
        instrumentsDictionary.put('U', "7");
        instrumentsDictionary.put('\n', "15");
        instrumentsDictionary.put(';', "76");
        instrumentsDictionary.put(',', "20");

        String onBuildString = "";
        String translatedCharacter = "";
        String currentInstrument = "";
        String newInstrument = "";
        int currentOctave;
        int newOctave;
        int newInstrumentNumber;
        for (char character : this.rawText.toCharArray()) {

            //===FIRST CONTROL LAYER===
            //0 1 2 3 4 5 6 7 8 9
            if (Character.isDigit(character)) {
                currentInstrument = currentStatus.getInstrument();
                newInstrumentNumber = Integer.parseInt(currentInstrument) + Character.getNumericValue(character);
                newInstrumentNumber = newInstrumentNumber > 127 ? 127 : newInstrumentNumber;
                newInstrument = Integer.toString(newInstrumentNumber);
                currentStatus.setInstrument(newInstrument);
                translatedCharacter = "I".concat(newInstrument);
                onBuildString = onBuildString.concat(translatedCharacter);
            } else {

                //? .
                if (character == '?' || character == '.') {
                    currentOctave = currentStatus.getOctave();
                    newOctave = ++currentOctave;
                    currentStatus.setOctave(newOctave);
                } else {

                    //Try to translate from the instruments map
                    //! i I o O u U NL ; ,
                    try {
                        newInstrument = mapInstrumentToString(character);
                        currentStatus.setInstrument(newInstrument);
                        translatedCharacter = "I".concat(newInstrument);
                        onBuildString = onBuildString.concat(translatedCharacter);
                    } catch (Exception noInstrumentException) {

                        //===THEN NOTES LAYER===
                        //Try to translate from the notes map
                        //A B C D E F G
                        try {
                            translatedCharacter = mapNoteToString(character);
                            onBuildString = onBuildString.concat(translatedCharacter);
                            //Adds on the current octave
                            onBuildString = onBuildString.concat(Integer.toString(currentStatus.getOctave()));
                        } catch (Exception noNoteException) {

                            //a c b d e f g consoantes todo o resto
                            translatedCharacter = getDoubleOrRest();
                            onBuildString = onBuildString.concat(translatedCharacter);
                            //Adds on the current octave
                            onBuildString = onBuildString.concat(Integer.toString(currentStatus.getOctave()));
                        }
                    }
                }
            }
            onBuildString = onBuildString.concat(space);
            currentStatus.setLastCharacter(Character.toString(character));
        }
        return onBuildString;
    }

    public String mapNoteToString(char character) {
        return notesDictionary.get(character).toString();
    }

    public String mapInstrumentToString(char character) {
        return instrumentsDictionary.get(character).toString();
    }

    public String getDoubleOrRest() {
        String restBeat = "R";
        try {
            String lastCharacter = this.currentStatus.getLastCharacter();
            return mapNoteToString(lastCharacter.charAt(0));
        } catch (Exception noNoteException) {
            return restBeat;
        }
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
