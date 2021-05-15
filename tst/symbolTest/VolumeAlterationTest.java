package symbolTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import player.TCPlayer;
import player.Volume;
import symbol.VolumeAlteration;

// Class for VolumeAlteration tests
class VolumeAlterationTest {
	
	private TCPlayer player = new TCPlayer();

	@Test
	// Test for positive alteration
	void volumePositiveAlterationTest() {
		int initialVolume = player.getVolume();
		new VolumeAlteration(VolumeAlteration.positiveAlteration).alterPlayer(player);
		int afterAlteration = player.getVolume();
		assertEquals(initialVolume + VolumeAlteration.positiveAlteration,afterAlteration);
	}
	
	@Test
	// Test for negative alteration
	void volumeNegativeAlterationTest() {
		int initialVolume = player.getVolume();
		new VolumeAlteration(VolumeAlteration.negativeAlteration).alterPlayer(player);
		int afterAlteration = player.getVolume();
		assertEquals(initialVolume + VolumeAlteration.negativeAlteration,afterAlteration);
	}
	
	@Test
	// Test for when the new value will be over the upper limit
	void volumePositiveAlterationOverTest() {
		player.setVolume(Volume.maxVolume);
		new VolumeAlteration(VolumeAlteration.positiveAlteration).alterPlayer(player);
		int afterAlteration = player.getVolume();
		assertEquals(Volume.maxVolume,afterAlteration);
	}
	
	@Test
	// Test for when the new value will be under the lower limit
	void volumeNegativeAlterationUnderTest() {
		player.setVolume(Volume.minVolume);
		new VolumeAlteration(VolumeAlteration.negativeAlteration).alterPlayer(player);
		int afterAlteration = player.getVolume();
		assertEquals(Volume.minVolume,afterAlteration);
	}
	
	@Test
	// Test to verify if the symbol doesn't change any other parameter
	void onlyOneAlterationTest() {
		int initialBPM = player.getBPM();
		int initialInstrument = player.getInstrument();
		int initialOctave= player.getOctave();
		new VolumeAlteration(VolumeAlteration.positiveAlteration).alterPlayer(player);
		assertTrue(initialBPM == player.getBPM() && initialInstrument == player.getInstrument() && initialOctave == player.getOctave());
	}

}
