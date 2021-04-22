package symbol;

//Symbol from input text that represents the BPM change.
public class BPMAlteration extends Symbol {
 private int difference;

 public BPMAlteration(int value) {
	 this.difference = value;
 }

 public int getDifference() {
	 return difference;
 }
}
