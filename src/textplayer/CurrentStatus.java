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

    public CurrentStatus() {
        this.volume = 10;
        this.octave = 4;
        this.tempo = 120;
        this.instrument = 1;
    }

    public CurrentStatus(int volume, int octave, int tempo, int instrument) {
        this.volume = volume;
        this.octave = octave;
        this.tempo = tempo;
        this.instrument = instrument;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getOctave() {
        return octave;
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getInstrument() {
        return instrument;
    }

    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }
}
