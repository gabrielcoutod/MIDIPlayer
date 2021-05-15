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
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ChangeEvent;
import player.InputConverter;
import player.TCPlayer;
import symbol.BPMAlteration;
import symbol.OctaveAlteration;
import symbol.VolumeAlteration;

// Class for the main application window
public class MainWindow {
	// Size of font
	private final int FONTSIZE = 12;
	
	
	// Coordinates for the elements
	
	// Window
	private final int WINDOW_START_X = 100;
	private final int WINDOW_START_Y = 100;
	private final int WINDOW_WIDTH = 914;
	private final int WINDOW_HEIGHT = 531;

	
	// Main panel
	private final int MAINPANEL_START_X = 10;
	private final int MAINPANEL_START_Y = 10;
	private final int MAINPANEL_WIDTH = 875;
	private final int MAINPANEL_HEIGHT = 474;
	
	// Size of sliders
	private final int SLIDER_WIDTH = 200;
	private final int SLIDER_HEIGHT = 22;
	
	// Notes panel
	private final int NOTESPANEL_START_X = 0;
	private final int NOTESPANEL_START_Y = 32;
	private final int NOTESPANEL_WIDTH = 184;
	private final int NOTESPANEL_HEIGHT = 432;
	

	private final int NOTELABEL_START_X = 10;
	private final int NOTELABEL_START_Y = 10;
	private final int NOTELABEL_WIDTH = 62;
	private final int NOTELABEL_HEIGHT = 23;
	
	private final int NOTEBUTTON_START_X = 27;
	private final int NOTEBUTTON_START_Y = 381;
	private final int NOTEBUTTON_WIDTH = 124;
	private final int NOTEBUTTON_HEIGHT = 29;
	
	private final int NOTECHECKBOX_START_X = 10;
	private final int NOTECHECKBOX_START_Y = 39;
	private final int NOTECHECKBOX_WIDTH = 100;
	private final int NOTECHECKBOX_HEIGHT = 21;
	private final int NOTECHECKBOX_DISTANCE = 30;
	
	// Options Panel
	private final int OPTIONSPANEL_START_X = 194;
	private final int OPTIONSPANEL_START_Y = 32;
	private final int OPTIONSPANEL_WIDTH = 228;
	private final int OPTIONSPANEL_HEIGHT = 432;
	

	private final int OPTIONSLABEL_START_X = 10;
	private final int OPTIONSLABEL_START_Y = 10;
	private final int OPTIONSLABEL_WIDTH = 62;
	private final int OPTIONSLABEL_HEIGHT = 23;
	

	private final int UPDATEBUTTON_START_X = 39;
	private final int UPDATEBUTTON_START_Y = 381;
	private final int UPDATEBUTTON_WIDTH = 124;
	private final int UPDATEBUTTON_HEIGHT = 29;
	
	// BPM
	private final int BPMLABEL_START_X = 10;
	private final int BPMLABEL_START_Y = 46;
	private final int BPMLABEL_WIDTH = 46;
	private final int BPMLABEL_HEIGHT = 23;
	
	private final int BPMVALUE_START_X = 40;
	private final int BPMVALUE_START_Y = 46;
	private final int BPMVALUE_WIDTH = 46;
	private final int BPMVALUE_HEIGHT = 23;
	
	private final int BPMSLIDER_START_X = 10;
	private final int BPMSLIDER_START_Y = 69;
	
	
	// Octave
	private final int OCTAVELABEL_START_X = 10;
	private final int OCTAVELABEL_START_Y = 108;
	private final int OCTAVELABEL_WIDTH = 55;
	private final int OCTAVELABEL_HEIGHT = 23;
	
	private final int OCTAVEVALUE_START_X = 50;
	private final int OCTAVEVALUE_START_Y = 108;
	private final int OCTAVEVALUE_WIDTH = 55;
	private final int OCTAVEVALUE_HEIGHT = 23;


	private final int OCTAVESLIDER_START_X = 10;
	private final int OCTAVESLIDER_START_Y = 141;
	
	// Volume
	private final int VOLUMELABEL_START_X = 10;
	private final int VOLUMELABEL_START_Y = 173;
	private final int VOLUMELABEL_WIDTH = 62;
	private final int VOLUMELABEL_HEIGHT = 23;
	
	private final int VOLUMEVALUE_START_X = 56;
	private final int VOLUMEVALUE_START_Y = 173;
	private final int VOLUMEVALUE_WIDTH = 62;
	private final int VOLUMEVALUE_HEIGHT = 23;

	private final int VOLUMESLIDER_START_X = 10;
	private final int VOLUMESLIDER_START_Y = 201;
	
	// Instrument
	private final int INSTRUMENTSLABEL_START_X = 10;
	private final int INSTRUMENTSLABEL_START_Y = 260;
	private final int INSTRUMENTSLABEL_WIDTH = 77;
	private final int INSTRUMENTSLABEL_HEIGHT = 23;
	
	private final int INSTRUMENTSCOMBOBOX_START_X = 97;
	private final int INSTRUMENTSCOMBOBOX_START_Y = 261;
	private final int INSTRUMENTSCOMBOBOX_WIDTH = 113;
	private final int INSTRUMENTSCOMBOBOX_HEIGHT = 23;
	
	
	// Song Panel

	private final int SONGPANEL_START_X = 432;
	private final int SONGPANEL_START_Y = 32;
	private final int SONGPANEL_WIDTH = 443;
	private final int SONGPANEL_HEIGHT = 432;
	
	private final int SONGLABEL_START_X = 10;
	private final int SONGLABEL_START_Y = 10;
	private final int SONGLABEL_WIDTH = 60;
	private final int SONGLABEL_HEIGHT = 23;
	
	private final int SONGTEXT_START_X = 10;
	private final int SONGTEXT_START_Y = 43;
	private final int SONGTEXT_WIDTH = 297;
	private final int SONGTEXT_HEIGHT = 379;
	
	private final int PLAYBUTTON_START_X = 328;
	private final int PLAYBUTTON_START_Y = 61;
	private final int PLAYBUTTON_WIDTH = 85;
	private final int PLAYBUTTON_HEIGHT = 36;
	
	private final int CLEARBUTTON_START_X = 328;
	private final int CLEARBUTTON_START_Y = 123;
	private final int CLEARBUTTON_WIDTH = 85;
	private final int CLEARBUTTON_HEIGHT = 36;
	
	// Menu bar
	private final int MENUBAR_START_X = 60;
	private final int MENUBAR_START_Y = 0;
	private final int MENUBAR_WIDTH = 120;
	private final int MENUBAR_HEIGHT = 22;
	
	private final int FILEMENU_START_X = 0;
	private final int FILEMENU_START_Y = 0;
	private final int FILEMENU_WIDTH = 60;
	private final int FILEMENU_HEIGHT = 22;
	
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
	private JCheckBox checkBoxRandom = new JCheckBox("Aleat�ria");
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
		frame.setBounds(WINDOW_START_X, WINDOW_START_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	// Initializes panel
	private void initPanel() {
		panel.setLayout(null);
		panel.setBounds(MAINPANEL_START_X, MAINPANEL_START_Y, MAINPANEL_WIDTH, MAINPANEL_HEIGHT);
		frame.getContentPane().add(panel);
	}
	
	// Initializes notes panel
	private void initNotesPanel() {
		notesPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		notesPanel.setBounds(NOTESPANEL_START_X, NOTESPANEL_START_Y, NOTESPANEL_WIDTH, NOTESPANEL_HEIGHT);
		panel.add(notesPanel);
		notesPanel.setLayout(null);

		JLabel lblNotes = new JLabel("Nota");
		lblNotes.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		lblNotes.setBounds(NOTELABEL_START_X, NOTELABEL_START_Y, NOTELABEL_WIDTH, NOTELABEL_HEIGHT);
		notesPanel.add(lblNotes);

		btnAddNote.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		btnAddNote.setBounds(NOTEBUTTON_START_X, NOTEBUTTON_START_Y, NOTEBUTTON_WIDTH, NOTEBUTTON_HEIGHT);
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
		
		int currentY = NOTECHECKBOX_START_Y;
		for (JCheckBox note: checkBoxNotes) {
			note.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
			note.setBounds(NOTECHECKBOX_START_X, currentY, NOTECHECKBOX_WIDTH, NOTECHECKBOX_HEIGHT);
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
			currentY += NOTECHECKBOX_DISTANCE;
		}
	}

	// Initializes options panel
	private void initOptionsPanel() {
		optionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		optionsPanel.setBounds(OPTIONSPANEL_START_X, OPTIONSPANEL_START_Y, OPTIONSPANEL_WIDTH, OPTIONSPANEL_HEIGHT);
		panel.add(optionsPanel);
		optionsPanel.setLayout(null);


		JLabel lblOptions = new JLabel("Op��es");
		lblOptions.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		lblOptions.setBounds(OPTIONSLABEL_START_X, OPTIONSLABEL_START_Y, OPTIONSLABEL_WIDTH, OPTIONSLABEL_HEIGHT);
		optionsPanel.add(lblOptions);
		
		btnUpdate.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		btnUpdate.setBounds(UPDATEBUTTON_START_X, UPDATEBUTTON_START_Y, UPDATEBUTTON_WIDTH, UPDATEBUTTON_HEIGHT);
		optionsPanel.add(btnUpdate);
		
		initBPMSlider();
		initOctaveSlider();
		initVolumeSlider();
		initInstrumentsComboBox();
	}
	
	// Initializes BPM options
	private void initBPMSlider(){
		JLabel lblBPM = new JLabel("BPM");
		lblBPM.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		lblBPM.setBounds(BPMLABEL_START_X, BPMLABEL_START_Y, BPMLABEL_WIDTH, BPMLABEL_HEIGHT);
		optionsPanel.add(lblBPM);

		JLabel lblBPMValue = new JLabel("");
		lblBPMValue.setLabelFor(sliderBPM);
		lblBPMValue.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		lblBPMValue.setBounds(BPMVALUE_START_X, BPMVALUE_START_Y, BPMVALUE_WIDTH, BPMVALUE_HEIGHT);
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
		sliderBPM.setBounds(BPMSLIDER_START_X, BPMSLIDER_START_Y, SLIDER_WIDTH, SLIDER_HEIGHT);
		optionsPanel.add(sliderBPM);
	}
	
	// Initializes octave options
	private void initOctaveSlider(){
		JLabel lblOctaveValue = new JLabel("");
		lblOctaveValue.setLabelFor(sliderOctave);
		lblOctaveValue.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		lblOctaveValue.setBounds(OCTAVEVALUE_START_X, OCTAVEVALUE_START_Y, OCTAVEVALUE_WIDTH, OCTAVEVALUE_HEIGHT);
		lblOctaveValue.setText(Integer.toString(sliderOctave.getValue()));
		optionsPanel.add(lblOctaveValue);

		JLabel lblOctave = new JLabel("Oitava");
		lblOctave.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		lblOctave.setBounds(OCTAVELABEL_START_X, OCTAVELABEL_START_Y, OCTAVELABEL_WIDTH, OCTAVELABEL_HEIGHT);
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
		sliderOctave.setBounds(OCTAVESLIDER_START_X, OCTAVESLIDER_START_Y, SLIDER_WIDTH, SLIDER_HEIGHT);
		optionsPanel.add(sliderOctave);
	}
	
	// Initializes volume options
	private void initVolumeSlider(){
		JLabel lblVolumeValue = new JLabel("");
		lblVolumeValue.setLabelFor(sliderVolume);
		lblVolumeValue.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		lblVolumeValue.setBounds(VOLUMEVALUE_START_X, VOLUMEVALUE_START_Y, VOLUMEVALUE_WIDTH, VOLUMEVALUE_HEIGHT);

		
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
		sliderVolume.setBounds(VOLUMESLIDER_START_X, VOLUMESLIDER_START_Y, SLIDER_WIDTH, SLIDER_HEIGHT);
		optionsPanel.add(sliderVolume);

		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		lblVolume.setBounds(VOLUMELABEL_START_X, VOLUMELABEL_START_Y, VOLUMELABEL_WIDTH, VOLUMELABEL_HEIGHT);

		
		optionsPanel.add(lblVolume);
	}
	
	// Initializes instrument options
	private void initInstrumentsComboBox() {
		JLabel lblInstruments = new JLabel("Instrumento");
		lblInstruments.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		lblInstruments.setBounds(INSTRUMENTSLABEL_START_X, INSTRUMENTSLABEL_START_Y, INSTRUMENTSLABEL_WIDTH, INSTRUMENTSLABEL_HEIGHT);
		optionsPanel.add(lblInstruments);

		comboBoxInstruments.setModel(
				new DefaultComboBoxModel(new String[] {"Atual", "Piano", "Agogo", "Sinos", "Flauta", "�rg�o" }));
		comboBoxInstruments.setBounds(INSTRUMENTSCOMBOBOX_START_X, INSTRUMENTSCOMBOBOX_START_Y, INSTRUMENTSCOMBOBOX_WIDTH, INSTRUMENTSCOMBOBOX_HEIGHT);
	
		optionsPanel.add(comboBoxInstruments);
	}
	
	// Initializes music panel
	private void initSongPanel() {
		songPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		songPanel.setBounds(SONGPANEL_START_X, SONGPANEL_START_Y, SONGPANEL_WIDTH, SONGPANEL_HEIGHT);
		panel.add(songPanel);
		songPanel.setLayout(null);

		JLabel lblSong = new JLabel("M\u00FAsica");
		lblSong.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		lblSong.setBounds(SONGLABEL_START_X, SONGLABEL_START_Y, SONGLABEL_WIDTH, SONGLABEL_HEIGHT);		
		songPanel.add(lblSong);

		JScrollPane songTextPane = new JScrollPane();
		songTextPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		songTextPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		songTextPane.setBounds(SONGTEXT_START_X, SONGTEXT_START_Y, SONGTEXT_WIDTH, SONGTEXT_HEIGHT);
		songPanel.add(songTextPane);

		textSong.setLineWrap(true);
		textSong.setWrapStyleWord(true);
		textSong.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
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
		btnPlaySong.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		btnPlaySong.setBounds(PLAYBUTTON_START_X, PLAYBUTTON_START_Y, PLAYBUTTON_WIDTH, PLAYBUTTON_HEIGHT);
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
		btnClean.setFont(new Font("Noto Sans", Font.PLAIN, FONTSIZE));
		btnClean.setBounds(CLEARBUTTON_START_X, CLEARBUTTON_START_Y, CLEARBUTTON_WIDTH, CLEARBUTTON_HEIGHT);
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
		fileMenuBar.setBounds(FILEMENU_START_X, FILEMENU_START_Y, FILEMENU_WIDTH, FILEMENU_HEIGHT);
		menuBar.setBounds(MENUBAR_START_X, MENUBAR_START_Y, MENUBAR_WIDTH, MENUBAR_HEIGHT);
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
		JMenuItem menuItemSaveMidi = new JMenuItem("Salvar m�sica");
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
