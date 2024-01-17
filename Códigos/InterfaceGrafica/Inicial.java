package InterfaceGrafica;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;

import Classes.*;

public class Inicial extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial window = new Inicial();
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
	public Inicial() {
		frame = new JFrame();
		frame.setBounds(100, 100, 986, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// plano de fundo, não consegui deixar os elementos superiores a ele
//        JLabel background = new JLabel(new ImageIcon("C:\\Users\\jonhv\\OneDrive\\Documentos\\Photoshop\\EMJOVI\\Modelo interface.png"));
//        background.setBounds(0, 0, 986, 592);
//        frame.getContentPane().add(background);
		
		JButton btnNewButton = new JButton("Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcessoCliente acessarcliente = new AcessoCliente();
				acessarcliente.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(301, 346, 173, 57);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGerente = new JButton("Gerente");
		btnGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGerente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGerente.setBounds(500, 346, 173, 57);
		frame.getContentPane().add(btnGerente);
		
		JTextPane txtpnSelecioneUmModo = new JTextPane();
		txtpnSelecioneUmModo.setEditable(false);
		txtpnSelecioneUmModo.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 16));
		txtpnSelecioneUmModo.setText("Selecione um modo de entrada");
		txtpnSelecioneUmModo.setBounds(372, 315, 249, 32);
		txtpnSelecioneUmModo.setOpaque(false); //deixa o fundo do texto transparente
		frame.getContentPane().add(txtpnSelecioneUmModo);
	}

}
