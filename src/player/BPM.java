package player;

import symbol.BPMAlteration;

//Represents a BPM.
public class BPM {
 private static final int defaultBPM = 50;
 private static final int maxBPM = 1000;
 private static final int minBPM = 50;

 private int bpm;

 public BPM(int bpm) {
	 this.bpm = bpm;
 }
 
 public BPM() {
	 this.bpm = defaultBPM;
 }

 public void update(BPMAlteration alterBPM) {
	 
 }

 public int getBPM() {
	 return bpm;
 }
}
