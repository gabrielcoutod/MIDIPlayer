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

		JTextArea txtHelp = new JTextArea();
		txtHelp.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		txtHelp.setBackground(UIManager.getColor("ScrollBar.foreground"));
		txtHelp.setText(
				"No menu arquivo voc� pode abrir um arquivo de texto com uma m�sica para o programa, salvar o texto atual ou salvar a m�sica.\r\n"
						+ "� poss�vel inserir Modifica��es na musica usando os bot�es para inserir Notas e inserir Op��es, ou voc� pode inserir diretamente no formato de texto na caixa m�sica, sendo os comandos dispon�veis listados abaixo:\r\n"
						+ "\r\n" + "\r\n" + "(Letra A mai�scula): Nota L�\r\n" + "(Letra B mai�scula): Nota Si\r\n"
						+ "(Letra C mai�scula): Nota D�\r\n" + "(Letra D mai�scula): Nota R�\r\n"
						+ "(Letra E mai�scula): Nota Mi\r\n" + "(Letra F mai�scula): Nota F�\r\n"
						+ "(Letra G mai�scula): Nota Sol\r\n" + "(Letra P mai�scula): Sil�ncio ou pausa\r\n"
						+ "(Letra R mai�scula): Toca uma nota aleat�ria (de A a G), randomicamente escolhida\r\n"
						+ "Letras a,b,c,d,e,f,g min�sculas: Se caractere anterior era NOTA (A a G), repete nota; Caso contr�rio, Sil�ncio ou pausa\r\n"
						+ "Qualquer outra letra consoante (todas consoantes exceto as que s�o notas): Se caractere anterior era NOTA (A a G), repete nota; Caso contr�rio, Sil�ncio ou pausa\r\n"
						+ "\r\n" + "BPM+: Aumenta BPM em 50 unidades\r\n" + "BPM-: Diminui BPM em 50 unidades\r\n"
						+ "Caracteres T+ (letra T seguida de sinal de adi��o): Aumenta uma oitava\r\n"
						+ "Caracteres T- (letra T seguida de sinal de subtra��o): Diminui uma oitava\r\n"
						+ "Caractere ? (ponto de interroga��o) e caractere . (ponto): Aumenta UMA oitava; Se n�o puder, aumentar, volta � oitava default (de in�cio)\r\n"
						+ "Caractere + (sinal de adi��o): Aumenta volume em 10 unidades\r\n"
						+ "Caractere - (sinal de subtra��o): Diminui volume em 10 unidades\r\n"
						+ "Caractere Espa�o: Aumenta volume para o DOBRO do volume; Se n�o puder aumentar, volta ao volume default (de in�cio)\r\n"
						+ "\r\n"
						+ "D�gito par ou impar: Trocar instrumento para o instrumento General MIDI cujo numero � igual ao valor do instrumento ATUAL + valor do d�gito\r\n"
						+ "Caractere ! (ponto de exclama��o): Trocar instrumento para o instrumento General MIDI #114 (Agogo)\r\n"
						+ "Qualquer outra letra vogal (O ou o, I ou i , U ou u): Trocar instrumento para o instrumento General MIDI #7 (Harpsichord)\r\n"
						+ "Caractere NL (nova linha): Trocar instrumento para o instrumento General MIDI #15 (Tubular Bells)\r\n"
						+ "Caractere ; (ponto e v�rgula): Trocar instrumento para o instrumento General MIDI #76 (Pan Flute)\r\n"
						+ "Caractere , (v�rgula): Trocar instrumento para o instrumento General MIDI #20 (Church Organ)\r\n"
						+ "\r\n"
						+ "Para Qualquer outra sequencia Se caractere anterior era NOTA (A a G), repete nota; Caso contr�rio, Sil�ncio ou pausa");
		txtHelp.setEditable(false);
		txtHelp.setLineWrap(true);
		// Text scrolled back to the top
		txtHelp.select(0, 0);

		JScrollPane scrollPane = new JScrollPane(txtHelp, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBounds(10, 10, 602, 438);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(scrollPane);

	}
}
