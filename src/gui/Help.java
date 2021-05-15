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

// Class for Help Window
public class Help extends JFrame {

	// Help message
	private static final String helpMessage = "No menu arquivo você pode abrir um arquivo de texto com uma música para o programa, salvar o texto atual ou salvar a música.\r\n"
			+ "É possível inserir Modificações na música usando os botões para inserir Notas e inserir Opções, ou você pode inserir diretamente no formato de texto na caixa música, sendo os comandos disponíveis listados abaixo:\r\n"
			+ "\r\n" + "\r\n" + "(Letra A maiúscula): Nota Lá\r\n" + "(Letra B maiúscula): Nota Si\r\n"
			+ "(Letra C maiúscula): Nota Dó\r\n" + "(Letra D maiúscula): Nota Ré\r\n"
			+ "(Letra E maiúscula): Nota Mi\r\n" + "(Letra F maiúscula): Nota Fá\r\n"
			+ "(Letra G maiúscula): Nota Sol\r\n" + "(Letra P maiúscula): Silêncio ou pausa\r\n"
			+ "(Letra R maiúscula): Toca uma nota aleatória (de A a G), randomicamente escolhida\r\n"
			+ "Letras a,b,c,d,e,f,g minúsculas: Se caractere anterior era NOTA (A a G), repete nota; Caso contrário, silêncio ou pausa\r\n"
			+ "Qualquer outra letra consoante (todas consoantes exceto as que são notas): Se caractere anterior era NOTA (A a G), repete nota; Caso contrário, silêncio ou pausa\r\n"
			+ "\r\n" + "BPM+: Aumenta BPM em 50 unidades\r\n" + "BPM-: Diminui BPM em 50 unidades\r\n"
			+ "Caracteres T+ (letra T seguida de sinal de adição): Aumenta uma oitava\r\n"
			+ "Caracteres T- (letra T seguida de sinal de subtração): Diminui uma oitava\r\n"
			+ "Caractere ? (ponto de interrogação) e caractere . (ponto): Aumenta UMA oitava; Se não puder, aumentar, volta à oitava default (de início)\r\n"
			+ "Caractere + (sinal de adição): Aumenta volume em 10 unidades\r\n"
			+ "Caractere - (sinal de subtração): Diminui volume em 10 unidades\r\n"
			+ "Caractere Espaço: Aumenta volume para o DOBRO do volume; Se não puder aumentar, volta ao volume default (de início)\r\n"
			+ "\r\n"
			+ "Dígito par ou ímpar: Trocar instrumento para o instrumento General MIDI cujo numero é igual ao valor do instrumento ATUAL + valor do dígito\r\n"
			+ "Caractere ! (ponto de exclamação): Trocar instrumento para o instrumento General MIDI #114 (Agogo)\r\n"
			+ "Qualquer outra letra vogal (O ou o, I ou i , U ou u): Trocar instrumento para o instrumento General MIDI #7 (Harpsichord)\r\n"
			+ "Caractere NL (nova linha): Trocar instrumento para o instrumento General MIDI #15 (Tubular Bells)\r\n"
			+ "Caractere ; (ponto e vírgula): Trocar instrumento para o instrumento General MIDI #76 (Pan Flute)\r\n"
			+ "Caractere , (vírgula): Trocar instrumento para o instrumento General MIDI #20 (Church Organ)\r\n"
			+ "\r\n"
			+ "Para Qualquer outra sequencia Se caractere anterior era NOTA (A a G), repete nota; Caso contrário, Silêncio ou pausa";
	
	// Panel
	private JPanel contentPane;

	// Create window
	public void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
					frame.setTitle("Ajuda");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create frame
	public Help() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 506);

		JTextArea txtHelp = new JTextArea();
		txtHelp.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		txtHelp.setBackground(UIManager.getColor("ScrollBar.foreground"));
		txtHelp.setText(helpMessage);
		txtHelp.setEditable(false);
		txtHelp.setLineWrap(true);
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
