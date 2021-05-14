package symbolTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import player.TCPlayer;
import player.Volume;
import symbol.VolumeAlteration;

// Class for BPMAlteration tests
class VolumeAlterationTest {
	
	private TCPlayer player = new TCPlayer();

	@Test
	void volumePositiveAlterationTest() {
		int initialVolume = player.getVolume();
		new VolumeAlteration(VolumeAlteration.positiveAlteration).alterPlayer(player);
		int afterAlteration = player.getVolume();
		assertEquals(initialVolume + VolumeAlteration.positiveAlteration,afterAlteration);
	}
	
	@Test
	void volumeNegativeAlterationTest() {
		int initialVolume = player.getVolume();
		new VolumeAlteration(VolumeAlteration.negativeAlteration).alterPlayer(player);
		int afterAlteration = player.getVolume();
		assertEquals(initialVolume + VolumeAlteration.negativeAlteration,afterAlteration);
	}
	
	@Test
	void volumePositiveAlterationOverTest() {
		player.setVolume(Volume.maxVolume);
		new VolumeAlteration(VolumeAlteration.positiveAlteration).alterPlayer(player);
		int afterAlteration = player.getVolume();
		assertEquals(Volume.maxVolume,afterAlteration);
	}
	
	@Test
	void volumeNegativeAlterationUnderTest() {
		player.setVolume(Volume.minVolume);
		new VolumeAlteration(VolumeAlteration.negativeAlteration).alterPlayer(player);
		int afterAlteration = player.getVolume();
		assertEquals(Volume.minVolume,afterAlteration);
	}
	
	@Test
	void onlyOneAlterationTest() {
		int initialBPM = player.getBPM();
		int initialInstrument = player.getInstrument();
		int initialOctave= player.getOctave();
		new VolumeAlteration(VolumeAlteration.positiveAlteration).alterPlayer(player);
		assertTrue(initialBPM == player.getBPM() && initialInstrument == player.getInstrument() && initialOctave == player.getOctave());
	}

}
