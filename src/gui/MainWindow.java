package gui;

import java.awt.Color;
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
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ChangeEvent;
import gui.Help;
import gui.About;
import player.InputConverter;
import player.TCPlayer;
import symbol.BPMAlteration;
import symbol.OctaveAlteration;
import symbol.VolumeAlteration;

// Class for the main application window
public class MainWindow {

	// Interface components
	private JFrame frame = new JFrame("MIDI Player");
	private JPanel panel = new JPanel();
	private JPanel notesPanel = new JPanel();
	private JPanel optionsPanel = new JPanel();
	private JPanel songPanel = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JTextArea textSong = new JTextArea();
	private JSlider sliderBPM = new JSlider();
	private JSlider sliderVolume = new JSlider();
	private JSlider sliderOctave = new JSlider();
	private JComboBox comboBoxInstruments = new JComboBox();
	private String[] instrumentsArray = new String[] {"O", "!", "\n", ";", ","};
	private JButton btnUpdate = new JButton("Atualizar");
	private JCheckBox checkBoxC = new JCheckBox("C");
	private JCheckBox checkBoxD = new JCheckBox("D");
	private JCheckBox checkBoxE = new JCheckBox("E");
	private JCheckBox checkBoxF = new JCheckBox("F");
	private JCheckBox checkBoxG = new JCheckBox("G");
	private JCheckBox checkBoxA = new JCheckBox("A");
	private JCheckBox checkBoxB = new JCheckBox("B");
	private JCheckBox checkBoxRandom = new JCheckBox("Aleat\u00F3ria");
	private JCheckBox checkBoxPause = new JCheckBox("Pausa");
	private JButton btnAddNote = new JButton("Adicionar");
	private JMenu fileMenu = new JMenu("Arquivo");
	private JMenuItem menuItemHelp = new JMenuItem("Ajuda");
	private JMenuItem menuItemAbout = new JMenuItem("Sobre");

	// create window
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

	// create frame
	public MainWindow() {
		initialize();
	}
	
	// initializes frame and its components
	private void initialize() {
		initFrame();
		initPanel();
		initNotesPanel();
		initOptionsPanel();
		initSongPanel();
		initMenuBar();
	}
	
	// Initializes frame
	private void initFrame() {
		frame.setBounds(100, 100, 914, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	// Initializes panel
	private void initPanel() {
		panel.setLayout(null);
		panel.setBounds(10, 10, 875, 474);
		frame.getContentPane().add(panel);
	}
	
	// Initializes notes panel
	private void initNotesPanel() {
		notesPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		notesPanel.setBounds(0, 32, 184, 432);
		panel.add(notesPanel);
		notesPanel.setLayout(null);

		JLabel lblNotes = new JLabel("Nota");
		lblNotes.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		lblNotes.setBounds(10, 10, 62, 23);
		notesPanel.add(lblNotes);

		btnAddNote.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		btnAddNote.setBounds(27, 381, 124, 29);
		notesPanel.add(btnAddNote);

		List<JCheckBox> checkBoxNotes = new ArrayList<JCheckBox>();
		checkBoxNotes.add(checkBoxC);
		checkBoxNotes.add(checkBoxD);
		checkBoxNotes.add(checkBoxE);
		checkBoxNotes.add(checkBoxF);
		checkBoxNotes.add(checkBoxG);
		checkBoxNotes.add(checkBoxA);
		checkBoxNotes.add(checkBoxB);
		checkBoxNotes.add(checkBoxPause);
		checkBoxNotes.add(checkBoxRandom);
		
		int currentY = 39;
		for (JCheckBox note: checkBoxNotes) {
			note.setFont(new Font("Noto Sans", Font.PLAIN, 14));
			note.setBounds(10, currentY, 100, 21);
			note.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (JCheckBox checkBox : checkBoxNotes) {
						checkBox.setSelected(false);
					}
					note.setSelected(true);
				}
			});
			notesPanel.add(note);
			currentY += 30;
		}
	}

	// Initializes options panel
	private void initOptionsPanel() {
		optionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		optionsPanel.setBounds(194, 32, 228, 432);
		panel.add(optionsPanel);
		optionsPanel.setLayout(null);


		JLabel lblOptions = new JLabel("Op\u00E7\u00F5es");
		lblOptions.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		lblOptions.setBounds(10, 10, 62, 23);
		optionsPanel.add(lblOptions);
		
		btnUpdate.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		btnUpdate.setBounds(39, 381, 124, 29);
		optionsPanel.add(btnUpdate);
		
		initBPMSlider();
		initOctaveSlider();
		initVolumeSlider();
		initInstrumentsComboBox();
	}
	
	// Initializes BPM options
	private void initBPMSlider(){
		JLabel lblBPM = new JLabel("BPM");
		lblBPM.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblBPM.setBounds(10, 46, 46, 23);
		optionsPanel.add(lblBPM);

		JLabel lblBPMValue = new JLabel("");
		lblBPMValue.setLabelFor(sliderBPM);
		lblBPMValue.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblBPMValue.setBounds(40, 46, 46, 23);
		lblBPMValue.setText(Integer.toString(sliderBPM.getValue()));
		optionsPanel.add(lblBPMValue);

		sliderBPM.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int change = sliderBPM.getValue();
				boolean passedHalf = (change/(BPMAlteration.alteration/2 + 1) != 0);
				if (!passedHalf) {
					lblBPMValue.setText("atual");
				} else {
					lblBPMValue.setText(String.format("%+d", change/Math.abs(change) * BPMAlteration.alteration));
				}
			}
		});
		sliderBPM.setValue(0);
		sliderBPM.setMinimum(BPMAlteration.negativeAlteration);
		sliderBPM.setMaximum(BPMAlteration.positiveAlteration);
		sliderBPM.setMajorTickSpacing(BPMAlteration.alteration);
		sliderBPM.setSnapToTicks(true);
		sliderBPM.setBounds(10, 69, 200, 22);
		optionsPanel.add(sliderBPM);
	}
	
	// Initializes octave options
	private void initOctaveSlider(){
		JLabel lblOctaveValue = new JLabel("");
		lblOctaveValue.setLabelFor(sliderOctave);
		lblOctaveValue.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblOctaveValue.setBounds(50, 108, 55, 23);
		lblOctaveValue.setText(Integer.toString(sliderOctave.getValue()));
		optionsPanel.add(lblOctaveValue);

		JLabel lblOctave = new JLabel("Oitava");
		lblOctave.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblOctave.setBounds(10, 108, 55, 23);
		optionsPanel.add(lblOctave);

		sliderOctave.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int change = sliderOctave.getValue();
				if (change == 0) {
					lblOctaveValue.setText("atual");
				} else {
					lblOctaveValue.setText(String.format("%+d", change));
				}
			}
		});
		sliderOctave.setValue(0);
		sliderOctave.setMinimum(OctaveAlteration.negativeAlteration);
		sliderOctave.setMaximum(OctaveAlteration.positiveAlteration);
		sliderOctave.setBounds(10, 141, 200, 22);
		optionsPanel.add(sliderOctave);
	}
	
	// Initializes volume options
	private void initVolumeSlider(){
		JLabel lblVolumeValue = new JLabel("");
		lblVolumeValue.setLabelFor(sliderVolume);
		lblVolumeValue.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblVolumeValue.setBounds(56, 173, 62, 23);
		lblVolumeValue.setText(Integer.toString(sliderVolume.getValue()));
		optionsPanel.add(lblVolumeValue);

		sliderVolume.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int change = sliderVolume.getValue();
				boolean passedHalf = (change/(VolumeAlteration.alteration/2 + 1) != 0);
				if (!passedHalf) {
					lblVolumeValue.setText("atual");
				} else {
					lblVolumeValue.setText(String.format("%+d", change/Math.abs(change) * VolumeAlteration.alteration));
				}
			}
		});
		sliderVolume.setValue(0);
		sliderVolume.setMaximum(VolumeAlteration.positiveAlteration);
		sliderVolume.setMinimum(VolumeAlteration.negativeAlteration);
		sliderVolume.setMajorTickSpacing(VolumeAlteration.alteration);
		sliderVolume.setSnapToTicks(true);
		sliderVolume.setBounds(10, 201, 200, 22);
		optionsPanel.add(sliderVolume);

		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblVolume.setBounds(10, 173, 62, 23);
		optionsPanel.add(lblVolume);
	}
	
	// Initializes instrument options
	private void initInstrumentsComboBox() {
		JLabel lblInstruments = new JLabel("Instrumento");
		lblInstruments.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		lblInstruments.setBounds(10, 260, 77, 23);
		optionsPanel.add(lblInstruments);

		comboBoxInstruments.setModel(
				new DefaultComboBoxModel(new String[] {"Atual", "Piano", "Agogo", "Sinos", "Flauta", "\u00D3rg\u00E3o" }));
		comboBoxInstruments.setBounds(97, 261, 113, 23);
		optionsPanel.add(comboBoxInstruments);
	}
	
	// Initializes music panel
	private void initSongPanel() {
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

		textSong.setLineWrap(true);
		textSong.setWrapStyleWord(true);
		textSong.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		songTextPane.setViewportView(textSong);
		textSong.addInputMethodListener(null);
		
		initButtonPlay();
		initButtonClean();
		initButtonaddNote();
		initButtonUpdate();
	}

	// initializes the play button
	private void initButtonPlay() {
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
	}
	
	// Initializes the clean button
	private void initButtonClean() {
		JButton btnClean = new JButton("Limpar");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSong.setText("");
			}
		});
		btnClean.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		btnClean.setBounds(328, 123, 85, 36);
		songPanel.add(btnClean);
	}
	
	// Initializes the add note button
	private void initButtonaddNote() {
		btnAddNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBoxA.isSelected()) {
					textSong.append("A");
				} else if (checkBoxB.isSelected()) {
					textSong.append("B");
				} else if (checkBoxC.isSelected()) {
					textSong.append("C");
				} else if (checkBoxD.isSelected()) {
					textSong.append("D");
				} else if (checkBoxE.isSelected()) {
					textSong.append("E");
				} else if (checkBoxF.isSelected()) {
					textSong.append("F");
				} else if (checkBoxG.isSelected()) {
					textSong.append("G");
				} else if (checkBoxRandom.isSelected()) {
					List<String> notesList = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
					Random rand = new Random();
					String randomNote = notesList.get(rand.nextInt(notesList.size()));
					textSong.append(randomNote);
				} else if (checkBoxPause.isSelected()) {
					textSong.append("P");
				}
			}
		});
	}
	
	// Initializes the update button
	private void initButtonUpdate() {
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sliderBPM.getValue() != 0) {
					if(sliderBPM.getValue() > 0)
						textSong.append("BPM+");
					else
						textSong.append("BPM-");
					sliderBPM.setValue(0);
				}
				if(sliderVolume.getValue() != 0) {
					if(sliderVolume.getValue() > 0)
						textSong.append("+");
					else
						textSong.append("-");
					sliderVolume.setValue(0);
				}
				if(sliderOctave.getValue() != 0){
					if(sliderOctave.getValue() > 0)
						textSong.append("T+");
					else
						textSong.append("T-");
					sliderOctave.setValue(0);
				}
				if(comboBoxInstruments.getSelectedIndex() != 0) {
					textSong.append(instrumentsArray[comboBoxInstruments.getSelectedIndex() - 1]);
					comboBoxInstruments.setSelectedIndex(0);
				}
				
				
			}
		});
	}
	
	// Initializes menu bar
	private void initMenuBar() {
		JMenuBar fileMenuBar = new JMenuBar();
		fileMenuBar.setBounds(0, 0, 60, 22);
		menuBar.setBounds(60, 0,120, 22);
		panel.add(fileMenuBar);
		panel.add(menuBar);

		fileMenuBar.add(fileMenu);
		fileMenu.setUI(new JMenuItem("Arquivo").getUI());
		
		initOpenText();
		initSaveText();
		initSaveMusic();
		initHelp();
		initAbout();

	}
	
	// Initializes the open text button
	private void initOpenText() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("Arquivos TXT (*.txt)", "txt");
		fileChooser.setFileFilter(extFilter);
		
		JMenuItem menuItemOpenTextFile = new JMenuItem("Abrir arquivo de texto");
		fileMenu.add(menuItemOpenTextFile);
		menuItemOpenTextFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int userSelection = fileChooser.showOpenDialog(frame);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					try (Scanner useDelimiter = new Scanner(fileChooser.getSelectedFile()).useDelimiter("\\Z")) {
						String content = useDelimiter.next();
						textSong.setText(content);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(new JFrame(), "Erro ao abrir arquivo", "ERRO",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}

	// Initializes the save text button
	private void initSaveText() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("Arquivos TXT (*.txt)", "txt");
		fileChooser.setFileFilter(extFilter);
		
		JMenuItem menuItemSaveTextFile = new JMenuItem("Salvar em arquivo de texto");
		fileMenu.add(menuItemSaveTextFile);
		menuItemSaveTextFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int userSelection = fileChooser.showSaveDialog(frame);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					String text = textSong.getText();
					File file = fileChooser.getSelectedFile();
					if (!file.exists()) {
						String path = file.getAbsolutePath();
						int indexDot = path.indexOf('.');
						if (indexDot == -1) {
							path = path + ".txt";
							file = new File(path);
						} else if (path.length() - 1 == indexDot) {
							path = path.substring(0, path.lastIndexOf('.')) + ".txt";
							file = new File(path);
						}
						if (!file.exists()) {
							try (BufferedWriter bw = new BufferedWriter(
									new FileWriter(file.getAbsoluteFile(), false))) {
								bw.write(text);
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(new JFrame(), "Erro ao escrever arquivo", "ERRO",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							int response = JOptionPane.showOptionDialog(new JFrame(), "Sobrescrever arquivo?",
									"Arquivo já existe", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
									new String[] { "Sim", "Não", }, null);
							if (response == 0) {
								try (BufferedWriter bw = new BufferedWriter(
										new FileWriter(file.getAbsoluteFile(), false))) {
									bw.write(text);
								} catch (IOException e2) {
									JOptionPane.showMessageDialog(new JFrame(), "Erro ao escrever arquivo", "ERRO",
											JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					} else {
						int response = JOptionPane.showOptionDialog(new JFrame(), "Sobrescrever arquivo?",
								"Arquivo já existe", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
								new String[] { "Sim", "Não", }, null);
						if (response == 0) {
							try (BufferedWriter bw = new BufferedWriter(
									new FileWriter(file.getAbsoluteFile(), false))) {
								bw.write(text);
							} catch (IOException e3) {
								JOptionPane.showMessageDialog(new JFrame(), "Erro ao escrever arquivo", "ERRO",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});
	}
	
	// Initializes the save music button
	private void initSaveMusic() {
		JMenuItem menuItemSaveMidi = new JMenuItem("Salvar m\u00FAsica");
		fileMenu.add(menuItemSaveMidi);
		JFileChooser MIDIfileChooser = new JFileChooser();
		MIDIfileChooser.setCurrentDirectory(new File("."));
		MIDIfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter MIDIFilter = new FileNameExtensionFilter("Arquivos MIDI (*.midi)", "midi");
		MIDIfileChooser.setAcceptAllFileFilterUsed(false);
		MIDIfileChooser.setFileFilter(MIDIFilter);
		menuItemSaveMidi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int userSelection = MIDIfileChooser.showSaveDialog(frame);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File file = MIDIfileChooser.getSelectedFile();
					String path = file.getAbsolutePath();
					int indexDot = path.indexOf('.');
					if (indexDot == -1) {
						path = path + ".midi";
						file = new File(path);
					} else {
						path = path.substring(0, path.lastIndexOf('.')) + ".midi";
						file = new File(path);
					}
					if (!file.exists()) {
						try (FileOutputStream stream = new FileOutputStream(file)) {
							new TCPlayer().save(InputConverter.convert(textSong.getText()), stream);
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(new JFrame(), "Erro ao escrever arquivo", "ERRO",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						int response = JOptionPane.showOptionDialog(new JFrame(), "Sobrescrever arquivo?",
								"Arquivo já existe", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
								new String[] { "Sim", "Não", }, null);
						if (response == 0) {
							try (FileOutputStream stream = new FileOutputStream(file)) {
								new TCPlayer().save(InputConverter.convert(textSong.getText()), stream);
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(new JFrame(), "Erro ao escrever arquivo", "ERRO",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});
	}
	
	// Initializes the help button
	private void initHelp() {
		menuItemHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help helpWindow = new Help();
				helpWindow.createWindow();
			}
		});
		menuBar.add(menuItemHelp);
	}
	
	// Initializes the about button
	private void initAbout() {
		menuItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About aboutWindow = new About();
				aboutWindow.createWindow();
			}
		});
		menuBar.add(menuItemAbout);
	}
}
