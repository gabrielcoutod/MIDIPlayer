package symbolTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import player.Instrument;
import player.TCPlayer;
import symbol.InstrumentRelativeAlteration;

// Class for InstrumentRelativeAlteration tests
class InstrumentRelativeAlterationTest {
	
	private TCPlayer player = new TCPlayer();

	@Test
	// Test for positive alteration
	void instrumentPositiveRelativeAlterationTest() {
		int initialInstrument = player.getInstrument();
		int change = 2;
		new InstrumentRelativeAlteration(change).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(initialInstrument + change,afterAlteration);
	}
	
	@Test
	// Test for negative alteration
	void instrumentNegativeRelativeAlterationTest() {
		int initialInstrument = player.getInstrument();
		int change = -3;
		new InstrumentRelativeAlteration(change).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(initialInstrument + change,afterAlteration);
	}
	
	@Test
	// Test for when the new value will be over the upper limit
	void instrumentPositiveRelativeAlterationOverTest() {
		player.setInstrument(Instrument.maxInstrument);
		int change = 4;
		new InstrumentRelativeAlteration(change).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(Instrument.maxInstrument,afterAlteration);
	}
	
	@Test
	// Test for when the new value will be under the lower limit
	void instrumentNegativeRelativeAlterationUnderTest() {
		player.setInstrument(Instrument.minInstrument);
		int change = -5;
		new InstrumentRelativeAlteration(change).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(Instrument.minInstrument,afterAlteration);
	}
	
	@Test
	// Test to verify if the symbol doesn't change any other parameter
	void onlyOneAlterationTest() {
		int initialVolume = player.getVolume();
		int initialBPM = player.getBPM();
		int initialOctave= player.getOctave();
		int change = 6;
		new InstrumentRelativeAlteration(change).alterPlayer(player);
		assertTrue(initialVolume == player.getVolume() && initialBPM == player.getBPM() && initialOctave == player.getOctave());
	}

}
