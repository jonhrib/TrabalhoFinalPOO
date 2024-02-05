package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class Inicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial frame = new Inicial();
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
	public Inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// plano de fundo
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\jonhv\\OneDrive\\Documentos\\Photoshop\\EMJOVI\\Modelo interface2.png"));
        background.setBounds(-22, -14, 1012, 588);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBounds(293, 339, 173, 57);
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcessoCliente acessarcliente = new AcessoCliente();
				acessarcliente.setVisible(true);
				dispose();
			}
		});
		btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnGerente = new JButton("Gerente");
		btnGerente.setBounds(492, 339, 173, 57);
		btnGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcessoGerente acessargerente = new AcessoGerente();
				acessargerente.setVisible(true);
				dispose();
			}
		});
		btnGerente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.setLayout(null);
		
		JTextPane txtpnSelecioneUmModo = new JTextPane();
		txtpnSelecioneUmModo.setBounds(364, 308, 249, 32);
		txtpnSelecioneUmModo.setForeground(new Color(255, 255, 255));
		txtpnSelecioneUmModo.setEditable(false);
		txtpnSelecioneUmModo.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 16));
		txtpnSelecioneUmModo.setText("Selecione um modo de entrada");
		txtpnSelecioneUmModo.setOpaque(false);
		contentPane.add(txtpnSelecioneUmModo);
		contentPane.add(btnCliente);
		contentPane.add(btnGerente);
		contentPane.add(background);

	}

}
