package symbolTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import player.TCPlayer;
import player.Volume;
import symbol.VolumeDoubleAlteration;

// Class for BPMAlteration tests
class VolumeDoubleAlterationTest {
	
	private TCPlayer player = new TCPlayer();

	@Test
	void VolumeDoubleTest() {
		int initialVolume = player.getVolume();
		new VolumeDoubleAlteration().alterPlayer(player);
		int afterAlteration = player.getVolume();
		assertEquals(initialVolume * 2, afterAlteration);
	}
	
	@Test
	void VolumeDoubleOverTest() {
		player.setVolume(Volume.maxVolume);
		new VolumeDoubleAlteration().alterPlayer(player);
		int afterAlteration = player.getVolume();
		assertEquals(Volume.defaultVolume, afterAlteration);
	}
	
	@Test
	void onlyOneAlterationTest() {
		int initialBPM = player.getBPM();
		int initialInstrument = player.getInstrument();
		int initialOctave= player.getOctave();
		new VolumeDoubleAlteration().alterPlayer(player);
		assertTrue(initialBPM == player.getBPM() && initialInstrument == player.getInstrument() && initialOctave == player.getOctave());
	}

}
