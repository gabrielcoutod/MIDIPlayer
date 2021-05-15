package symbolTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import player.TCPlayer;
import player.Volume;
import symbol.VolumeDoubleAlteration;

// Class for VolumeDoubleAlteration tests
class VolumeDoubleAlterationTest {
	
	private TCPlayer player = new TCPlayer();

	@Test
	// Test for double alteration
	void VolumeDoubleTest() {
		int initialVolume = player.getVolume();
		new VolumeDoubleAlteration().alterPlayer(player);
		int afterAlteration = player.getVolume();
		assertEquals(initialVolume * 2, afterAlteration);
	}
	
	@Test
	// Test for when the new value will be over the upper limit
	void VolumeDoubleOverTest() {
		player.setVolume(Volume.maxVolume);
		new VolumeDoubleAlteration().alterPlayer(player);
		int afterAlteration = player.getVolume();
		assertEquals(Volume.defaultVolume, afterAlteration);
	}
	
	@Test
	// Test to verify if the symbol doesn't change any other parameter
	void onlyOneAlterationTest() {
		int initialBPM = player.getBPM();
		int initialInstrument = player.getInstrument();
		int initialOctave= player.getOctave();
		new VolumeDoubleAlteration().alterPlayer(player);
		assertTrue(initialBPM == player.getBPM() && initialInstrument == player.getInstrument() && initialOctave == player.getOctave());
	}

}
