package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Classes.Gerente;
import javax.swing.JComboBox;
import javax.swing.JTextArea;


public class AcoesGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtNome;
	private JTextPane txtpnNome;
	private JTextField textFieldCPF;
	private JTextPane txtpnCpf;
	private JTextField textFieldIdade;
	private JTextPane txtpnIdade;
	private JTextField textFieldUF;
	private JTextPane txtpnUf;
	private JTextField textFieldTel;
	private JTextPane txtpnTelefone;
	private JTextPane txtpnTipoDeConta;
	private JTextField textFieldAgencia;
	private JTextPane txtpnAgncia;
	private JTextField textFieldNumConta;
	private JTextPane txtpnNmeroDaConta;
	private JTextField textFieldRenda;
	private JTextPane txtpnRenda;
	private JTextPane txtpnSenha;
	private JPasswordField passwordField;
	private JTextPane txtpnDadosPessoais;
	private JTextPane txtpnDadosDaConta;
	private String CPF, Telefone, senha, conta;
	private double Renda, emprestimo;
	private int Idade, cont;
	private String [] dados;
	private JTextPane txtpnMensagemDeErro;
	private JTextPane txtpnUtilizarSomenteNmeros;
	private JPasswordField passwordField_1;
	private JTextPane txtpnConfirmarSenha;
	private JTextField textField_4;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcoesGerente frame = new AcoesGerente(2,null,null,null,null);
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
	
	public AcoesGerente(int cod, String agencia,String UF, String id, String senhaf) throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 592);
		getContentPane().setLayout(null);
		
		ArrayList<String []> pedidosdeemprestimo = new ArrayList<String []>();
		
		Gerente g3 = new Gerente();
		
		pedidosdeemprestimo = g3.avaliaremprestimo(agencia);
		
		System.out.println(pedidosdeemprestimo.get(1)[0]);
		System.out.println(pedidosdeemprestimo.get(1)[1]);
		System.out.println(pedidosdeemprestimo.get(1)[2]);
		System.out.println(pedidosdeemprestimo.get(1)[3]);
		System.out.println(pedidosdeemprestimo.get(1)[4]);
		System.out.println(pedidosdeemprestimo.get(1)[5]);
		
		DefaultComboBoxModel<String> pedidos = new DefaultComboBoxModel<>();
		
		for(int i = 0; i < pedidosdeemprestimo.size(); i++) {
			pedidos.addElement("Dados do pedido: Num. da conta: " + pedidosdeemprestimo.get(i)[0] + " | Tp de conta: " + pedidosdeemprestimo.get(i)[1] + " | Renda: " + pedidosdeemprestimo.get(i)[2] + " | Saldo: " + pedidosdeemprestimo.get(i)[3] + " | Dívida: " + pedidosdeemprestimo.get(i)[4] + " | Valor pré-disponibilizado: " + pedidosdeemprestimo.get(i)[5] + " | Valor pedido: " + pedidosdeemprestimo.get(i)[6]);
		}
		
		JComboBox comboBox = new JComboBox(pedidos);
		comboBox.setBounds(10, 44, 952, 21);
		getContentPane().add(comboBox);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		switch (cod) {
			case 1: //criar conta
				
				Gerente g = new Gerente();
				
				addWindowListener(new WindowAdapter() { // executa quando a janela é aberta
		            @Override
		            public void windowOpened(WindowEvent e) {
		                txtNome.requestFocusInWindow(); //coloca o foco, inicialmente, no textfield da agencia
		            }
		        });

				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				
				txtNome = new JTextField();
				textFieldCPF = new JTextField();
				textFieldIdade = new JTextField();
				textFieldAgencia = new JTextField();
				textFieldAgencia.setText(agencia);
				textFieldAgencia.setEditable(false);
				textFieldNumConta = new JTextField();
				textFieldTel = new JTextField();
				textFieldIdade = new JTextField();
				textFieldRenda = new JTextField();
				textFieldUF = new JTextField();
				textFieldUF.setText(UF);
				textFieldUF.setEditable(false);
				passwordField = new JPasswordField();
				
				DefaultComboBoxModel<String> tipos = new DefaultComboBoxModel<>();
				tipos.addElement("Aposentado");
				tipos.addElement("Comum");
				tipos.addElement("Empresarial");
				tipos.addElement("Estudantil");
				
				JComboBox textFieldTpConta = new JComboBox(tipos);
				
				textFieldTpConta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cont++; 
						if (cont > 1) {
							textFieldNumConta.setEnabled(true);
							textFieldNumConta.requestFocusInWindow();
						}
					}
				});
				
				textFieldCPF.setEnabled(false);
				textFieldTpConta.setEnabled(false);
				textFieldAgencia.setEnabled(false);
				textFieldNumConta.setEnabled(false);
				textFieldTel.setEnabled(false);
				textFieldIdade.setEnabled(false);
				textFieldRenda.setEnabled(false);
				textFieldUF.setEnabled(false);
				passwordField.setEnabled(false);
				
				txtpnMensagemDeErro = new JTextPane();
				txtpnMensagemDeErro.setEditable(false);
				txtpnMensagemDeErro.setForeground(new Color(183, 0, 0));
				txtpnMensagemDeErro.setOpaque(false);
				txtpnMensagemDeErro.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
				txtpnMensagemDeErro.setBounds(24, 389, 652, 19);
				contentPane.add(txtpnMensagemDeErro);
				txtpnMensagemDeErro.setVisible(false);
				
				txtNome = new JTextField();
				txtNome.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtNome.getText().matches("[a-zA-Z ]*")) { //se for composta por letras e outros caracteres (não aceitar)
							txtpnMensagemDeErro.setText("Nome Incorreto, utilize somente letras");
							txtpnMensagemDeErro.setVisible(true);
						}
						else {
							txtpnMensagemDeErro.setVisible(false);
							textFieldCPF.setEnabled(true);
							textFieldCPF.requestFocusInWindow();
						}
					}
				});
				txtNome.setBounds(181, 218, 163, 19);
				contentPane.add(txtNome);
				txtNome.setColumns(10);
				
				JTextPane txtpnInsiraOsDados = new JTextPane();
				txtpnInsiraOsDados.setEditable(false);
				txtpnInsiraOsDados.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				txtpnInsiraOsDados.setText("Insira os dados do seu cliente e confirme-os");
				txtpnInsiraOsDados.setOpaque(false);
				txtpnInsiraOsDados.setBounds(326, 160, 290, 19);
				contentPane.add(txtpnInsiraOsDados);
				
				txtpnNome = new JTextPane();
				txtpnNome.setEditable(false);
				txtpnNome.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnNome.setText("Nome");
				txtpnNome.setOpaque(false);
				txtpnNome.setBounds(354, 218, 48, 19);
				contentPane.add(txtpnNome);
				
				textFieldCPF.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!textFieldCPF.getText().matches("[0-9]+")) { //se for composta caracteres que não sejam números
							txtpnMensagemDeErro.setText("CPF incorreto, utilize somente números");
							txtpnMensagemDeErro.setVisible(true);
						}
						else {
							if (textFieldCPF.getText().length() == 11) {
								txtpnMensagemDeErro.setVisible(false);
								textFieldIdade.setEnabled(true);
								textFieldIdade.requestFocusInWindow();
								CPF = g.formatarCPF(textFieldCPF.getText());
							}
							else {
								txtpnMensagemDeErro.setText("CPF incorreto, tamanho indevido");
								txtpnMensagemDeErro.setVisible(true);
							}
						}
					}
				});
				textFieldCPF.setColumns(10);
				textFieldCPF.setBounds(181, 247, 163, 19);
				contentPane.add(textFieldCPF);
				
				txtpnCpf = new JTextPane();
				txtpnCpf.setEditable(false);
				txtpnCpf.setText("CPF*");
				txtpnCpf.setOpaque(false);
				txtpnCpf.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnCpf.setBounds(354, 247, 48, 19);
				contentPane.add(txtpnCpf);
				
				textFieldIdade.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!textFieldIdade.getText().matches("[0-9]+")) { //se for composta caracteres que não sejam números
							txtpnMensagemDeErro.setText("Idade incorreta, utilize somente números");
							txtpnMensagemDeErro.setVisible(true);
						}
						else {
							if (Integer.parseInt(textFieldIdade.getText()) <= 200) {
								txtpnMensagemDeErro.setVisible(false);
								textFieldTel.setEnabled(true);
								textFieldTel.requestFocusInWindow();
								Idade = Integer.parseInt(textFieldIdade.getText());
								if (Idade < 50) {
									tipos.removeElement("Aposentado");
								}
							}
							else {
								txtpnMensagemDeErro.setText("Idade incorreta, digite um valor inferir a 200");
								txtpnMensagemDeErro.setVisible(true);
							}
						}
					}
				});
				textFieldIdade.setColumns(10);
				textFieldIdade.setBounds(181, 276, 163, 19);
				contentPane.add(textFieldIdade);
				
				txtpnIdade = new JTextPane();
				txtpnIdade.setEditable(false);
				txtpnIdade.setText("Idade");
				txtpnIdade.setOpaque(false);
				txtpnIdade.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnIdade.setBounds(354, 276, 48, 19);
				contentPane.add(txtpnIdade);
				
				textFieldUF.setColumns(10);
				textFieldUF.setBounds(181, 305, 163, 19);
				contentPane.add(textFieldUF);
				
				txtpnUf = new JTextPane();
				txtpnUf.setEditable(false);
				txtpnUf.setText("UF");
				txtpnUf.setOpaque(false);
				txtpnUf.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnUf.setBounds(354, 305, 48, 19);
				contentPane.add(txtpnUf);
				
				textFieldTel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!textFieldTel.getText().matches("[0-9]+")) { //se for composta caracteres que não sejam números
							txtpnMensagemDeErro.setText("Telefone incorreto, utilize somente números");
							txtpnMensagemDeErro.setVisible(true);
						}
						else {
							if (textFieldTel.getText().length() == 11) {
								txtpnMensagemDeErro.setVisible(false);
								textFieldTpConta.setEnabled(true);
								textFieldTpConta.requestFocusInWindow();
								Telefone = g.formatarTelefone(textFieldTel.getText());
							}
							else {
								txtpnMensagemDeErro.setText("Telefone incorreto, tamanho indevido");
								txtpnMensagemDeErro.setVisible(true);
							}
						}
					}
				});
				textFieldTel.setColumns(10);
				textFieldTel.setBounds(181, 334, 163, 19);
				contentPane.add(textFieldTel);
				
				txtpnTelefone = new JTextPane();
				txtpnTelefone.setEditable(false);
				txtpnTelefone.setText("Telefone*");
				txtpnTelefone.setOpaque(false);
				txtpnTelefone.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnTelefone.setBounds(354, 334, 63, 19);
				contentPane.add(txtpnTelefone);
				
				
				
				textFieldTpConta.setBounds(455, 218, 161, 19); //combobox
				contentPane.add(textFieldTpConta);
				
				txtpnTipoDeConta = new JTextPane();
				txtpnTipoDeConta.setEditable(false);
				txtpnTipoDeConta.setText("Tipo de conta");
				txtpnTipoDeConta.setOpaque(false);
				txtpnTipoDeConta.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnTipoDeConta.setBounds(628, 218, 93, 19);
				contentPane.add(txtpnTipoDeConta);
				
				textFieldAgencia.setColumns(10);
				textFieldAgencia.setBounds(455, 247, 163, 19);
				contentPane.add(textFieldAgencia);
				
				txtpnAgncia = new JTextPane();
				txtpnAgncia.setEditable(false);
				txtpnAgncia.setText("Agência");
				txtpnAgncia.setOpaque(false);
				txtpnAgncia.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnAgncia.setBounds(628, 247, 60, 19);
				contentPane.add(txtpnAgncia);
				
				textFieldNumConta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!textFieldNumConta.getText().matches("[0-9]+")) { //se for composta caracteres que não sejam números
							txtpnMensagemDeErro.setText("Número da conta incorreto, utilize somente números");
							txtpnMensagemDeErro.setVisible(true);
						}
						else {
							try {
								if (!g.verificaconta(textFieldNumConta.getText())) {
									txtpnMensagemDeErro.setVisible(false);
									textFieldRenda.setEnabled(true);
									textFieldRenda.requestFocusInWindow();
								}
								else {
									txtpnMensagemDeErro.setText("Número da conta já existe");
									txtpnMensagemDeErro.setVisible(true);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				});
				textFieldNumConta.setColumns(10);
				textFieldNumConta.setBounds(455, 276, 163, 19);
				contentPane.add(textFieldNumConta);
				
				txtpnNmeroDaConta = new JTextPane();
				txtpnNmeroDaConta.setEditable(false);
				txtpnNmeroDaConta.setText("Número da conta");
				txtpnNmeroDaConta.setOpaque(false);
				txtpnNmeroDaConta.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnNmeroDaConta.setBounds(628, 276, 125, 19);
				contentPane.add(txtpnNmeroDaConta);
				
				textFieldRenda.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!textFieldRenda.getText().matches("[0-9.]+")) { //se for composta caracteres que não sejam números e ponto
							txtpnMensagemDeErro.setText("Valor de renda inválido, utilize somente números e ponto decimal");
							txtpnMensagemDeErro.setVisible(true);
						}
						else {
							switch(textFieldTpConta.getSelectedItem().toString()) {
								case ("Aposentado"):
									if (Double.parseDouble(textFieldRenda.getText()) < 1412) {
										txtpnMensagemDeErro.setText("Valor de renda inválido, somente serão aceitos valores superiores ou iguais a R$1412");
										txtpnMensagemDeErro.setVisible(true);
									}
									else { //aceita
										Renda = Double.parseDouble(textFieldRenda.getText());
										emprestimo = Renda*0.3;
										emprestimo += 1500;
										txtpnMensagemDeErro.setVisible(false);
										passwordField.setEnabled(true);
										passwordField.requestFocusInWindow();
										
									}
									break;
								case ("Estudantil"):
									if (Double.parseDouble(textFieldRenda.getText()) < 400) {
										txtpnMensagemDeErro.setText("Valor de renda inválido, somente serão aceitos valores superiores ou iguais a R$400");
										txtpnMensagemDeErro.setVisible(true);
									}
									else { //aceita
										Renda = Double.parseDouble(textFieldRenda.getText());
										emprestimo = Renda*0.3;
										emprestimo += 2000;
										txtpnMensagemDeErro.setVisible(false);
										passwordField.setEnabled(true);
										passwordField.requestFocusInWindow();
									}
									break;
								case ("Empresarial"):
									if (Double.parseDouble(textFieldRenda.getText()) < 6750) {
										txtpnMensagemDeErro.setText("Valor de renda inválido, somente serão aceitos valores superiores ou iguais a R$6750");
										txtpnMensagemDeErro.setVisible(true);
									}
									else { //aceita
										Renda = Double.parseDouble(textFieldRenda.getText());
										emprestimo = Renda*0.3;
										emprestimo += 10000;
										txtpnMensagemDeErro.setVisible(false);
										passwordField.setEnabled(true);
										passwordField.requestFocusInWindow();
									}
									break;
								case ("Comum"):
									if (Double.parseDouble(textFieldRenda.getText()) < 706) {
										txtpnMensagemDeErro.setText("Valor de renda inválido, somente serão aceitos valores superiores ou iguais a R$706");
										txtpnMensagemDeErro.setVisible(true);
									}
									else { //aceita
										Renda = Double.parseDouble(textFieldRenda.getText());
										emprestimo = Renda*0.3;
										emprestimo += 1000;
										txtpnMensagemDeErro.setVisible(false);
										passwordField.setEnabled(true);
										passwordField.requestFocusInWindow();
									}
									break;
							}
						}
					}
				});
				textFieldRenda.setColumns(10);
				textFieldRenda.setBounds(455, 305, 163, 19);
				contentPane.add(textFieldRenda);
				
				txtpnRenda = new JTextPane();
				txtpnRenda.setEditable(false);
				txtpnRenda.setText("Renda");
				txtpnRenda.setOpaque(false);
				txtpnRenda.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnRenda.setBounds(628, 305, 48, 19);
				contentPane.add(txtpnRenda);
				
				txtpnSenha = new JTextPane();
				txtpnSenha.setEditable(false);
				txtpnSenha.setText("Senha");
				txtpnSenha.setOpaque(false);
				txtpnSenha.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnSenha.setBounds(628, 334, 63, 19);
				contentPane.add(txtpnSenha);
				
				passwordField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						char[] senhachar = passwordField.getPassword(); //pega o texto presente na passwordfield em um array de char
		                senha = new String(senhachar); //transforma o array de char em String
		                passwordField_1.setEnabled(true);
		                passwordField_1.requestFocusInWindow();
					}
				});
				passwordField.setColumns(10);
				passwordField.setBounds(455, 334, 162, 19);
				contentPane.add(passwordField);
				
				JButton btnNewButton = new JButton("CONFIRMA");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							g.criarconta(txtNome.getText(), textFieldUF.getText(), textFieldAgencia.getText(), textFieldNumConta.getText(), Idade, CPF, senha, textFieldTpConta.getSelectedItem().toString(), Renda, 0.0, 0.0, Telefone,emprestimo);
							FinalGerente fg = new FinalGerente(1,agencia,id);
							fg.setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton.setBackground(new Color(0, 0, 0));
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				btnNewButton.setBounds(686, 394, 116, 37);
				contentPane.add(btnNewButton);
				
				txtpnDadosPessoais = new JTextPane();
				txtpnDadosPessoais.setText("Dados Pessoais");
				txtpnDadosPessoais.setOpaque(false);
				txtpnDadosPessoais.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 18));
				txtpnDadosPessoais.setEditable(false);
				txtpnDadosPessoais.setBounds(218, 188, 157, 34);
				contentPane.add(txtpnDadosPessoais);
				
				txtpnDadosDaConta = new JTextPane();
				txtpnDadosDaConta.setText("Dados da Conta");
				txtpnDadosDaConta.setOpaque(false);
				txtpnDadosDaConta.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 18));
				txtpnDadosDaConta.setEditable(false);
				txtpnDadosDaConta.setBounds(519, 187, 157, 34);
				contentPane.add(txtpnDadosDaConta);
				
				txtpnUtilizarSomenteNmeros = new JTextPane();
				txtpnUtilizarSomenteNmeros.setText("* Utilizar somente números, sem caracteres especiais ou espaços em branco");
				txtpnUtilizarSomenteNmeros.setOpaque(false);
				txtpnUtilizarSomenteNmeros.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnUtilizarSomenteNmeros.setEditable(false);
				txtpnUtilizarSomenteNmeros.setBounds(527, 526, 435, 19);
				contentPane.add(txtpnUtilizarSomenteNmeros);
				
				passwordField_1 = new JPasswordField();
				passwordField_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						char[] senhacharc = passwordField_1.getPassword();
						String senhac = new String(senhacharc);
						if (senha.equals(senhac)) {
							btnNewButton.doClick();
						}
						else {
							txtpnMensagemDeErro.setText("As senhas não coincidem, informe-as novamente");
							txtpnMensagemDeErro.setVisible(true);
							passwordField_1.setText("");
							passwordField.setText("");
						}
					}
				});
				passwordField_1.setEnabled(false);
				passwordField_1.setColumns(10);
				passwordField_1.setBounds(455, 363, 162, 19);
				contentPane.add(passwordField_1);
				
				txtpnConfirmarSenha = new JTextPane();
				txtpnConfirmarSenha.setText("Confirmar Senha");
				txtpnConfirmarSenha.setOpaque(false);
				txtpnConfirmarSenha.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnConfirmarSenha.setEditable(false);
				txtpnConfirmarSenha.setBounds(628, 363, 107, 19);
				contentPane.add(txtpnConfirmarSenha);
				break;
				
			case 2: //excluir conta
				Gerente g2 = new Gerente ();
				
				addWindowListener(new WindowAdapter() { // executa quando a janela é aberta
		            @Override
		            public void windowOpened(WindowEvent e) {
		                textField_4.requestFocusInWindow(); //coloca o foco, inicialmente, no textfield da agencia
		            }
		        });
				
				JTextPane MensagemDeErro = new JTextPane();
				MensagemDeErro.setForeground(new Color(196, 0, 0));
				MensagemDeErro.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
				MensagemDeErro.setOpaque(false);
				MensagemDeErro.setBounds(10, 389, 372, 27);
				getContentPane().add(MensagemDeErro);
				
				JButton btnNewButton_1 = new JButton("Confirmar");
				passwordField_2 = new JPasswordField();
				passwordField_2.setEnabled(false);
				btnNewButton_1.setEnabled(false);
				
				textField_4 = new JTextField();
				textField_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(!g2.verificaconta(textField_4.getText())) {
								MensagemDeErro.setText("Não é possível excluir uma conta inexistente");
								MensagemDeErro.setVisible(true);
							}
							else {
								passwordField_2.requestFocusInWindow();
								MensagemDeErro.setVisible(false);
								conta = textField_4.getText();
								passwordField_2.setEnabled(true);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				textField_4.setBounds(75, 258, 96, 19);
				getContentPane().add(textField_4);
				textField_4.setColumns(10);
				
				passwordField_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						char [] senhac = passwordField_2.getPassword();
						String senhateste = new String (senhac);
						if (senhateste.equals(senhaf)) {
							btnNewButton_1.setEnabled(true);
							btnNewButton_1.doClick();
							MensagemDeErro.setVisible(false);
						}
						else {
							MensagemDeErro.setText("A senha do gerente está incorreta");
							MensagemDeErro.setVisible(true);
						}
					}
				});
				passwordField_2.setBounds(75, 284, 96, 19);
				getContentPane().add(passwordField_2);
				
				JTextPane txtpnNmeroDaConta_1 = new JTextPane();
				txtpnNmeroDaConta_1.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnNmeroDaConta_1.setText("Número da Conta");
				txtpnNmeroDaConta_1.setBounds(181, 258, 116, 19);
				txtpnNmeroDaConta_1.setOpaque(false);
				getContentPane().add(txtpnNmeroDaConta_1);
				
				JTextPane txtpnNmeroDaConta_1_1 = new JTextPane();
				txtpnNmeroDaConta_1_1.setText("Senha do Gerente");
				txtpnNmeroDaConta_1_1.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				txtpnNmeroDaConta_1_1.setBounds(181, 284, 116, 19);
				txtpnNmeroDaConta_1_1.setOpaque(false);
				getContentPane().add(txtpnNmeroDaConta_1_1);
				
				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				textArea.setBounds(392, 67, 545, 410);
				getContentPane().add(textArea);
				
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							dados = g2.encontrardados(conta);
							textArea.setText("");
							textArea.append("Nome do Cliente: " + dados[0] + "\n");
							textArea.append("CPF: " + dados[4] + "\n");
							textArea.append("Idade: " + dados[3] + "\n");
							textArea.append("UF: " + dados[1] + "\n");
							textArea.append("Telefone: " + dados[10] + "\n");
							textArea.append("Número da Conta: " + conta + "\n");
							textArea.append("Agência: " + dados[2] + "\n");
							textArea.append("Tipo de Conta: " + dados[7] + "\n");
							textArea.append("Renda: " + dados[7] + "\n");
							textArea.append("Saldo: " + dados[8] + "\n");
							textArea.append("Dívida: " + dados[9] + "\n");
							textArea.append("Senha: " + dados[5] + "\n");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_1.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				btnNewButton_1.setBounds(181, 313, 116, 21);
				getContentPane().add(btnNewButton_1);
				
				JTextPane txtpnNmeroDaConta_1_2 = new JTextPane();
				txtpnNmeroDaConta_1_2.setText("Excluir Conta");
				txtpnNmeroDaConta_1_2.setOpaque(false);
				txtpnNmeroDaConta_1_2.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 18));
				txtpnNmeroDaConta_1_2.setBounds(131, 221, 188, 27);
				getContentPane().add(txtpnNmeroDaConta_1_2);
				
				JButton btnNewButton_2 = new JButton("Confirmar remoção");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						 int opcao = exibirDialogoExclusao();
			                if (opcao == JOptionPane.OK_OPTION) { //se clicar em OK
			                    try {
									g2.removerconta(conta);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			                    FinalGerente fg = new FinalGerente(2,agencia,id);
			                    fg.setVisible(true);
			                    dispose();
			                }
			                
					}
				});
				btnNewButton_2.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				btnNewButton_2.setBounds(767, 484, 170, 27);
				getContentPane().add(btnNewButton_2);
				
				JTextPane txtpnNmeroDaConta_1_2_1 = new JTextPane();
				txtpnNmeroDaConta_1_2_1.setText("Confirme os dados da conta a ser apagada");
				txtpnNmeroDaConta_1_2_1.setOpaque(false);
				txtpnNmeroDaConta_1_2_1.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 18));
				txtpnNmeroDaConta_1_2_1.setBounds(483, 30, 385, 27);
				getContentPane().add(txtpnNmeroDaConta_1_2_1);
				break;
				
			case 3: //avaliar emprestimos
				
				break;
		}
	}
	 private int exibirDialogoExclusao() {
	        // Criar um JOptionPane com mensagem de confirmação
	        int opcaoSelecionada = JOptionPane.showConfirmDialog(
	                this,
	                "Tem certeza que deseja excluir os dados?",
	                "Confirmação de Exclusão",
	                JOptionPane.OK_CANCEL_OPTION
	        );

	        return opcaoSelecionada;
	    }
}
