package player;

import symbol.OctaveAlteration;
import symbol.OctaveIncrementAlteration;

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

 public void update(OctaveIncrementAlteration alterOctave) {
	 octave += 1;
	 if(octave > maxOctave)
		 octave = minOctave;
 }
 
 public void update(OctaveAlteration octaveAlteration) {
	 octave += octaveAlteration.getDifference();
	 if(octave > maxOctave)
		 octave = maxOctave;
 }

 public int getOctave() {
	 return octave;
 }
}
