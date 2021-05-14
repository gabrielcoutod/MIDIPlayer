package symbolTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import player.BPM;
import player.TCPlayer;
import symbol.BPMAlteration;

// Class for BPMAlteration tests
class BPMAlterationTest {
	
	private TCPlayer player = new TCPlayer();

	@Test
	// Test for positive alteration
	void BPMPositiveAlterationTest() {
		int initialBPM = player.getBPM();
		new BPMAlteration(BPMAlteration.positiveAlteration).alterPlayer(player);
		int afterAlteration = player.getBPM();
		assertEquals(initialBPM + BPMAlteration.positiveAlteration,afterAlteration);
	}
	
	@Test
	// Test for negative alteration
	void BPMNegativeAlterationTest() {
		int initialBPM = player.getBPM();
		new BPMAlteration(BPMAlteration.negativeAlteration).alterPlayer(player);
		int afterAlteration = player.getBPM();
		assertEquals(initialBPM + BPMAlteration.negativeAlteration,afterAlteration);
	}
	
	@Test
	// Test for when the new value will be over the upper limit
	void BPMPositiveAlterationOverTest() {
		player.setBPM(BPM.maxBPM);
		new BPMAlteration(BPMAlteration.positiveAlteration).alterPlayer(player);
		int afterAlteration = player.getBPM();
		assertEquals(BPM.maxBPM,afterAlteration);
	}
	
	@Test
	// Test for when the new value will be under the lower limit
	void BPMNegativeAlterationUnderTest() {
		player.setBPM(BPM.minBPM);
		new BPMAlteration(BPMAlteration.negativeAlteration).alterPlayer(player);
		int afterAlteration = player.getBPM();
		assertEquals(BPM.minBPM,afterAlteration);
	}
	
	@Test
	// Test to verify if the symbol doesn't change any other parameter
	void onlyOneAlterationTest() {
		int initialVolume = player.getVolume();
		int initialInstrument = player.getInstrument();
		int initialOctave= player.getOctave();
		new BPMAlteration(BPMAlteration.positiveAlteration).alterPlayer(player);
		assertTrue(initialVolume == player.getVolume() && initialInstrument == player.getInstrument() && initialOctave == player.getOctave());
	}

}
