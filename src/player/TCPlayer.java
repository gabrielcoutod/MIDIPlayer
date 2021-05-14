package player;

import symbol.Symbol;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import org.jfugue.midi.MidiFileManager;

//Receives the characters from the input,
//determines the parameters of the music and plays/saves it.
public class TCPlayer {
	
	// Attributes for the player
    private BPM bpm;
    private Octave octave;
    private Instrument instrument;
    private Volume volume;
    private Player player;
    private Pattern fullSong;

    // Default constructor
    public TCPlayer() {
    	this.octave = new Octave();
        this.bpm = new BPM();
        this.volume = new Volume();
        this.instrument = new Instrument();
        this.fullSong = new Pattern();
        this.player = new Player();
    }

    // Argument constructor
    public TCPlayer(int octave, int bpm, int volume, int instrument) {
        this.octave = new Octave(octave);
        this.bpm = new BPM(bpm);
        this.volume = new Volume(volume);
        this.instrument = new Instrument(instrument);
        this.fullSong = new Pattern();
        this.player = new Player();
    }

    // Setter for BPM
    public void setBPM(int newBPM) {
        bpm.setBPM(newBPM);
    }

    // Getter for BPM
    public int getBPM() {
        return bpm.getBPM();
    }

    // Setter for octave
    public void setOctave(int newOctave) {
        octave.setOctave(newOctave);
    }

    // Getter for octave
    public int getOctave() {
        return octave.getOctave();
    }

    // Setter for instrument
    public void setInstrument(int newInstrument) {
        instrument.setInstrument(newInstrument);
    }

    // Getter for instrument
    public int getInstrument() {
        return instrument.getInstrument();
    }

    // Setter for volume
    public void setVolume(int newVolume) {
        volume.setVolume(newVolume);
    }

    // Getter for volume
    public int getVolume() {
        return volume.getVolume();
    }

    // Adds a pattern to the song
    public void addToSong(Pattern updateSong) {
        fullSong.add(updateSong);
    }

    // Converts music symbols to MIDI string
    private void symbolsToMidiString(Symbol[] music) {
        for(Symbol symbol: music){
            symbol.alterPlayer(this);
        }    
    }

    // Plays the song
    public void play(Symbol[] music) {
        symbolsToMidiString(music);
    	player.play(fullSong);
    }

    // Saves the song 
    public void save(Symbol[] music, FileOutputStream file) throws IOException {
        symbolsToMidiString(music);
        MidiFileManager.savePatternToMidi(fullSong, file);
    }
}