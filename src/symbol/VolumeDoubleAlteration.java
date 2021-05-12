package symbol;

import player.TCPlayer;
import player.Volume;

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

	public void alterPlayer(TCPlayer player) {
		int newVolume = 2 * player.getVolume();
		if (newVolume > Volume.maxVolume)
			player.setVolume(Volume.minVolume);
		else
			player.setVolume(newVolume);
	}
}
