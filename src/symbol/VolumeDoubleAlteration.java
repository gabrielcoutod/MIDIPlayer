package symbol;

import player.TCPlayer;
import player.Volume;

//Symbol from input text that represents the change to 
// double the current volume.
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

	// Alteration
	public void alterPlayer(TCPlayer player) {
		int newVolume = 2 * player.getVolume();
		if (newVolume > Volume.maxVolume)
			player.setVolume(Volume.defaultVolume);
		else
			player.setVolume(newVolume);
	}
}
