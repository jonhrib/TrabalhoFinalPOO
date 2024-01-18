package InterfaceGrafica;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import Classes.*;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;

public class MenuGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGerente frame = new MenuGerente(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MenuGerente(String agencia, String ID) throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 592);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		String [] s = new String [2];
		Gerente g = new Gerente ();
		s = g.encontranome(ID);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(128, 128, 255));
		textPane.setForeground(new Color(0, 0, 0));
		textPane.setEditable(false);
		textPane.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		textPane.setText("UF: " + s[1] + "| Agência: " + agencia + " | ID: " + ID + "| Nome: " + s[0]);
		menuBar.add(textPane);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Criar Conta");
		btnNewButton.setForeground(new Color(0, 0, 160));
		btnNewButton.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(209, 184, 245, 85);
		contentPane.add(btnNewButton);
		
		JButton btnExcluirConta = new JButton("Excluir Conta");
		btnExcluirConta.setForeground(new Color(0, 0, 160));
		btnExcluirConta.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
		btnExcluirConta.setBounds(505, 183, 245, 85);
		contentPane.add(btnExcluirConta);
		
		JButton btnAnliseDeEmprstimos = new JButton("Análise de Empréstimos");
		btnAnliseDeEmprstimos.setForeground(new Color(0, 0, 160));
		btnAnliseDeEmprstimos.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
		btnAnliseDeEmprstimos.setBounds(350, 306, 245, 85);
		contentPane.add(btnAnliseDeEmprstimos);
		
		JTextPane txtpnSelecioneUmaOpo = new JTextPane();
		txtpnSelecioneUmaOpo.setEditable(false);
		txtpnSelecioneUmaOpo.setForeground(new Color(0, 0, 160));
		txtpnSelecioneUmaOpo.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 20));
		txtpnSelecioneUmaOpo.setText("SELECIONE UMA OPÇÃO");
		txtpnSelecioneUmaOpo.setOpaque(false);
		txtpnSelecioneUmaOpo.setBounds(359, 142, 294, 32);
		contentPane.add(txtpnSelecioneUmaOpo);
	}
}

