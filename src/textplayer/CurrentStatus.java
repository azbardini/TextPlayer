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
public class CurrentStatus {

    private int volume;
    private int octave;
    private int tempo;
    private int instrument;
    private String lastCharacter;

    public CurrentStatus() {
        this.volume = 10;
        this.octave = 5;
        this.tempo = 200;
        this.instrument = 1;
        this.lastCharacter = "Z";
    }

    public CurrentStatus(int volume, int octave, int tempo, int instrument, String lastCharacter) {
        this.volume = volume;
        this.octave = octave;
        this.tempo = tempo;
        this.instrument = instrument;
        this.lastCharacter = lastCharacter;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getLastCharacterString() {
        return lastCharacter;
    }

    public void setLastCharacter(String lastCharacter) {
        this.lastCharacter = lastCharacter;
    }

    public String getOctaveString() {
        return Integer.toString(octave);
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }

    public String getTempo() {
        return Integer.toString(tempo);
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getInstrument() {
        return Integer.toString(instrument);
    }

    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }
}
