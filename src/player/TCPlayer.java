package player;

import symbol.Symbol;
import java.io.File;
import java.io.IOException;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import org.jfugue.midi.MidiFileManager;

//Receives the characters from the input,
//determines the parameters of the music and plays/saves it.

public class TCPlayer {
    private BPM bpm;
    private Octave octave;
    private Instrument instrument;
    private Volume volume;
    private Player player;
    private Pattern fullSong;

    public TCPlayer() {
    	this.octave = new Octave();
        this.bpm = new BPM();
        this.volume = new Volume();
        this.instrument = new Instrument();
        this.fullSong = new Pattern();
        this.player = new Player();
    }

    public TCPlayer(int octave, int bpm, int volume, int instrument) {
        this.octave = new Octave(octave);
        this.bpm = new BPM(bpm);
        this.volume = new Volume(volume);
        this.instrument = new Instrument(instrument);
        this.fullSong = new Pattern();
        this.player = new Player();
    }

    public void setBPM(int newBPM) {
        bpm.setBPM(newBPM);
    }

    public int getBPM() {
        return bpm.getBPM();
    }

    public void setOctave(int newOctave) {
        octave.setOctave(newOctave);
    }

    public int getOctave() {
        return octave.getOctave();
    }

    public void setInstrument(int newInstrument) {
        instrument.setInstrument(newInstrument);
    }

    public int getInstrument() {
        return instrument.getInstrument();
    }

    public void setVolume(int newVolume) {
        volume.setVolume(newVolume);
    }

    public int getVolume() {
        return volume.getVolume();
    }

    public void addToSong(Pattern updateSong) {
        fullSong.add(updateSong);
    }

    private void symbolsToMidiString(Symbol[] music) {
        for(Symbol symbol: music){
            symbol.alterPlayer(this);
        }    
    }

    public void play(Symbol[] music) {
        symbolsToMidiString(music);
    	player.play(fullSong);
    }

    public void save(Symbol[] music, File file) throws IOException {
        symbolsToMidiString(music);
        MidiFileManager.savePatternToMidi(fullSong, file);
    }
}