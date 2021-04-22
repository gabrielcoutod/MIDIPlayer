package symbol;

//Symbol from input text that represents the octave change.
public class OctaveAlteration extends Symbol {
    private int difference;

    public OctaveAlteration(int value) {
    	this.difference = value;
    }

    public int getDifference() {
    	return difference;
    }
}
