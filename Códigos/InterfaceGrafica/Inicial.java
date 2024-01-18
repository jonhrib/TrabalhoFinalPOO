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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		
		// plano de fundo, não consegui deixar os elementos superiores a ele
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\jonhv\\OneDrive\\Documentos\\Photoshop\\EMJOVI\\Modelo interface2.png"));
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcessoCliente acessarcliente = new AcessoCliente();
				acessarcliente.setVisible(true);
			}
		});
		btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnGerente = new JButton("Gerente");
		btnGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcessoGerente acessargerente = new AcessoGerente();
				acessargerente.setVisible(true);
			}
		});
		btnGerente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextPane txtpnSelecioneUmModo = new JTextPane();
		txtpnSelecioneUmModo.setForeground(new Color(255, 255, 255));
		txtpnSelecioneUmModo.setEditable(false);
		txtpnSelecioneUmModo.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 16));
		txtpnSelecioneUmModo.setText("Selecione um modo de entrada");
		txtpnSelecioneUmModo.setOpaque(false);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(372)
					.addComponent(txtpnSelecioneUmModo, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(301)
					.addComponent(btnCliente, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(500)
					.addComponent(btnGerente, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
				.addComponent(background)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(315)
					.addComponent(txtpnSelecioneUmModo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(346)
					.addComponent(btnCliente, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(346)
					.addComponent(btnGerente, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
				.addComponent(background)
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
