package player;

import symbol.BPMAlteration;
import symbol.InstrumentAlteration;
import symbol.InstrumentRelativeAlteration;
import symbol.Note;
import symbol.OctaveAlteration;
import symbol.OctaveIncrementAlteration;
import symbol.Symbol;
import symbol.VolumeAlteration;
import symbol.VolumeDoubleAlteration;
import java.io.File;
import java.io.IOException;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import org.jfugue.midi.MidiFileManager;

//Receives the characters from the input,
//determines the parameters of the music and plays/saves it.

public class TCPlayer {
 private Octave octave;
 private BPM bpm;
 private Volume volume;
 private Instrument instrument;
 private Player player;
 private Pattern fullSong;

 public TCPlayer() {
	 
 }

 public TCPlayer(int octave, int bpm, int volume, int instrument) {
     this.octave = new Octave(octave);
     this.bpm = new BPM(bpm);
     this.volume = new Volume(volume);
     this.instrument = new Instrument(instrument);
     this.fullSong = new Pattern();
     this.player = new Player();
 }

 // Updates and changes the music's Tempo (BPM)
 private void action(BPMAlteration alteration, Pattern fullSong) {
    bpm.update(alteration);
 }

private void action(InstrumentAlteration alteration) {
    instrument.update(alteration);
}

private void action(InstrumentRelativeAlteration alteration){
    instrument.update(alteration);
}

private void action(Note note) {
    Pattern updateSong = new Pattern().setTempo(bpm.getBPM());
    updateSong.add(":CON(7, " + volume.getVolume() + ")");
    updateSong.add("I" + instrument.getInstrument());
    updateSong.add(note.toString() + octave.getOctave());
    fullSong.add(updateSong);
 }

private void action(OctaveAlteration alteration) {
     octave.update(alteration);
}

private void action(OctaveIncrementAlteration alteration){
    octave.update(alteration);
}

// Updated and changes the music's Volume
private void action(VolumeAlteration alteration) {
    volume.update(alteration);	 
}

private void action(VolumeDoubleAlteration alteration) {
    volume.update(alteration);
}

private void play(Symbol[] music) {
	 
}

public void save(Symbol[] music, String fileName) throws IOException{
    File file = new File(fileName);
    MidiFileManager.savePatternToMidi(fullSong, file);
}

// public static void main(String[] args) {
	 
// 	 Player player = new Player();
// 	 Pattern fullSong = new Pattern();
// 	 Pattern p1 = new Pattern().setTempo(100);
// 	 p1.add(":CON(7, 127)");
// 	 p1.add("I0");
// 	 p1.add("C5");
// 	 Pattern p2 = new Pattern().setTempo(100);
// 	 p2.add(":CON(7, 127)");
// 	 p2.add("I0");
// 	 p2.add("G5");
// 	 Pattern p3 = new Pattern().setTempo(100);
// 	 p3.add(":CON(7, 127)");
// 	 p3.add("I0");
// 	 p3.add("C-4");
// 	 Pattern p4 = new Pattern().setTempo(100);
// 	 p4.add(":CON(7, 127)");
// 	 p4.add("I0");
// 	 p4.add("G5");
// 	 fullSong.add(p1);
// 	 fullSong.add(p2);
// 	 fullSong.add(p3);
// 	 fullSong.add(p4);
// 	 player.play(fullSong);
	 
// }
}