package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane txtpnDesenvolvidoPorEduardo = new JTextPane();
		txtpnDesenvolvidoPorEduardo.setText(
				"Desenvolvido por:\r\n\tEduardo E. Kussler\r\n\tGabriel C. Domingues\r\n\tPedro F. C. Da silva\r\n\tThiago S. Lermen\r\n\r\nUFRGS - Universidade Federal do Rio Grande do Sul\r\nT\u00E9cnicas de Constru\u00E7\u00E3o De Programas - Prof\u00BA Marcelo Soares Pimenta\r\n2020/2");
		txtpnDesenvolvidoPorEduardo.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		txtpnDesenvolvidoPorEduardo.setBackground(UIManager.getColor("SplitPane.background"));
		txtpnDesenvolvidoPorEduardo.setEditable(false);
		txtpnDesenvolvidoPorEduardo.setBounds(10, 10, 416, 181);
		contentPane.add(txtpnDesenvolvidoPorEduardo);
	}
}
