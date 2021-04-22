package player;

import symbol.BPMAlteration;
import symbol.InstrumentAlteration;
import symbol.Note;
import symbol.OctaveAlteration;
import symbol.Symbol;
import symbol.VolumeAlteration;
import symbol.VolumeDoubleAlteration;

//Receives the characters from the input,
//determines the parameters of the music and plays/saves it.
public class Player {
 private Octave octave;
 private BPM bpm;
 private Volume volume;
 private Instrument instrument;

 public Player() {
	 
 }

 public Player(int octave, int bpm, int volume, int instrument) {
	 
 }

 private void action(BPMAlteration alteration) {
	 
 }

 private void action(VolumeAlteration alteration) {
	 
 }

 private void action(VolumeDoubleAlteration alteration) {
	 
 }

 private void action(InstrumentAlteration alteration) {
	 
 }

 private void action(OctaveAlteration alteration) {
	 
 }

 private void action(Note note) {
	 
 }

 private void play(Symbol[] music) {
	 
 }

 private void save(Symbol[] music) {
	 
 }
}