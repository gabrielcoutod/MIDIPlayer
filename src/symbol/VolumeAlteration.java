package symbol;

//Symbol from input text that represents the volume change.
public class VolumeAlteration extends Symbol {
 private int difference;

 public VolumeAlteration(int value) {
	 this.difference = value;
 }

 public int getDifference() {
	 return difference;
 }
}
