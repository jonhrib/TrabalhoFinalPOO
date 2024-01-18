package InterfaceGrafica;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.*;

import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.SQLException;

public class MenuCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCliente frame = new MenuCliente(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param s1 
	 * @param s 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MenuCliente(String agencia, String conta) throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 592);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		String [] s = new String [6];
		Cliente c = new Cliente ();
		s = c.encontradados(conta);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(new Color(128, 128, 255));
		textPane.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		textPane.setText("UF: " + s[1] + "| Agência: " + agencia + " | Número da conta: " + conta + " | Tipo de conta: " + s[4] + " | Nome: " + s[0] + " | Idade: " + s[2] + " | CPF: " + s[3] + " | Telefone: " + s[5]);
		menuBar.add(textPane);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JTextPane txtpnSelecioneUmaOpo = new JTextPane();
		txtpnSelecioneUmaOpo.setEditable(false);
		txtpnSelecioneUmaOpo.setForeground(new Color(0, 0, 160));
		txtpnSelecioneUmaOpo.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 20));
		txtpnSelecioneUmaOpo.setText("SELECIONE UMA OPÇÃO");
		txtpnSelecioneUmaOpo.setOpaque(false);
		txtpnSelecioneUmaOpo.setBounds(357, 40, 294, 32);
		contentPane.add(txtpnSelecioneUmaOpo);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Editar dados pessoais");
		btnNewButton.setBounds(224, 82, 245, 85);
		btnNewButton.setForeground(new Color(0, 0, 160));
		btnNewButton.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
		contentPane.add(btnNewButton);
		
		JButton btnConsultarExtrato = new JButton("Pedir Empréstimo");
		btnConsultarExtrato.setForeground(new Color(0, 0, 160));
		btnConsultarExtrato.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
		btnConsultarExtrato.setBounds(224, 213, 245, 85);
		contentPane.add(btnConsultarExtrato);
		
		JButton btnSaque = new JButton("Saque");
		btnSaque.setForeground(new Color(0, 0, 160));
		btnSaque.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
		btnSaque.setBounds(224, 345, 245, 85);
		contentPane.add(btnSaque);
		
		JButton btnNewButton_2_1 = new JButton("Depósito");
		btnNewButton_2_1.setForeground(new Color(0, 0, 160));
		btnNewButton_2_1.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
		btnNewButton_2_1.setBounds(508, 345, 245, 85);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_1_1 = new JButton("Consultar Dívida");
		btnNewButton_1_1.setForeground(new Color(0, 0, 160));
		btnNewButton_1_1.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(508, 213, 245, 85);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnConsultarExtrato_1 = new JButton("Consultar Extrato");
		btnConsultarExtrato_1.setForeground(new Color(0, 0, 160));
		btnConsultarExtrato_1.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
		btnConsultarExtrato_1.setBounds(508, 82, 245, 85);
		contentPane.add(btnConsultarExtrato_1);
	}
}

