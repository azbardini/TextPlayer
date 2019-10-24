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
    private String instrument;
    private String lastCharacter;

    public CurrentStatus() {
        this.volume = 31;
        this.octave = 5;
        this.tempo = 120;
        this.instrument = "0";
        this.lastCharacter = "";
    }

    public CurrentStatus(int volume, int octave, int tempo, String instrument, String lastCharacter) {
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
        this.octave = octave > 10 ? 5 : octave;
    }

    public String getTempo() {
        return Integer.toString(tempo);
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
}
