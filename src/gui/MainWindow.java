package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import gui.Help;
import gui.About;
import player.InputConverter;
import player.TCPlayer;

class MusicPlayer extends SwingWorker<Void, Void> {
	
	
	private boolean running = false;
	private String text;
	
	public MusicPlayer(String text) {
		this.text = text;
	}
	
	public MusicPlayer() {
		this.text = "";
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		// TODO Auto-generated method stub
		running = true;
		new TCPlayer().play(InputConverter.convert(text));
		return null;
	}

	@Override
	protected void done() {
		running = false;
	}
}

class MusicPlayerController {
	private MusicPlayer musicPlayer = new MusicPlayer();
	
	
	public boolean isRunning() {
		return musicPlayer.isRunning();
	}
	
	public void cancel(boolean mayInterruptIfRunning) {
		musicPlayer.cancel(mayInterruptIfRunning);
	}
	
	public void execute(String text) {
		musicPlayer = new MusicPlayer(text);
		musicPlayer.execute();
	}
}
 
public class MainWindow {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Frame code
		
		frame = new JFrame("MIDI Player");
		frame.setBounds(100, 100, 914, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Notes panel code
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 875, 474);
		frame.getContentPane().add(panel);
		
		JPanel notesPanel = new JPanel();
		notesPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		notesPanel.setBounds(0, 32, 184, 432);
		panel.add(notesPanel);
		notesPanel.setLayout(null);

		JLabel lblNotes = new JLabel("Nota");
		lblNotes.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		lblNotes.setBounds(10, 10, 62, 23);
		notesPanel.add(lblNotes);

		JButton btnAddNote = new JButton("Adicionar");
		btnAddNote.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		btnAddNote.setBounds(27, 381, 124, 29);
		notesPanel.add(btnAddNote);


		List<JCheckBox> checkBoxNotes = new ArrayList<JCheckBox>();

		JCheckBox checkBoxC = new JCheckBox("C");
		checkBoxC.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxC.setBounds(10, 39, 50, 21);
		checkBoxC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JCheckBox checkBox: checkBoxNotes) {
					checkBox.setSelected(false);
				}
				checkBoxC.setSelected(true);
			}
		});
		checkBoxNotes.add(checkBoxC);
		notesPanel.add(checkBoxC);

		JCheckBox checkBoxD = new JCheckBox("D");
		checkBoxD.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxD.setBounds(10, 65, 50, 21);
		checkBoxD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JCheckBox checkBox: checkBoxNotes) {
					checkBox.setSelected(false);
				}
				checkBoxD.setSelected(true);
			}
		});
		checkBoxNotes.add(checkBoxD);
		notesPanel.add(checkBoxD);

		JCheckBox checkBoxE = new JCheckBox("E");
		checkBoxE.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxE.setBounds(10, 97, 50, 21);
		checkBoxE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JCheckBox checkBox: checkBoxNotes) {
					checkBox.setSelected(false);
				}
				checkBoxE.setSelected(true);
			}
		});
		checkBoxNotes.add(checkBoxE);
		notesPanel.add(checkBoxE);

		JCheckBox checkBoxF = new JCheckBox("F");
		checkBoxF.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxF.setBounds(10, 131, 50, 21);
		checkBoxF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JCheckBox checkBox: checkBoxNotes) {
					checkBox.setSelected(false);
				}
				checkBoxF.setSelected(true);
			}
		});
		checkBoxNotes.add(checkBoxF);
		notesPanel.add(checkBoxF);

		JCheckBox checkBoxG = new JCheckBox("G");
		checkBoxG.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxG.setBounds(10, 162, 50, 21);
		checkBoxG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JCheckBox checkBox: checkBoxNotes) {
					checkBox.setSelected(false);
				}
				checkBoxG.setSelected(true);
			}
		});
		checkBoxNotes.add(checkBoxG);
		notesPanel.add(checkBoxG);

		JCheckBox checkBoxA = new JCheckBox("A");
		checkBoxA.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxA.setBounds(10, 192, 50, 21);
		checkBoxA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JCheckBox checkBox: checkBoxNotes) {
					checkBox.setSelected(false);
				}
				checkBoxA.setSelected(true);
			}
		});
		checkBoxNotes.add(checkBoxA);
		notesPanel.add(checkBoxA);

		JCheckBox checkBoxB = new JCheckBox("B");
		checkBoxB.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxB.setBounds(10, 222, 50, 21);
		checkBoxB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JCheckBox checkBox: checkBoxNotes) {
					checkBox.setSelected(false);
				}
				checkBoxB.setSelected(true);
			}
		});
		checkBoxNotes.add(checkBoxB);
		notesPanel.add(checkBoxB);

		JCheckBox checkBoxRandom = new JCheckBox("Aleat\u00F3ria");
		checkBoxRandom.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxRandom.setBounds(10, 252, 96, 21);
		checkBoxRandom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JCheckBox checkBox: checkBoxNotes) {
					checkBox.setSelected(false);
				}
				checkBoxRandom.setSelected(true);
			}
		});
		checkBoxNotes.add(checkBoxRandom);
		notesPanel.add(checkBoxRandom);

		JCheckBox checkBoxPause = new JCheckBox("Pausa");
		checkBoxPause.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxPause.setBounds(10, 282, 78, 21);
		checkBoxPause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JCheckBox checkBox: checkBoxNotes) {
					checkBox.setSelected(false);
				}
				checkBoxPause.setSelected(true);
			}
		});
		checkBoxNotes.add(checkBoxPause);
		notesPanel.add(checkBoxPause);
		
		// Options Panel code
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		optionsPanel.setBounds(194, 32, 228, 432);
		panel.add(optionsPanel);
		optionsPanel.setLayout(null);
		
		//TODO
		// Import Max and Min of the sliders
		// from the classes that handle that
		
		JLabel lblOptions = new JLabel("Op\u00E7\u00F5es");
		lblOptions.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		lblOptions.setBounds(10, 10, 62, 23);
		optionsPanel.add(lblOptions);
		
		// Labels and Slider for BPM
		
		JLabel lblBPM = new JLabel("BPM =");
		lblBPM.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblBPM.setBounds(10, 46, 46, 23);
		optionsPanel.add(lblBPM);
		
		JSlider sliderBPM = new JSlider();
		
		JLabel lblBPMValue = new JLabel("");
		lblBPMValue.setLabelFor(sliderBPM);
		lblBPMValue.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblBPMValue.setBounds(52, 46, 46, 23);
		lblBPMValue.setText(Integer.toString(sliderBPM.getValue()));
		optionsPanel.add(lblBPMValue);
		
		
		sliderBPM.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblBPMValue.setText(Integer.toString(sliderBPM.getValue()));
			}
		});
		sliderBPM.setMinimum(50);
		sliderBPM.setMaximum(1000);
		sliderBPM.setBounds(10, 69, 200, 22);
		optionsPanel.add(sliderBPM);
		
		

		// Labels and Slider for Octave
		
		JSlider sliderOctave = new JSlider();
		
		JLabel lblOctaveValue = new JLabel("");
		lblOctaveValue.setLabelFor(sliderOctave);
		lblOctaveValue.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblOctaveValue.setBounds(64, 108, 55, 23);
		lblOctaveValue.setText(Integer.toString(sliderOctave.getValue()));
		optionsPanel.add(lblOctaveValue);
		
		JLabel lblOctave = new JLabel("Oitava = ");
		lblOctave.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblOctave.setBounds(10, 108, 55, 23);
		optionsPanel.add(lblOctave);
		
		
		
		sliderOctave.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblOctaveValue.setText(Integer.toString(sliderOctave.getValue()));
			}
		});
		sliderOctave.setValue(0);
		sliderOctave.setMinimum(-5);
		sliderOctave.setMaximum(5);
		sliderOctave.setBounds(10, 141, 200, 22);
		optionsPanel.add(sliderOctave);
		
		
		// Labels and Slider for Volume

		
		JSlider sliderVolume = new JSlider();
		
		
		JLabel lblVolumeValue = new JLabel("");
		lblVolumeValue.setLabelFor(sliderVolume);
		lblVolumeValue.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblVolumeValue.setBounds(64, 173, 62, 23);
		lblVolumeValue.setText(Integer.toString(sliderVolume.getValue()));
		optionsPanel.add(lblVolumeValue);
		
		sliderVolume.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblVolumeValue.setText(Integer.toString(sliderVolume.getValue()));
			}
		});
		sliderVolume.setValue(10);
		sliderVolume.setBounds(10, 201, 200, 22);
		optionsPanel.add(sliderVolume);
		
		JLabel lblVolume = new JLabel("Volume = ");
		lblVolume.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblVolume.setBounds(10, 173, 62, 23);
		optionsPanel.add(lblVolume);
		
		// Rest of the interface
		
		JButton btnUpdate = new JButton("Atualizar");
		btnUpdate.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		btnUpdate.setBounds(39, 381, 124, 29);
		optionsPanel.add(btnUpdate);
		
		JLabel lblInstruments = new JLabel("Instrumento");
		lblInstruments.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblInstruments.setBounds(10, 260, 77, 23);
		optionsPanel.add(lblInstruments);
		
		JComboBox comboBoxInstruments = new JComboBox();
		comboBoxInstruments.setModel(new DefaultComboBoxModel(new String[] {"Agogo", "Piano", "Sinos", "Flauta", "\u00D3rg\u00E3o"}));
		comboBoxInstruments.setBounds(97, 261, 113, 23);
		optionsPanel.add(comboBoxInstruments);
		
		
		// Song panel code
		JPanel songPanel = new JPanel();
		songPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		songPanel.setBounds(432, 32, 443, 432);
		panel.add(songPanel);
		songPanel.setLayout(null);
		
		JLabel lblSong = new JLabel("M\u00FAsica");
		lblSong.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		lblSong.setBounds(10, 10, 62, 23);
		songPanel.add(lblSong);
		
		JScrollPane songTextPane = new JScrollPane();
		songTextPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		songTextPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		songTextPane.setBounds(10, 43, 297, 379);
		songPanel.add(songTextPane);
		
		JTextArea textSong = new JTextArea();
		textSong.setLineWrap(true);
		textSong.setWrapStyleWord(true);
		textSong.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		songTextPane.setViewportView(textSong);
		
		JButton btnPlaySong = new JButton("Tocar");
		btnPlaySong.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		btnPlaySong.setBounds(328, 61, 85, 36);
		songPanel.add(btnPlaySong);
		MusicPlayerController controller = new MusicPlayerController();
		btnPlaySong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!controller.isRunning()) {
					controller.execute(textSong.getText());
				}
			}
		});
		
		JButton btnClean = new JButton("Limpar");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSong.setText("");
			}
		});
		btnClean.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		btnClean.setBounds(328, 123, 85, 36);
		songPanel.add(btnClean);
		
		btnAddNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				if(checkBoxA.isSelected()) {
					textSong.append("A");
				} else if(checkBoxB.isSelected()) {
					textSong.append("B");
				} else if(checkBoxC.isSelected()) {
					textSong.append("C");
				} else if(checkBoxD.isSelected()) {
					textSong.append("D");
				} else if(checkBoxE.isSelected()) {
					textSong.append("E");
				} else if(checkBoxF.isSelected()) {
					textSong.append("F");
				} else if(checkBoxG.isSelected()) {
					textSong.append("G");
				} else if(checkBoxRandom.isSelected()) {
					List<String> notesList = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
					Random rand = new Random();
				    String randomNote = notesList.get(rand.nextInt(notesList.size()));
				    textSong.append(randomNote);
				} else if(checkBoxPause.isSelected()) {
					textSong.append("P");
				}
			}
		});
		
		//Menu bar code

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 275, 22);
		panel.add(menuBar);

		JMenu fileMenu = new JMenu("Arquivo");
		menuBar.add(fileMenu);
		fileMenu.setUI(new JMenuItem("Arquivo").getUI());
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		JMenuItem menuItemOpenTextFile = new JMenuItem("Abrir arquivo de texto");
		fileMenu.add(menuItemOpenTextFile);
		menuItemOpenTextFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int userSelection = fileChooser.showOpenDialog(frame);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					try {
						Scanner useDelimiter = new Scanner(fileChooser.getSelectedFile()).useDelimiter("\\Z");
						String content = useDelimiter.next();
						textSong.setText(content);
						useDelimiter.close();
					} catch (IOException  e1) {
						JOptionPane.showMessageDialog(new JFrame(), "Erro ao abrir arquivo", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		JMenuItem menuItemSaveTextFile = new JMenuItem("Salvar em arquivo de texto");
		fileMenu.add(menuItemSaveTextFile);
		menuItemSaveTextFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int userSelection = fileChooser.showSaveDialog(frame);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					String text = textSong.getText();
					File file = fileChooser.getSelectedFile();
					try {

						if (!file.exists()) {
							file.createNewFile();
							BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), false));
							bw.write(text); 
							bw.close();
						} else {
							int response = JOptionPane.showOptionDialog(new JFrame(), "sobrescrever arquivo?", "Arquivo j� existe", JOptionPane.YES_NO_OPTION, 
									JOptionPane.PLAIN_MESSAGE, null, new String[] {"Sim", "N�o",}, null);
							if (response == 0) {
								BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), false));
								bw.write(text); 
								bw.close();
							}
						}
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(new JFrame(), "Erro ao escrever arquivo", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		JMenuItem menuItemSaveMidi = new JMenuItem("Salvar m\u00FAsica");
		fileMenu.add(menuItemSaveMidi);

		JMenuItem menuItemHelp = new JMenuItem("Ajuda");
		menuItemHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help helpWindow = new Help();
				helpWindow.createWindow();
			}
		});
		menuBar.add(menuItemHelp);

		JMenuItem menuItemAbout = new JMenuItem("Sobre");
		menuItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About aboutWindow = new About();
				aboutWindow.createWindow();
			}
		});
		menuBar.add(menuItemAbout);	
	}
}
