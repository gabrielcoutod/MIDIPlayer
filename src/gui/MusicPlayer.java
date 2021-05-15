package gui;

import javax.swing.SwingWorker;

import player.InputConverter;
import player.TCPlayer;

// Swing worker class for playing the song
class MusicPlayer extends SwingWorker<Void, Void> {

	// Attributes
	private boolean running = false;
	private String text;

	// Argument constructor
	public MusicPlayer(String text) {
		this.text = text;
	}

	// Default constructor
	public MusicPlayer() {
		this.text = "";
	}

	// Setter for text
	public void setText(String text) {
		this.text = text;
	}

	// Getter for running
	public boolean isRunning() {
		return running;
	}

	@Override
	protected Void doInBackground() throws Exception {
		running = true;
		new TCPlayer().play(InputConverter.convert(text));
		return null;
	}

	@Override
	protected void done() {
		running = false;
	}
}