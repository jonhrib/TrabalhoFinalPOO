package InterfaceGrafica;

import java.awt.EventQueue;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import Classes.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AcessoCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAgncia;
	private JTextField textConta;
	private JPasswordField passwordField;
	private JTextPane txtpnDigiteSeusDados;
	private JTextPane txtpnCliente;
	private JCheckBox chckbxMostrarSenha;
	private JButton btnNewButton;
	private JTextPane txtpnContaNoEncontrada;
	private JTextPane txtpnSenhaIncorreta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcessoCliente frame = new AcessoCliente();
					frame.setVisible(true);
					frame.textAgncia.requestFocusInWindow();//coloca o foco, inicialmente, no textfield da agencia
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public AcessoCliente() {
		
		addWindowListener(new WindowAdapter() { // executa quando a janela é aberta
            @Override
            public void windowOpened(WindowEvent e) {
                textAgncia.requestFocusInWindow(); //coloca o foco, inicialmente, no textfield da agencia
            }
        });
		
		textConta = new JTextField();
		passwordField = new JPasswordField();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnAgnciaNoEncontrada = new JTextPane();
        txtpnAgnciaNoEncontrada.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
        txtpnAgnciaNoEncontrada.setText("Agência não encontrada");
        txtpnAgnciaNoEncontrada.setBounds(604, 228, 171, 29);
        txtpnAgnciaNoEncontrada.setOpaque(false); //deixa o fundo do texto transparente
        contentPane.add(txtpnAgnciaNoEncontrada);
        txtpnAgnciaNoEncontrada.setVisible(false);
        
        txtpnContaNoEncontrada = new JTextPane();
        txtpnContaNoEncontrada.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
        txtpnContaNoEncontrada.setText("Conta não encontrada");
        txtpnContaNoEncontrada.setBounds(606, 269, 150, 23);
        txtpnContaNoEncontrada.setOpaque(false); //deixa o fundo do texto transparente
        txtpnContaNoEncontrada.setVisible(false);
        contentPane.add(txtpnContaNoEncontrada);
        
        txtpnSenhaIncorreta = new JTextPane();
        txtpnSenhaIncorreta.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
        txtpnSenhaIncorreta.setText("Senha incorreta");
        txtpnSenhaIncorreta.setBounds(606, 305, 150, 23);
        txtpnSenhaIncorreta.setOpaque(false);
        contentPane.add(txtpnSenhaIncorreta);
        txtpnSenhaIncorreta.setVisible(false);
		
        
		textAgncia = new JTextField();
		textConta.setEnabled(false);
		passwordField.setEnabled(false);
		textAgncia.addActionListener(new ActionListener() { //se o enter for apertado, a info estiver correta, passa o foco para o próximo textField
            @Override
            public void actionPerformed(ActionEvent e) {
            	Cliente c = null;
				try {
					c = new Cliente();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if (!c.acessar(1,textAgncia.getText(),null,null)) {
						textConta.setEditable(false);
						passwordField.setEditable(false);
						txtpnAgnciaNoEncontrada.setVisible(true);
					}
					else {
						textConta.setEditable(true);
						passwordField.setEditable(true);
						textConta.setEnabled(true);
						txtpnAgnciaNoEncontrada.setVisible(false);
						textConta.requestFocusInWindow();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
		textAgncia.setBounds(328, 224, 191, 29);
		contentPane.add(textAgncia);
		textAgncia.setColumns(10);
		
		textConta.addActionListener(new ActionListener() { //se o enter for apertado, e a info estiver correta, passa o foco para o próximo textField
            @Override
            public void actionPerformed(ActionEvent e) {
            	Cliente c = null;
				try {
					c = new Cliente();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if (!c.acessar(2,textAgncia.getText(),textConta.getText(),null)) {
						passwordField.setEditable(false);
						txtpnContaNoEncontrada.setVisible(true);
					}
					else {
						passwordField.setEditable(true);
						txtpnContaNoEncontrada.setVisible(false);
						passwordField.requestFocus();
						passwordField.requestFocusInWindow();
						passwordField.setEnabled(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
        });
		
		textConta.setColumns(10);
		textConta.setBounds(328, 263, 191, 29);
		contentPane.add(textConta);
		
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.doClick(); //ao dar enter no campo de texto da senha, aciona o botão, tentando entrar
			}
		});
		passwordField.setBounds(328, 302, 191, 29);
		contentPane.add(passwordField);
		
		JTextPane txtpnAgncia = new JTextPane();
		txtpnAgncia.setEditable(false);
		txtpnAgncia.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		txtpnAgncia.setText("AGÊNCIA");
		txtpnAgncia.setBounds(526, 228, 83, 23);
		txtpnAgncia.setOpaque(false); //deixa o fundo do texto transparente
		contentPane.add(txtpnAgncia);
		
		JTextPane txtpnConta = new JTextPane();
		txtpnConta.setEditable(false);
		txtpnConta.setText("CONTA");
		txtpnConta.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		txtpnConta.setBounds(526, 266, 83, 23);
		txtpnConta.setOpaque(false); //deixa o fundo do texto transparente
		contentPane.add(txtpnConta);
		
		JTextPane txtpnSenha = new JTextPane();
		txtpnSenha.setEditable(false);
		txtpnSenha.setText("SENHA");
		txtpnSenha.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		txtpnSenha.setBounds(526, 305, 83, 23);
		txtpnSenha.setOpaque(false); //deixa o fundo do texto transparente
		contentPane.add(txtpnSenha);
		
		txtpnDigiteSeusDados = new JTextPane();
		txtpnDigiteSeusDados.setEditable(false);
		txtpnDigiteSeusDados.setFont(new Font("BancoDoBrasil Textos", Font.BOLD | Font.ITALIC, 14));
		txtpnDigiteSeusDados.setText("Digite seus dados para acessar");
		txtpnDigiteSeusDados.setBounds(314, 191, 222, 30);
		txtpnDigiteSeusDados.setOpaque(false); //deixa o fundo do texto transparente
		contentPane.add(txtpnDigiteSeusDados);
		
		// checkbox para mostrar ou ocultar a senha
        chckbxMostrarSenha = new JCheckBox("Mostrar Senha");
        chckbxMostrarSenha.setBounds(328, 341, 150, 23);
        chckbxMostrarSenha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (chckbxMostrarSenha.isSelected()) { // se o checkbox está ativado
                    passwordField.setEchoChar((char) 0); // exibe a senha
                } else { // se o checkbox não está ativado
                    passwordField.setEchoChar('*'); // oculta a senha
                }
            }
        });
        contentPane.add(chckbxMostrarSenha);
        
        btnNewButton = new JButton("ENTRAR");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Cliente c = null;
				try {
					c = new Cliente();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					char[] senhachar = passwordField.getPassword(); //pega o texto presente na passwordfield em um array de char
	                String senha = new String(senhachar); //transforma o array de char em String
	                
					if (!c.acessar(3,textAgncia.getText(),textConta.getText(),senha)) {
				        txtpnSenhaIncorreta.setVisible(true);
					}
					else {
						txtpnSenhaIncorreta.setVisible(false);
						MenuCliente menuc = new MenuCliente(textAgncia.getText(),textConta.getText());
						menuc.setVisible(true);
						dispose();
					}
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setBounds(557, 357, 117, 32);
        contentPane.add(btnNewButton);
        
        txtpnCliente = new JTextPane();
        txtpnCliente.setForeground(new Color(0, 0, 160));
        txtpnCliente.setText("CLIENTES");
        txtpnCliente.setOpaque(false);
        txtpnCliente.setFont(new Font("BancoDoBrasil Textos", Font.BOLD | Font.ITALIC, 22));
        txtpnCliente.setEditable(false);
        txtpnCliente.setBounds(369, 157, 123, 30);
        contentPane.add(txtpnCliente);
        	
	}
}
