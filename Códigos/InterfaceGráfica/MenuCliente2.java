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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class MenuCliente2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCliente2 frame = new MenuCliente2(null,null);
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
	public MenuCliente2(String agencia, String conta) throws ClassNotFoundException, SQLException {
		setResizable(false);
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
		textPane.setText("UF: " + s[1] + " | Agência: " + agencia + " | Número da conta: " + conta + " | Tipo de conta: " + s[4] + " | Nome: " + s[0] + " | Idade: " + s[2] + " | CPF: " + s[3] + " | Telefone: " + s[5]);
		menuBar.add(textPane);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JTextPane txtpnSelecioneUmaOpo = new JTextPane();
		txtpnSelecioneUmaOpo.setBounds(357, 40, 294, 32);
		txtpnSelecioneUmaOpo.setEditable(false);
		txtpnSelecioneUmaOpo.setForeground(new Color(0, 0, 160));
		txtpnSelecioneUmaOpo.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 20));
		txtpnSelecioneUmaOpo.setText("SELECIONE UMA OPÇÃO");
		txtpnSelecioneUmaOpo.setOpaque(false);
		contentPane.add(txtpnSelecioneUmaOpo);
		
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Pagar contas");
		btnNewButton.setBounds(224, 82, 245, 85);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcoesCliente ac = null;
				try {
					ac = new AcoesCliente(7,conta,agencia);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Excessao e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ac.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 160));
		btnNewButton.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
		contentPane.add(btnNewButton);
		
		JButton btnConsultarExtrato_1 = new JButton("Transferir dinheiro");
		btnConsultarExtrato_1.setBounds(508, 82, 245, 85);
		btnConsultarExtrato_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcoesCliente ac = null;
				try {
					ac = new AcoesCliente(8,conta,agencia);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Excessao e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ac.setVisible(true);
				dispose();
			}
		});
		btnConsultarExtrato_1.setForeground(new Color(0, 0, 160));
		btnConsultarExtrato_1.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
		contentPane.add(btnConsultarExtrato_1);
		
		JButton btnNewButton_1 = new JButton("Opções anteriores");
		btnNewButton_1.setBounds(10, 484, 174, 21);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		MenuCliente mc = null;
				try {
					mc = new MenuCliente(agencia,conta);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		mc.setVisible(true);
        		dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar para a tela de login");
		btnNewButton_2.setBounds(788, 484, 174, 21);
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicial i = new Inicial();
				i.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(btnNewButton_2);
	}
}
