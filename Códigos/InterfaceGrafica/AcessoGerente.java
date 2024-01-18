package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import Classes.*;

public class AcessoGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAgncia;
	private JTextField textID;
	private JPasswordField passwordField;
	private JTextPane txtpnDigiteSeusDados;
	private JCheckBox chckbxMostrarSenha;
	private JButton btnNewButton;
	private JTextPane txtpnGerncia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcessoGerente frame = new AcessoGerente();
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
	public AcessoGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textAgncia = new JTextField();
		textAgncia.setBounds(332, 224, 191, 29);
		contentPane.add(textAgncia);
		textAgncia.setColumns(10);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(332, 263, 191, 29);
		contentPane.add(textID);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(332, 302, 191, 29);
		contentPane.add(passwordField);
		
		JTextPane txtpnAgncia = new JTextPane();
		txtpnAgncia.setEditable(false);
		txtpnAgncia.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		txtpnAgncia.setText("AGÊNCIA");
		txtpnAgncia.setBounds(530, 228, 83, 23);
		txtpnAgncia.setOpaque(false); //deixa o fundo do texto transparente
		contentPane.add(txtpnAgncia);
		
		JTextPane txtpnConta = new JTextPane();
		txtpnConta.setEditable(false);
		txtpnConta.setText("ID");
		txtpnConta.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		txtpnConta.setBounds(530, 266, 83, 23);
		txtpnConta.setOpaque(false); //deixa o fundo do texto transparente
		contentPane.add(txtpnConta);
		
		JTextPane txtpnSenha = new JTextPane();
		txtpnSenha.setEditable(false);
		txtpnSenha.setText("SENHA");
		txtpnSenha.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		txtpnSenha.setBounds(530, 305, 83, 23);
		txtpnSenha.setOpaque(false); //deixa o fundo do texto transparente
		contentPane.add(txtpnSenha);
		
		txtpnDigiteSeusDados = new JTextPane();
		txtpnDigiteSeusDados.setEditable(false);
		txtpnDigiteSeusDados.setFont(new Font("BancoDoBrasil Textos", Font.BOLD | Font.ITALIC, 14));
		txtpnDigiteSeusDados.setText("Digite seus dados para acessar");
		txtpnDigiteSeusDados.setBounds(318, 191, 222, 30);
		txtpnDigiteSeusDados.setOpaque(false); //deixa o fundo do texto transparente
		contentPane.add(txtpnDigiteSeusDados);
		
		// checkbox para mostrar ou ocultar a senha
        chckbxMostrarSenha = new JCheckBox("Mostrar Senha");
        chckbxMostrarSenha.setBounds(332, 341, 150, 23);
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
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setBounds(561, 357, 117, 32);
        contentPane.add(btnNewButton);
        
        txtpnGerncia = new JTextPane();
        txtpnGerncia.setForeground(new Color(0, 0, 160));
        txtpnGerncia.setText("GERÊNCIA");
        txtpnGerncia.setOpaque(false);
        txtpnGerncia.setFont(new Font("BancoDoBrasil Textos", Font.BOLD | Font.ITALIC, 22));
        txtpnGerncia.setEditable(false);
        txtpnGerncia.setBounds(373, 157, 123, 30);
        contentPane.add(txtpnGerncia);
		
	}

}
