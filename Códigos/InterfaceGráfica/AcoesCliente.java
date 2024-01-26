package InterfaceGrafica;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.sql.SQLException;

import Classes.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.JPasswordField;
import java.awt.Canvas;

public class AcoesCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane txtpnValorDisponvel;
	private JTextField textField;
	private double valorrequerido, valorfinal;
	private int qtdparcela;
	private JTextField textFieldNome;
	private JTextPane txtpnUf;
	private JTextField textFieldUF;
	private JTextPane txtpnNmeroDaAgncia;
	private JTextField textFieldAg;
	private JCheckBox chckbxMostrarSenha;
	private JTextPane txtpnNmeroDaConta;
	private JTextField textFieldConta;
	private JTextPane txtpnIdade;
	private JTextField textFieldIdade;
	private JTextPane txtpnCpf;
	private JTextField textFieldCPF;
	private JTextPane txtpnTipoDeConta;
	private JTextField textFieldTpC;
	private JTextPane txtpnRenda;
	private JTextField textFieldRenda;
	private JTextPane txtpnTelfone;
	private JTextField textFieldTel;
	private JPasswordField passwordField_1;
	private JTextPane txtpnSenha;
	private JTextField textField_1;
	private JTextPane txtpnDigiteAsSuas;
	private JTextPane txtpnSaldoDisponvel;
	private JTextPane txtpnOValorDigitado;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcoesCliente frame = new AcoesCliente(1,null,null);
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
	public AcoesCliente(int cod, String conta, String agencia) throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		switch (cod) {
			case 1: //editar dados
				Cliente c1 = new Cliente();
				
				String dados[] = c1.encontradados(conta);
				
				textFieldUF = new JTextField();
				textFieldUF.setEditable(false);
				textFieldUF.setText(dados[1]);
				textFieldAg = new JTextField();
				textFieldAg.setEditable(false);
				textFieldAg.setText(agencia);
				textFieldConta = new JTextField();
				textFieldConta.setEditable(false);
				textFieldConta.setText(conta);
				textFieldIdade = new JTextField();
				textFieldIdade.setEditable(false);
				textFieldIdade.setText(dados[2]);
				textFieldCPF = new JTextField();
				textFieldCPF.setEditable(false);
				textFieldCPF.setText(dados[3]);
				textFieldTpC = new JTextField();
				textFieldTpC.setEditable(false);
				textFieldTpC.setText(dados[4]);
				textFieldUF.setEnabled(false);
				textFieldAg.setEnabled(false);
				textFieldConta.setEnabled(false);
				textFieldIdade.setEnabled(false);
				textFieldCPF.setEnabled(false);
				textFieldTpC.setEnabled(false);
				passwordField_1 = new JPasswordField();
				chckbxMostrarSenha = new JCheckBox("Mostrar Senha");
				chckbxMostrarSenha.setEnabled(false);
				passwordField_1.setEnabled(false);
				
				JTextPane txtpnEditarDadosPessoais = new JTextPane();
				txtpnEditarDadosPessoais.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 18));
				txtpnEditarDadosPessoais.setText("Editar dados pessoais");
				txtpnEditarDadosPessoais.setBounds(384, 62, 209, 30);
				txtpnEditarDadosPessoais.setOpaque(false);
				txtpnEditarDadosPessoais.setForeground(new Color(0, 0, 160));
				txtpnEditarDadosPessoais.setEditable(false);
				contentPane.add(txtpnEditarDadosPessoais);
				
				textFieldNome = new JTextField();
				textFieldNome.setBounds(318, 122, 162, 19);
				contentPane.add(textFieldNome);
				textFieldNome.setText(dados[0]);
				textFieldNome.setColumns(10);
				
				JTextPane txtpnNome = new JTextPane();
				txtpnNome.setEditable(false);
				txtpnNome.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				txtpnNome.setText("Nome");
				txtpnNome.setBounds(490, 122, 82, 19);
				txtpnNome.setOpaque(false);
				contentPane.add(txtpnNome);
				
				txtpnUf = new JTextPane();
				txtpnUf.setEditable(false);
				txtpnUf.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				txtpnUf.setText("UF");
				txtpnUf.setOpaque(false);
				txtpnUf.setBounds(490, 151, 132, 19);
				contentPane.add(txtpnUf);
				
				textFieldUF.setColumns(10);
				textFieldUF.setBounds(318, 151, 162, 19);
				contentPane.add(textFieldUF);
				
				txtpnNmeroDaAgncia = new JTextPane();
				txtpnNmeroDaAgncia.setEditable(false);
				txtpnNmeroDaAgncia.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				txtpnNmeroDaAgncia.setText("Número da Agência");
				txtpnNmeroDaAgncia.setOpaque(false);
				txtpnNmeroDaAgncia.setBounds(490, 180, 132, 19);
				contentPane.add(txtpnNmeroDaAgncia);
				
				textFieldAg.setColumns(10);
				textFieldAg.setBounds(318, 180, 162, 19);
				contentPane.add(textFieldAg);
				
				txtpnNmeroDaConta = new JTextPane();
				txtpnNmeroDaConta.setEditable(false);
				txtpnNmeroDaConta.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				txtpnNmeroDaConta.setText("Número da Conta");
				txtpnNmeroDaConta.setOpaque(false);
				txtpnNmeroDaConta.setBounds(490, 209, 132, 19);
				contentPane.add(txtpnNmeroDaConta);
				
				textFieldConta.setColumns(10);
				textFieldConta.setBounds(318, 209, 162, 19);
				contentPane.add(textFieldConta);
				
				txtpnIdade = new JTextPane();
				txtpnIdade.setEditable(false);
				txtpnIdade.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				txtpnIdade.setText("Idade");
				txtpnIdade.setOpaque(false);
				txtpnIdade.setBounds(490, 238, 132, 19);
				contentPane.add(txtpnIdade);
				
				textFieldIdade.setColumns(10);
				textFieldIdade.setBounds(318, 238, 162, 19);
				contentPane.add(textFieldIdade);
				
				txtpnCpf = new JTextPane();
				txtpnCpf.setEditable(false);
				txtpnCpf.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				txtpnCpf.setText("CPF");
				txtpnCpf.setOpaque(false);
				txtpnCpf.setBounds(490, 267, 132, 19);
				contentPane.add(txtpnCpf);
				
				textFieldCPF.setColumns(10);
				textFieldCPF.setBounds(318, 267, 162, 19);
				contentPane.add(textFieldCPF);
				
				txtpnTipoDeConta = new JTextPane();
				txtpnTipoDeConta.setEditable(false);
				txtpnTipoDeConta.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				txtpnTipoDeConta.setText("Tipo de Conta");
				txtpnTipoDeConta.setOpaque(false);
				txtpnTipoDeConta.setBounds(490, 296, 132, 19);
				contentPane.add(txtpnTipoDeConta);
				
				textFieldTpC.setColumns(10);
				textFieldTpC.setBounds(318, 296, 162, 19);
				contentPane.add(textFieldTpC);
				
				txtpnRenda = new JTextPane();
				txtpnRenda.setEditable(false);
				txtpnRenda.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				txtpnRenda.setText("Renda");
				txtpnRenda.setOpaque(false);
				txtpnRenda.setBounds(490, 325, 132, 19);
				contentPane.add(txtpnRenda);
				
				textFieldRenda = new JTextField();
				textFieldRenda.setColumns(10);
				textFieldRenda.setBounds(318, 325, 162, 19);
				textFieldRenda.setText(dados[6]);
				contentPane.add(textFieldRenda);
				
				txtpnTelfone = new JTextPane();
				txtpnTelfone.setEditable(false);
				txtpnTelfone.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				txtpnTelfone.setText("Telefone");
				txtpnTelfone.setOpaque(false);
				txtpnTelfone.setBounds(490, 354, 132, 19);
				contentPane.add(txtpnTelfone);
				
				textFieldTel = new JTextField();
				textFieldTel.setColumns(10);
				textFieldTel.setBounds(318, 354, 162, 19);
				textFieldTel.setText(dados[5]);
				contentPane.add(textFieldTel);
				
				// checkbox para mostrar ou ocultar a senha
		        chckbxMostrarSenha.setBounds(318, 436, 150, 23);
		        chckbxMostrarSenha.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {

		                if (chckbxMostrarSenha.isSelected()) { // se o checkbox está ativado
		                    passwordField_1.setEchoChar((char) 0); // exibe a senha
		                } else { // se o checkbox não está ativado
		                    passwordField_1.setEchoChar('*'); // oculta a senha
		                }
		            }
		        });
		        contentPane.add(chckbxMostrarSenha);
				
				passwordField_1.setText((String) null);
				passwordField_1.setBounds(318, 408, 162, 19);
				contentPane.add(passwordField_1);
				
				JTextPane txtpnSenha_1 = new JTextPane();
				txtpnSenha_1.setEditable(false);
				txtpnSenha_1.setText("Nova Senha");
				txtpnSenha_1.setOpaque(false);
				txtpnSenha_1.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				txtpnSenha_1.setBounds(490, 408, 132, 19);
				contentPane.add(txtpnSenha_1);
				
				JCheckBox chckbxAlterarSenha = new JCheckBox("Alterar Senha");
				chckbxAlterarSenha.setBounds(318, 379, 150, 23);
				chckbxAlterarSenha.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                if (chckbxAlterarSenha.isSelected()) { // se o checkbox está ativado
		                    passwordField_1.setEnabled(true); 
		                    chckbxMostrarSenha.setEnabled(true);
		                }
		                else {
		                	 passwordField_1.setEnabled(false);
		                     chckbxMostrarSenha.setEnabled(false);
		                }
		            }
		        });
				contentPane.add(chckbxAlterarSenha);
				
				txtpnSenha = new JTextPane();
				txtpnSenha.setForeground(new Color(221, 0, 0));
				txtpnSenha.setText("A nova senha é igual a antiga");
				txtpnSenha.setOpaque(false);
				txtpnSenha.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				txtpnSenha.setEditable(false);
				txtpnSenha.setBounds(581, 408, 185, 19);
				contentPane.add(txtpnSenha);
				txtpnSenha.setVisible(false);
				
				JButton btnNewButton_1 = new JButton("Confirma");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nome = textFieldNome.getText();
		            	String renda = textFieldRenda.getText();
		            	String telefone = textFieldTel.getText();
						if(chckbxAlterarSenha.isSelected()) {// se a senha será alterada
							char[] senhas = passwordField_1.getPassword();
							String senha = new String (senhas);
							try {
								if (senha.equals(dados[7])) {
									txtpnSenha.setVisible(true);
								}
								else{
									ConfirmaSenha cs = new ConfirmaSenha(dados[7],conta,agencia);
									cs.setVisible(true);
									c1.editarconta(2, conta, nome, renda, telefone, senha);
									txtpnSenha.setVisible(false);
									dispose();
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else {
							try {
								c1.editarconta(1, conta, nome, renda, telefone, null);
								FinalCliente fc = new FinalCliente("1.1",conta,agencia);
								fc.setVisible(true);
								dispose();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				});
				btnNewButton_1.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				btnNewButton_1.setBounds(571, 455, 111, 28);
				contentPane.add(btnNewButton_1);
				
				JButton BotaoMenuC1 = new JButton("Voltar para o Menu do Cliente");
				BotaoMenuC1.addActionListener(new ActionListener() {
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
				BotaoMenuC1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
				BotaoMenuC1.setBounds(10, 518, 241, 27);
		        contentPane.add(BotaoMenuC1);
				
				break;
				
			case 2:
				
				
				break;
				
			case 3: //pedir empréstimo
				DecimalFormat df = new DecimalFormat ("0.00");
				
				addWindowListener(new WindowAdapter() { // executa quando a janela é aberta
		            @Override
		            public void windowOpened(WindowEvent e) {
		                textField.requestFocusInWindow(); //coloca o foco, inicialmente, no textfield da agencia
		            }
		        });
				
				Cliente c = new Cliente ();
				
				DefaultComboBoxModel<String> parcelas = new DefaultComboBoxModel<>();
				parcelas.addElement("12");
				parcelas.addElement("24");
				parcelas.addElement("36");
				parcelas.addElement("48");
				parcelas.addElement("60");
				parcelas.addElement("72");
				
				JTextPane txtpnValorTotalA = new JTextPane();
				JTextPane txtpnValorDeCada = new JTextPane();
				
				JComboBox comboBox = new JComboBox(parcelas);
				comboBox.setEnabled(false);
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						double juros = 0, parcela = 0;
						qtdparcela = Integer.parseInt(comboBox.getSelectedItem().toString());
						
						switch (comboBox.getSelectedItem().toString()) {
							case "12":
								juros = 0.05;
								valorfinal = ((juros*qtdparcela)*valorrequerido) + valorrequerido;
								parcela = valorfinal/qtdparcela;
								break;
								
							case "24":
								juros = 0.055;
								valorfinal = ((juros*qtdparcela)*valorrequerido) + valorrequerido;
								parcela = valorfinal/qtdparcela;
								break;
								
							case "36":
								juros = 0.06;
								valorfinal = ((juros*qtdparcela)*valorrequerido) + valorrequerido;
								parcela = valorfinal/qtdparcela;
								break;
								
							case "48":
								juros = 0.065;
								valorfinal = ((juros*qtdparcela)*valorrequerido) + valorrequerido;
								parcela = valorfinal/qtdparcela;
								break;
							
							case "60":
								juros = 0.07;
								valorfinal = ((juros*qtdparcela)*valorrequerido) + valorrequerido;
								parcela = valorfinal/qtdparcela;
								break;
								
							case "72":
								juros = 0.075;
								valorfinal = ((juros*qtdparcela)*valorrequerido) + valorrequerido;
								parcela = valorfinal/qtdparcela;
								break;
						}
						txtpnValorTotalA.setText("Valor total a ser pago: " + df.format(valorfinal));
						txtpnValorDeCada.setText("Valor de cada parcela: " + df.format(parcela));
					}
				});
				comboBox.setBounds(459, 283, 47, 22);
				contentPane.add(comboBox);
				
				JTextPane txtpnOValorRequerido = new JTextPane();
				txtpnOValorRequerido.setForeground(new Color(0, 0, 255));
				txtpnOValorRequerido.setText("O valor requerido é maior que o valor disponível, portanto seu pedido será encaminhado para análise.");
				txtpnOValorRequerido.setOpaque(false);
				txtpnOValorRequerido.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
				txtpnOValorRequerido.setEditable(false);
				txtpnOValorRequerido.setBounds(99, 428, 783, 22);
				txtpnOValorRequerido.setVisible(false);
				contentPane.add(txtpnOValorRequerido);
				
				JTextPane txtpnPedidoDeEmprstimo = new JTextPane();
				txtpnPedidoDeEmprstimo.setEditable(false);
				txtpnPedidoDeEmprstimo.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 26));
				txtpnPedidoDeEmprstimo.setText("Pedido de Empréstimo");
				txtpnPedidoDeEmprstimo.setBounds(327, 111, 301, 45);
				txtpnPedidoDeEmprstimo.setForeground(new Color(0, 0, 160));
				txtpnPedidoDeEmprstimo.setOpaque(false);
				contentPane.add(txtpnPedidoDeEmprstimo);
				
				txtpnValorDisponvel = new JTextPane();
				txtpnValorDisponvel.setEditable(false);
				txtpnValorDisponvel.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
				txtpnValorDisponvel.setText ("Valor disponível: " + c.encontravalordoemprestimo(conta) + " reais");
				txtpnValorDisponvel.setBounds(341, 219, 287, 22);
				txtpnValorDisponvel.setOpaque(false);
				contentPane.add(txtpnValorDisponvel);
				
				textField = new JTextField();
				textField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (c.encontravalordoemprestimo(conta) < Double.parseDouble(textField.getText())) {
								valorrequerido = Double.parseDouble(textField.getText());
								txtpnOValorRequerido.setVisible(true);
								comboBox.setEnabled(true);
								comboBox.requestFocusInWindow();
							}
							else {
								valorrequerido = Double.parseDouble(textField.getText());
								comboBox.setEnabled(true);
								comboBox.requestFocusInWindow();
								txtpnOValorRequerido.setVisible(false);
							}
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				textField.setBounds(459, 251, 141, 22);
				contentPane.add(textField);
				textField.setColumns(10);
				
				JTextPane txtpnValorDesejado = new JTextPane();
				txtpnValorDesejado.setText("Valor desejado:");
				txtpnValorDesejado.setOpaque(false);
				txtpnValorDesejado.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
				txtpnValorDesejado.setEditable(false);
				txtpnValorDesejado.setBounds(341, 251, 115, 22);
				contentPane.add(txtpnValorDesejado);
				
				JTextPane txtpnQtdDeParcelas = new JTextPane();
				txtpnQtdDeParcelas.setText("Qtd de parcelas:");
				txtpnQtdDeParcelas.setOpaque(false);
				txtpnQtdDeParcelas.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
				txtpnQtdDeParcelas.setEditable(false);
				txtpnQtdDeParcelas.setBounds(341, 283, 126, 22);
				contentPane.add(txtpnQtdDeParcelas);
				
				txtpnValorTotalA.setText("Valor total a ser pago: " + valorfinal);
				txtpnValorTotalA.setOpaque(false);
				txtpnValorTotalA.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
				txtpnValorTotalA.setEditable(false);
				txtpnValorTotalA.setBounds(341, 315, 349, 22);
				contentPane.add(txtpnValorTotalA);
				
				JButton btnNewButton = new JButton("Pedir Empréstimo");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int opcao = exibirDialogoExclusao();
		                if (opcao == JOptionPane.OK_OPTION) { //se clicar em OK
		                	try {
								if (valorrequerido > c.encontravalordoemprestimo(conta)) {
									FinalCliente fc = new FinalCliente("3.1",conta,agencia);
									fc.setVisible(true);
									c.atualizaemprestimo(conta, valorrequerido);
									c.atualizarparcelas(conta, qtdparcela, valorfinal);
									dispose();
								}
								else {
									FinalCliente fc = new FinalCliente("3.2",conta,agencia);
									fc.setVisible(true);
									c.deposito(conta,valorrequerido);
									c.aumentardivida(conta, valorfinal);
									c.retirarvalordeemprestimo(conta, valorrequerido);
									c.atualizarparcelas(conta, qtdparcela, valorfinal);
									dispose();
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                }
					}
				});
				btnNewButton.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
				btnNewButton.setBounds(397, 375, 169, 21);
				contentPane.add(btnNewButton);
				
				txtpnValorDeCada.setOpaque(false);
				txtpnValorDeCada.setText("Valor de cada parcela: 0,0");
				txtpnValorDeCada.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
				txtpnValorDeCada.setEditable(false);
				txtpnValorDeCada.setBounds(341, 343, 349, 22);
				contentPane.add(txtpnValorDeCada);
				
				JButton BotaoMenuC2 = new JButton("Voltar para o Menu do Cliente");
				BotaoMenuC2.addActionListener(new ActionListener() {
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
				BotaoMenuC2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
				BotaoMenuC2.setBounds(10, 518, 241, 27);
		        contentPane.add(BotaoMenuC2);
				break;	
			case 4:
				
				break;
			case 5:
				addWindowListener(new WindowAdapter() { // executa quando a janela é aberta
		            @Override
		            public void windowOpened(WindowEvent e) {
		                textField_1.requestFocusInWindow(); //coloca o foco, inicialmente, no textfield da agencia
		            }
		        });
				
				Cliente c2 = new Cliente();
				btnNewButton_2 = new JButton("Confirmar");
				btnNewButton_2.setEnabled(false);
				txtpnOValorDigitado = new JTextPane();
				txtpnOValorDigitado.setForeground(new Color(217, 0, 0));
				txtpnOValorDigitado.setText("O valor digitado é maior do que o disponível para saque.");
				txtpnOValorDigitado.setOpaque(false);
				txtpnOValorDigitado.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
				txtpnOValorDigitado.setEditable(false);
				txtpnOValorDigitado.setBounds(38, 322, 459, 22);
				contentPane.add(txtpnOValorDigitado);
				txtpnOValorDigitado.setVisible(false);
				textField_1 = new JTextField();
				textField_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnNewButton_2.requestFocusInWindow();
						btnNewButton_2.setEnabled(true);
						btnNewButton_2.doClick();
					}
				});
				textField_1.setBounds(235, 274, 96, 19);
				contentPane.add(textField_1);
				textField_1.setColumns(10);
				
				JTextPane txtpnSaque = new JTextPane();
				txtpnSaque.setForeground(new Color(0, 0, 160));
				txtpnSaque.setEditable(false);
				txtpnSaque.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 20));
				txtpnSaque.setText("Saque Bancário");
				txtpnSaque.setBounds(405, 217, 161, 32);
				txtpnSaque.setOpaque(false);
				contentPane.add(txtpnSaque);
				
				txtpnDigiteAsSuas = new JTextPane();
				txtpnDigiteAsSuas.setEditable(false);
				txtpnDigiteAsSuas.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
				txtpnDigiteAsSuas.setText("Digite o valor a ser sacado:");
				txtpnDigiteAsSuas.setBounds(38, 274, 233, 19);
				txtpnDigiteAsSuas.setOpaque(false);
				contentPane.add(txtpnDigiteAsSuas);
				
				txtpnSaldoDisponvel = new JTextPane();
				txtpnSaldoDisponvel.setEditable(false);
				txtpnSaldoDisponvel.setFont(new Font("BancoDoBrasil Textos", Font.BOLD | Font.ITALIC, 14));
				txtpnSaldoDisponvel.setText("Saldo disponível: R$"+ c2.encontradados(conta)[8]);
				txtpnSaldoDisponvel.setBounds(675, 272, 262, 22);
				txtpnSaldoDisponvel.setOpaque(false);
				contentPane.add(txtpnSaldoDisponvel);
				
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(Double.parseDouble(textField_1.getText())<=Double.parseDouble(c2.encontradados(conta)[8])) {
								c2.saque(conta, Double.parseDouble(textField_1.getText()));
								txtpnOValorDigitado.setVisible(false);
								FinalCliente fc = new FinalCliente("5",conta,agencia);
								fc.setVisible(true);
								dispose();
							}
							else {
								txtpnOValorDigitado.setVisible(true);
							}
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_2.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				btnNewButton_2.setBounds(358, 273, 121, 21);
				contentPane.add(btnNewButton_2);
				
				JButton BotaoMenuC = new JButton("Voltar para o Menu do Cliente");
				BotaoMenuC.addActionListener(new ActionListener() {
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
				BotaoMenuC.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
				BotaoMenuC.setBounds(10, 507, 241, 27);
		        contentPane.add(BotaoMenuC);
		        
		        JLabel background = new JLabel(new ImageIcon("C:\\Users\\jonhv\\OneDrive\\Documentos\\Photoshop\\EMJOVI\\Modelo interface2.png"));
		        background.setBounds(-17, 483, 1012, 540);
		        contentPane.add(background);
		        
		        Canvas canvas = new Canvas();
		        canvas.setBackground(new Color(0, 0, 160));
		        canvas.setForeground(new Color(0, 0, 160));
		        canvas.setBounds(-25, -41, 100, 100);
		        contentPane.add(canvas);
		        
		        Canvas canvas_1 = new Canvas();
		        canvas_1.setForeground(new Color(0, 0, 160));
		        canvas_1.setBackground(new Color(0, 0, 128));
		        canvas_1.setBounds(57, -20, 100, 100);
		        contentPane.add(canvas_1);
		        
		        Canvas canvas_2 = new Canvas();
		        canvas_2.setForeground(new Color(0, 0, 160));
		        canvas_2.setBackground(new Color(0, 0, 160));
		        canvas_2.setBounds(127, -41, 100, 100);
		        contentPane.add(canvas_2);
		        
		        Canvas canvas_1_1 = new Canvas();
		        canvas_1_1.setForeground(new Color(0, 0, 160));
		        canvas_1_1.setBackground(new Color(0, 0, 128));
		        canvas_1_1.setBounds(209, -20, 100, 100);
		        contentPane.add(canvas_1_1);
		        
		        Canvas canvas_3 = new Canvas();
		        canvas_3.setForeground(new Color(0, 0, 160));
		        canvas_3.setBackground(new Color(0, 0, 160));
		        canvas_3.setBounds(264, -41, 100, 100);
		        contentPane.add(canvas_3);
		        
		        Canvas canvas_1_2 = new Canvas();
		        canvas_1_2.setForeground(new Color(0, 0, 160));
		        canvas_1_2.setBackground(new Color(0, 0, 128));
		        canvas_1_2.setBounds(346, -20, 100, 100);
		        contentPane.add(canvas_1_2);
		        
		        Canvas canvas_4 = new Canvas();
		        canvas_4.setForeground(new Color(0, 0, 160));
		        canvas_4.setBackground(new Color(0, 0, 160));
		        canvas_4.setBounds(394, -41, 100, 100);
		        contentPane.add(canvas_4);
		        
		        Canvas canvas_1_3 = new Canvas();
		        canvas_1_3.setForeground(new Color(0, 0, 160));
		        canvas_1_3.setBackground(new Color(0, 0, 128));
		        canvas_1_3.setBounds(476, -20, 100, 100);
		        contentPane.add(canvas_1_3);
		        
		        Canvas canvas_5 = new Canvas();
		        canvas_5.setForeground(new Color(0, 0, 160));
		        canvas_5.setBackground(new Color(0, 0, 160));
		        canvas_5.setBounds(518, -41, 100, 100);
		        contentPane.add(canvas_5);
		        
		        Canvas canvas_1_4 = new Canvas();
		        canvas_1_4.setForeground(new Color(0, 0, 160));
		        canvas_1_4.setBackground(new Color(0, 0, 128));
		        canvas_1_4.setBounds(600, -20, 100, 100);
		        contentPane.add(canvas_1_4);
		        
		        Canvas canvas_6 = new Canvas();
		        canvas_6.setForeground(new Color(0, 0, 160));
		        canvas_6.setBackground(new Color(0, 0, 160));
		        canvas_6.setBounds(665, -41, 100, 100);
		        contentPane.add(canvas_6);
		        
		        Canvas canvas_1_5 = new Canvas();
		        canvas_1_5.setForeground(new Color(0, 0, 160));
		        canvas_1_5.setBackground(new Color(0, 0, 128));
		        canvas_1_5.setBounds(747, -20, 100, 100);
		        contentPane.add(canvas_1_5);
		        
		        Canvas canvas_7 = new Canvas();
		        canvas_7.setForeground(new Color(0, 0, 160));
		        canvas_7.setBackground(new Color(0, 0, 160));
		        canvas_7.setBounds(790, -41, 100, 100);
		        contentPane.add(canvas_7);
		        
		        Canvas canvas_1_6 = new Canvas();
		        canvas_1_6.setForeground(new Color(0, 0, 160));
		        canvas_1_6.setBackground(new Color(0, 0, 128));
		        canvas_1_6.setBounds(872, -20, 100, 100);
		        contentPane.add(canvas_1_6);
				
				break;
			case 6:
	
				break;
		}
	}
	
	private int exibirDialogoExclusao() {
        // Criar um JOptionPane com mensagem de confirmação
        int opcaoSelecionada = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja pedir esse empréstimo?",
                "Confirmação de Pedido",
                JOptionPane.OK_CANCEL_OPTION
        );

        return opcaoSelecionada;
    }
}
