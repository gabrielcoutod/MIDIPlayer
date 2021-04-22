package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Help() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 10, 602, 438);
		contentPane.add(scrollPane);
		
		JTextArea txtHelp = new JTextArea();
		txtHelp.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		txtHelp.setBackground(UIManager.getColor("ScrollBar.foreground"));
		txtHelp.setText("No menu arquivo voc\u00EA pode abrir um arquivo de texto com uma m\u00FAsica para o programa, salvar o texto atual ou salvar a m\u00FAsica.\r\n\n\n\n\n\u00C9 poss\u00EDvel inserir Modifica\u00E7\u00F5es na musica usando os bot\u00F5es para inserir Notas e inserir Op\u00E7\u00F5es, ou voc\u00EA pode inserir diretamente no formato de texto na caixa m\u00FAsica, sendo os comandos dispon\u00EDveis listados abaixo:\r\n\n\nA ou a: L\u00E1\n\r\nB ou b: Si\r\n\nC ou c: D\u00F3\r\n\nD ou d: R\u00E9\n\r\nE ou e: Mi\r\n\nF ou f: F\u00E1\n\r\nG ou g: Sol\n\r\nCaractere Espa\u00E7o: Pausa\n\r\n+:Dobra o volume\r\n\n-: Volume default\n\r\nV+: Aumenta o volume em 10 unidades\r\n\nV-: diminui o volume em 10 unidades\r\n\nO, o, I ou i, U ou u: se caractere anterior era uma nota repete a nota; caso contrario, silencio ou pausa\n\r\nT+: aumenta uma oitava\n\r\nT-: diminui uma oitava\n\r\n? ou .: nota aleat\u00F3ria\r\nNL(nova linha): Troca instrumento\n\r\nBPM+: aumenta BPM em 50\n\r\nBPM-: diminui BPM em 50\r\n\nBPM>: Aumenta BPM em 10 unidades\n\r\nBPM<: Diminui BPM em 10 unidades\r\n\nQualquer outra sequencia al\u00E9m dessas n\u00E3o altera a musica");
		txtHelp.setEditable(false);
		txtHelp.setLineWrap(true);
		// Text scrolled back to the top
		txtHelp.select(0, 0);
		scrollPane.setViewportView(txtHelp);
		
		
	}
}
