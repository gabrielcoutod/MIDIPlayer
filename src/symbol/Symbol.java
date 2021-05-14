package symbol;

import player.TCPlayer;

//Symbol is an abstract superclass for all 
//the symbols that can be read as input.
public abstract class Symbol {
	
	// A symbol must alter the player in some way
    public abstract void alterPlayer(TCPlayer player);
}
