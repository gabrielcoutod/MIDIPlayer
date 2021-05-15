package gui;

// Class for controlling the music player swing worker
public class MusicPlayerController {
	
	// Attribute
	private MusicPlayer musicPlayer = new MusicPlayer();

	// Getter for running in musicPlayer
	public boolean isRunning() {
		return musicPlayer.isRunning();
	}

	// Cancel the execution of the worker
	public void cancel(boolean mayInterruptIfRunning) {
		musicPlayer.cancel(mayInterruptIfRunning);
	}

	// Run the worker
	public void execute(String text) {
		musicPlayer = new MusicPlayer(text);
		musicPlayer.execute();
	}
}