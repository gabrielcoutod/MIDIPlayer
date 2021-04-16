package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 914, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		JCheckBox checkBoxC = new JCheckBox("C");
		checkBoxC.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxC.setBounds(10, 39, 50, 21);
		notesPanel.add(checkBoxC);
		
		JCheckBox checkBoxD = new JCheckBox("D");
		checkBoxD.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxD.setBounds(10, 65, 50, 21);
		notesPanel.add(checkBoxD);
		
		JCheckBox checkBoxE = new JCheckBox("E");
		checkBoxE.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxE.setBounds(10, 97, 50, 21);
		notesPanel.add(checkBoxE);
		
		JCheckBox checkBoxF = new JCheckBox("F");
		checkBoxF.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxF.setBounds(10, 131, 50, 21);
		notesPanel.add(checkBoxF);
		
		JCheckBox checkBoxG = new JCheckBox("G");
		checkBoxG.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxG.setBounds(10, 162, 50, 21);
		notesPanel.add(checkBoxG);
		
		JCheckBox checkBoxA = new JCheckBox("A");
		checkBoxA.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxA.setBounds(10, 192, 50, 21);
		notesPanel.add(checkBoxA);
		
		JCheckBox checkBoxB = new JCheckBox("B");
		checkBoxB.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxB.setBounds(10, 222, 50, 21);
		notesPanel.add(checkBoxB);
		
		JCheckBox checkBoxRandom = new JCheckBox("Aleat\u00F3ria");
		checkBoxRandom.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxRandom.setBounds(10, 252, 96, 21);
		notesPanel.add(checkBoxRandom);
		
		JCheckBox checkBoxPause = new JCheckBox("Pausa");
		checkBoxPause.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		checkBoxPause.setBounds(10, 282, 78, 21);
		notesPanel.add(checkBoxPause);
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		optionsPanel.setBounds(194, 32, 228, 432);
		panel.add(optionsPanel);
		optionsPanel.setLayout(null);
		
		JLabel lblOptions = new JLabel("Op\u00E7\u00F5es");
		lblOptions.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		lblOptions.setBounds(10, 10, 62, 23);
		optionsPanel.add(lblOptions);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 344, 22);
		panel.add(menuBar);
		
		JMenu fileMenu = new JMenu("Arquivo");
		menuBar.add(fileMenu);
		
		JMenuItem menuItemOpenTextFile = new JMenuItem("Abrir arquivo de texto");
		fileMenu.add(menuItemOpenTextFile);
		
		JMenuItem menuItemSaveTextFile = new JMenuItem("Salvar em arquivo de texto");
		fileMenu.add(menuItemSaveTextFile);
		
		JMenuItem menuItemSaveMidi = new JMenuItem("Salvar m\u00FAsica");
		fileMenu.add(menuItemSaveMidi);
		
		JMenuItem menuItemHelp = new JMenuItem("Ajuda");
		menuBar.add(menuItemHelp);
		
		JMenuItem menuItemAbout = new JMenuItem("Sobre");
		menuBar.add(menuItemAbout);
		
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
}
