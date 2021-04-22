package player;

import symbol.OctaveAlteration;

//Represents an octave.
public class Octave {
 private static final int defaultOctave = 0;
 private static final int maxOctave = 5;
 private static final int minOctave = -5;
 
 private int octave;

 public Octave(int octave) {
	 this.octave = octave;
 }
 public Octave() {
	 this.octave = defaultOctave;
 }

 public void update(OctaveAlteration alterOctave) {
	 
 }

 public int getOctave() {
	 return octave;
 }
}
