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

    private int instrument;
    private String lastCharacter;
    private int octave;
    private int tempo;
    private int volume;

    public CurrentStatus() {
        this.instrument = 0;
        this.lastCharacter = "";
        this.octave = 5;
        this.tempo = 120;
        this.volume = 31;
    }

    public CurrentStatus(int instrument, String lastCharacter, int octave, int tempo, int volume) {
        this.instrument = instrument;
        this.lastCharacter = lastCharacter;
        this.octave = octave;
        this.tempo = tempo;
        this.volume = volume;
    }

    public int getInstrument() {
        return instrument;
    }

    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }

    public String getLastCharacter() {
        return lastCharacter;
    }

    public void setLastCharacter(String lastCharacter) {
        this.lastCharacter = lastCharacter;
    }

    public int getOctave() {
        return octave;
    }

    public void setOctave(int octave) {
        this.octave = octave > 9 ? 5 : octave;
    }

    public String getTempo() {
        return Integer.toString(tempo);
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

}
