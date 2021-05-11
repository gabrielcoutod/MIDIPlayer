package symbol;

//Symbol from input text that represents the change to 
//default volume or double the current volume.
public class VolumeDoubleAlteration extends Symbol {
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
