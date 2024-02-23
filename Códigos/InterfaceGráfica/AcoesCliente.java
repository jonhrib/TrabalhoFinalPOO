package InterfaceGrafica;

import java.awt.EventQueue;


import Classes.Excessao;
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
import javax.swing.ButtonGroup;
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
import java.util.ArrayList;

import javax.swing.JPasswordField;
import java.awt.Canvas;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.ScrollPane;

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
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private double valortotal;
	private JTextField textField_9;
	private JTextField textField_10;

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
	
	public AcoesCliente(int cod, String conta, String agencia) throws ClassNotFoundException, SQLException, Excessao {
		setResizable(false);
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
				JTextPane txtpnExtratoBancrio = new JTextPane();
				txtpnExtratoBancrio.setForeground(new Color(255, 255, 255));
				txtpnExtratoBancrio.setEditable(false);
				txtpnExtratoBancrio.setText("Extrato Bancário");
				txtpnExtratoBancrio.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 30));
				txtpnExtratoBancrio.setBounds(10, 18, 277, 37);
				txtpnExtratoBancrio.setOpaque(false);
				contentPane.add(txtpnExtratoBancrio);
				
				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				textArea.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
				textArea.setBounds(79, 81, 205, 194);
				contentPane.add(textArea);
				
				JScrollPane scrollPane = new JScrollPane(textArea);
				scrollPane.setBounds(10, 65, 542, 480);
				contentPane.add(scrollPane);
				
				Cliente c2 = new Cliente();
				String[] dados2 = c2.encontradados(conta);
				StringBuilder transacoes = new StringBuilder(dados2[dados2.length-1]);	
				transacoes.deleteCharAt(0);transacoes.deleteCharAt(transacoes.length()-1);
				String []tSaldo= transacoes.toString().split(",") ;
				
				JButton btnNewButton_5 = new JButton("Extrato Completo");
				btnNewButton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textArea.setText("");
						textArea.append("********** EXTRATO COMPLETO **********\n");
						textArea.append("* Cliente: " + dados2[0]);
						textArea.append("\n* Agência: " + agencia);
						textArea.append("\n* Conta: " + conta);
						textArea.append("\n* Tipo de conta: " + dados2[4]);
						textArea.append("\n\n------------- TRANSAÇÕES --------------\n");
						for(int i=0;i<tSaldo.length;i++) {
							if (tSaldo[i].charAt(0) == '+') {
								StringBuilder aux = new StringBuilder(tSaldo[i]);
								aux.deleteCharAt(0);
								aux.insert(0,"Depósito R$");
								tSaldo[i] = aux.toString();
							}
							else if (tSaldo[i].charAt(0) == '-') {
								StringBuilder aux = new StringBuilder(tSaldo[i]);
								aux.deleteCharAt(0);
								aux.insert(0,"Saque R$");
								tSaldo[i] = aux.toString();
							}
							textArea.append("* " + tSaldo[i]+"\n");
						}
						textArea.append("\n------------ DADOS FINAIS ------------");
						textArea.append("\n* Saldo atual: R$" + dados2[8]);
						textArea.append("\n* Dívida atual: R$" + dados2[9]);
						textArea.append("\n\n*********** FIM DO EXTRATO ***********\n");
					}
				});
				btnNewButton_5.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 18));
				btnNewButton_5.setForeground(new Color(0, 0, 0));
				btnNewButton_5.setBounds(668, 281, 208, 52);
				contentPane.add(btnNewButton_5);
				
				JButton btnNewButton_5_1 = new JButton("Transações");
				btnNewButton_5_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textArea.setText("");
//						textArea.append("+--------------------- Banco EMJOVI ---------------------+\n");
//						textArea.append("|Agência: "+agencia+" Número da Conta: "+dados2[0]+"*\n");
//						textArea.append(formataJonathan("Agência: "+agencia+" Número da Conta: "+dados2[0],60,"*","_"));
//						textArea.append("********** TRANSAÇÕES REALIZADAS **********\n");
//						textArea.append("* Cliente: " + dados2[0]);
//						textArea.append("\n* Agência: " + agencia);
//						textArea.append("\n* Conta: " + conta);
//						textArea.append("\n* Tipo de conta: " + dados2[4]);
						textArea.append("------------- TRANSAÇÕES EM ORDEM DE ACONTECIMENTO --------------\n");
						for(int i=0;i<tSaldo.length;i++) {
							if (tSaldo[i].charAt(0) == '+') {
								StringBuilder aux = new StringBuilder(tSaldo[i]);
								aux.deleteCharAt(0);
								aux.insert(0,"Depósito R$");
								tSaldo[i] = aux.toString();
							}
							else if (tSaldo[i].charAt(0) == '-') {
								StringBuilder aux = new StringBuilder(tSaldo[i]);
								aux.deleteCharAt(0);
								aux.insert(0,"Saque R$");
								tSaldo[i] = aux.toString();
							}
//							System.out.println(formataJonathan(""+tSaldo[i],60,"*","_"));
//							textArea.append(formataJonathan(""+tSaldo[i],60,"*","_"));
							textArea.append("* "+tSaldo[i]+"\n");
							
						}
						textArea.append("\n------------ DADOS FINAIS ------------");
						textArea.append("\n* Saldo atual: R$" + dados2[8]);
						textArea.append("\n* Dívida atual: R$" + dados2[9]);
						textArea.append("\n\n*********** FIM DO EXTRATO ***********\n");
					}	
				});
				btnNewButton_5_1.setForeground(Color.BLACK);
				btnNewButton_5_1.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 18));
				btnNewButton_5_1.setBounds(668, 343, 208, 52);
				contentPane.add(btnNewButton_5_1);
				 
			    JTextPane txtpnEscolhaUmaOpo = new JTextPane();
			    txtpnEscolhaUmaOpo.setText("Escolha uma opção de extrato:");
			    txtpnEscolhaUmaOpo.setOpaque(false);
			    txtpnEscolhaUmaOpo.setForeground(Color.WHITE);
			    txtpnEscolhaUmaOpo.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 16));
			    txtpnEscolhaUmaOpo.setEditable(false);
			    txtpnEscolhaUmaOpo.setBounds(645, 251, 259, 37);
			    contentPane.add(txtpnEscolhaUmaOpo);
			    
			    JButton BotaoMenuE = new JButton("Voltar para o Menu do Cliente");
			    BotaoMenuE.setForeground(new Color(255, 255, 255));
			    BotaoMenuE.setBackground(new Color(0, 0, 160));
				BotaoMenuE.addActionListener(new ActionListener() {
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
				BotaoMenuE.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
				BotaoMenuE.setBounds(754, 518, 208, 27);
		        contentPane.add(BotaoMenuE);
				
				JLabel logo = new JLabel(new ImageIcon("C:\\Users\\jonhv\\OneDrive\\Documentos\\Photoshop\\LogoEMJOVI.png"));
			    logo.setBounds(-40, 42, 1012, 588);
			    contentPane.add(logo);
				
				JLabel backgroundx = new JLabel(new ImageIcon("C:\\Users\\jonhv\\OneDrive\\Documentos\\Photoshop\\FundoEMJOVI.png"));
			    backgroundx.setBounds(-20, -13, 1012, 588);
			    contentPane.add(backgroundx);
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
			case 4://consultar dívida
				Cliente c4 = new Cliente();
				DecimalFormat df4 = new DecimalFormat("0.00");
				
				JTextPane txtpnConsultarDvida = new JTextPane();
				txtpnConsultarDvida.setForeground(new Color(0, 0, 160));
				txtpnConsultarDvida.setEditable(false);
				txtpnConsultarDvida.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 22));
				txtpnConsultarDvida.setText("Consultar Dívida");
				txtpnConsultarDvida.setBounds(392, 145, 203, 37);
				txtpnConsultarDvida.setOpaque(false);
				contentPane.add(txtpnConsultarDvida);
				
				JTextPane txtpnDvidaTotal = new JTextPane();
				txtpnDvidaTotal.setText("Dívida total: R$" + df4.format(Double.parseDouble(c4.encontradados(conta)[9])));
				txtpnDvidaTotal.setOpaque(false);
				txtpnDvidaTotal.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
				txtpnDvidaTotal.setEditable(false);
				txtpnDvidaTotal.setBounds(68, 218, 260, 25);
				contentPane.add(txtpnDvidaTotal);
				
				JTextPane txtpnSaldoDisponvel_1 = new JTextPane();
				txtpnSaldoDisponvel_1.setText("Saldo Disponível: R$" + df4.format(Double.parseDouble(c4.encontradados(conta)[8])));
				txtpnSaldoDisponvel_1.setOpaque(false);
				txtpnSaldoDisponvel_1.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 16));
				txtpnSaldoDisponvel_1.setEditable(false);
				txtpnSaldoDisponvel_1.setBounds(68, 253, 345, 25);
				contentPane.add(txtpnSaldoDisponvel_1);
				
				JRadioButton radioButtonPagarDIvida = new JRadioButton("Pagar Dívida");
				radioButtonPagarDIvida.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
				radioButtonPagarDIvida.setBounds(68, 314, 111, 21);
				contentPane.add(radioButtonPagarDIvida);
				
				JRadioButton rdbtnQuitarDvida = new JRadioButton("Quitar Dívida");
				rdbtnQuitarDvida.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
				rdbtnQuitarDvida.setBounds(68, 356, 111, 21);
				contentPane.add(rdbtnQuitarDvida);
			
				ButtonGroup buttonGroup = new ButtonGroup(); //grupo que garante que apenas um radio button seja acionado
				
				buttonGroup.add(radioButtonPagarDIvida);
				buttonGroup.add(rdbtnQuitarDvida);
				
				JTextPane txtpnOValorDigitado_1 = new JTextPane();
				txtpnOValorDigitado_1.setForeground(new Color(222, 9, 3));
				txtpnOValorDigitado_1.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
				txtpnOValorDigitado_1.setText("O valor digitado é maior que o saldo disponível.");
				txtpnOValorDigitado_1.setBounds(381, 356, 345, 19);
				txtpnOValorDigitado_1.setOpaque(false);
				contentPane.add(txtpnOValorDigitado_1);
				txtpnOValorDigitado_1.setVisible(false);
				
				JButton btnNewButton_3 = new JButton("Confirmar");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (Double.parseDouble(textField_2.getText())> Double.parseDouble(c4.encontradados(conta)[9])) {
								txtpnOValorDigitado_1.setText("O valor não pode ser maior que a dívida.");
								txtpnOValorDigitado_1.setVisible(true);
							}
							else if(Double.parseDouble(textField_2.getText())<= Double.parseDouble(c4.encontradados(conta)[8]) && Double.parseDouble(textField_2.getText())>0) {
								txtpnOValorDigitado_1.setVisible(false);
								c4.pagardivida(conta,Double.parseDouble(textField_2.getText()));
								FinalCliente fc = new FinalCliente("4",conta,agencia);
								fc.setVisible(true);
								dispose();
							}
							else if(Double.parseDouble(textField_2.getText())<=0) {
								txtpnOValorDigitado_1.setText("O valor deve ser maior que zero.");
								txtpnOValorDigitado_1.setVisible(true);
							}
							else if (Double.parseDouble(textField_2.getText()) > Double.parseDouble(c4.encontradados(conta)[8])){
								txtpnOValorDigitado_1.setText("O valor é maior que o saldo disponível.");
								txtpnOValorDigitado_1.setVisible(true);
							}
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_3.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
				btnNewButton_3.setBounds(766, 315, 107, 21);
				contentPane.add(btnNewButton_3);
				
				JTextPane txtpnAviso = new JTextPane();
				txtpnAviso.setForeground(new Color(222, 9, 3));
				txtpnAviso.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
				txtpnAviso.setBounds(338, 336, 627, 19);
				txtpnAviso.setOpaque(false);
				contentPane.add(txtpnAviso);
				txtpnAviso.setVisible(false);
				
				btnNewButton_3.setEnabled(false);
				textField_2 = new JTextField();
				textField_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnNewButton_3.setEnabled(true);
						btnNewButton_3.doClick();
					}
				});
				textField_2.setBounds(591, 316, 165, 19);
				contentPane.add(textField_2);
				textField_2.setColumns(10);
				
				JTextPane txtpnSaldoDisponvel_1_1 = new JTextPane();
				txtpnSaldoDisponvel_1_1.setText("Digite o valor que deseja pagar:");
				txtpnSaldoDisponvel_1_1.setOpaque(false);
				txtpnSaldoDisponvel_1_1.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
				txtpnSaldoDisponvel_1_1.setEditable(false);
				txtpnSaldoDisponvel_1_1.setBounds(375, 314, 220, 21);
				contentPane.add(txtpnSaldoDisponvel_1_1);
				
				txtpnSaldoDisponvel_1_1.setVisible(false);
				textField_2.setVisible(false);
				btnNewButton_3.setVisible(false);
				JButton btnNewButton_4 = new JButton("Confirmar Escolha");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (Double.parseDouble(c4.encontradados(conta)[9]) <= 0){
								txtpnAviso.setVisible(true);
								txtpnAviso.setText("Não existem dívidas a pagar!");
							}
							else if(radioButtonPagarDIvida.isSelected()) {
								textField_2.requestFocusInWindow();
								txtpnSaldoDisponvel_1_1.setText("Digite o valor que deseja pagar:");
								textField_2.setEnabled(true);
								textField_2.setText("");
								btnNewButton_3.setEnabled(false);
								txtpnSaldoDisponvel_1_1.setVisible(true);
								textField_2.setVisible(true);
								btnNewButton_3.setVisible(true);
							}
							else if(rdbtnQuitarDvida.isSelected()) {
								txtpnSaldoDisponvel_1_1.setText("O valor a ser pago:");
								txtpnSaldoDisponvel_1_1.setVisible(true);
								try {
									String valor = df4.format(Double.parseDouble(c4.encontradados(conta)[9]));
									valor = valor.replaceAll(",", ".");
									textField_2.setText(valor);
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								textField_2.setEnabled(false);
								textField_2.setVisible(true);
								btnNewButton_3.setEnabled(true);
								btnNewButton_3.setVisible(true);
							}
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_4.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 10));
				btnNewButton_4.setBounds(185, 334, 143, 21);
				contentPane.add(btnNewButton_4);
				
				JButton BotaoMenuC4 = new JButton("Voltar para o Menu do Cliente");
				BotaoMenuC4.addActionListener(new ActionListener() {
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
				BotaoMenuC4.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
				BotaoMenuC4.setBounds(10, 507, 241, 27);
		        contentPane.add(BotaoMenuC4);
		        
		        JLabel backgroundDi = new JLabel(new ImageIcon("C:\\Users\\jonhv\\OneDrive\\Documentos\\Photoshop\\EMJOVI\\Modelo interface2.png"));
		        backgroundDi.setBounds(-17, 483, 1012, 540);
		        contentPane.add(backgroundDi);
		        
		        Canvas dicanvas = new Canvas();
		        dicanvas.setBackground(new Color(0, 0, 160));
		        dicanvas.setForeground(new Color(0, 0, 160));
		        dicanvas.setBounds(-25, -41, 100, 100);
		        contentPane.add(dicanvas);
		        
		        Canvas dicanvas_1 = new Canvas();
		        dicanvas_1.setForeground(new Color(0, 0, 160));
		        dicanvas_1.setBackground(new Color(0, 0, 128));
		        dicanvas_1.setBounds(57, -20, 100, 100);
		        contentPane.add(dicanvas_1);
		        
		        Canvas dicanvas_2 = new Canvas();
		        dicanvas_2.setForeground(new Color(0, 0, 160));
		        dicanvas_2.setBackground(new Color(0, 0, 160));
		        dicanvas_2.setBounds(127, -41, 100, 100);
		        contentPane.add(dicanvas_2);
		        
		        Canvas dicanvas_1_1 = new Canvas();
		        dicanvas_1_1.setForeground(new Color(0, 0, 160));
		        dicanvas_1_1.setBackground(new Color(0, 0, 128));
		        dicanvas_1_1.setBounds(209, -20, 100, 100);
		        contentPane.add(dicanvas_1_1);
		        
		        Canvas dicanvas_3 = new Canvas();
		        dicanvas_3.setForeground(new Color(0, 0, 160));
		        dicanvas_3.setBackground(new Color(0, 0, 160));
		        dicanvas_3.setBounds(264, -41, 100, 100);
		        contentPane.add(dicanvas_3);
		        
		        Canvas dicanvas_1_2 = new Canvas();
		        dicanvas_1_2.setForeground(new Color(0, 0, 160));
		        dicanvas_1_2.setBackground(new Color(0, 0, 128));
		        dicanvas_1_2.setBounds(346, -20, 100, 100);
		        contentPane.add(dicanvas_1_2);
		        
		        Canvas dicanvas_4 = new Canvas();
		        dicanvas_4.setForeground(new Color(0, 0, 160));
		        dicanvas_4.setBackground(new Color(0, 0, 160));
		        dicanvas_4.setBounds(394, -41, 100, 100);
		        contentPane.add(dicanvas_4);
		        
		        Canvas dicanvas_1_3 = new Canvas();
		        dicanvas_1_3.setForeground(new Color(0, 0, 160));
		        dicanvas_1_3.setBackground(new Color(0, 0, 128));
		        dicanvas_1_3.setBounds(476, -20, 100, 100);
		        contentPane.add(dicanvas_1_3);
		        
		        Canvas dicanvas_5 = new Canvas();
		        dicanvas_5.setForeground(new Color(0, 0, 160));
		        dicanvas_5.setBackground(new Color(0, 0, 160));
		        dicanvas_5.setBounds(518, -41, 100, 100);
		        contentPane.add(dicanvas_5);
		        
		        Canvas dicanvas_1_4 = new Canvas();
		        dicanvas_1_4.setForeground(new Color(0, 0, 160));
		        dicanvas_1_4.setBackground(new Color(0, 0, 128));
		        dicanvas_1_4.setBounds(600, -20, 100, 100);
		        contentPane.add(dicanvas_1_4);
		        
		        Canvas dicanvas_6 = new Canvas();
		        dicanvas_6.setForeground(new Color(0, 0, 160));
		        dicanvas_6.setBackground(new Color(0, 0, 160));
		        dicanvas_6.setBounds(665, -41, 100, 100);
		        contentPane.add(dicanvas_6);
		        
		        Canvas dicanvas_1_5 = new Canvas();
		        dicanvas_1_5.setForeground(new Color(0, 0, 160));
		        dicanvas_1_5.setBackground(new Color(0, 0, 128));
		        dicanvas_1_5.setBounds(747, -20, 100, 100);
		        contentPane.add(dicanvas_1_5);
		        
		        Canvas dicanvas_7 = new Canvas();
		        dicanvas_7.setForeground(new Color(0, 0, 160));
		        dicanvas_7.setBackground(new Color(0, 0, 160));
		        dicanvas_7.setBounds(790, -41, 100, 100);
		        contentPane.add(dicanvas_7);
		        
		        Canvas dicanvas_1_6 = new Canvas();
		        dicanvas_1_6.setForeground(new Color(0, 0, 160));
		        dicanvas_1_6.setBackground(new Color(0, 0, 128));
		        dicanvas_1_6.setBounds(872, -20, 100, 100);
		        contentPane.add(dicanvas_1_6);

				break;
			case 5: //saque
				addWindowListener(new WindowAdapter() { // executa quando a janela é aberta
		            @Override
		            public void windowOpened(WindowEvent e) {
		                textField_1.requestFocusInWindow(); //coloca o foco, inicialmente, no textfield da agencia
		            }
		        });
				
				Cliente c5 = new Cliente();
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
				txtpnSaldoDisponvel.setText("Saldo disponível: R$"+ c5.encontradados(conta)[8]);
				txtpnSaldoDisponvel.setBounds(675, 272, 262, 22);
				txtpnSaldoDisponvel.setOpaque(false);
				contentPane.add(txtpnSaldoDisponvel);
				
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(Double.parseDouble(textField_1.getText())<=Double.parseDouble(c5.encontradados(conta)[8])) {
								c5.saque(conta, Double.parseDouble(textField_1.getText()));
								txtpnOValorDigitado.setVisible(false);
								FinalCliente fc = new FinalCliente("5",conta,agencia);
								fc.setVisible(true);
								dispose();
							}
							else {
								throw new Excessao(1);
								//txtpnOValorDigitado.setVisible(true);
							}
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Excessao e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
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
			case 6: //deposito
				addWindowListener(new WindowAdapter() { // executa quando a janela é aberta
		            @Override
		            public void windowOpened(WindowEvent e) {
		                textField_1.requestFocusInWindow(); //coloca o foco, inicialmente, no textfield da agencia
		            }
		        });
				
				Cliente c6 = new Cliente();
				btnNewButton_2 = new JButton("Confirmar");
				btnNewButton_2.setEnabled(false);
				txtpnOValorDigitado = new JTextPane();
				txtpnOValorDigitado.setForeground(new Color(217, 0, 0));
				txtpnOValorDigitado.setText("Digite um valor maior que 0.");
				txtpnOValorDigitado.setOpaque(false);
				txtpnOValorDigitado.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
				txtpnOValorDigitado.setEditable(false);
				txtpnOValorDigitado.setBounds(38, 322, 226, 22);
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
				textField_1.setBounds(264, 274, 96, 19);
				contentPane.add(textField_1);
				textField_1.setColumns(10);
				
				JTextPane txtpnDeposito = new JTextPane();
				txtpnDeposito.setForeground(new Color(0, 0, 160));
				txtpnDeposito.setEditable(false);
				txtpnDeposito.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 20));
				txtpnDeposito.setText("Depósito Bancário");
				txtpnDeposito.setBounds(405, 217, 197, 32);
				txtpnDeposito.setOpaque(false);
				contentPane.add(txtpnDeposito);
				
				txtpnDigiteAsSuas = new JTextPane();
				txtpnDigiteAsSuas.setEditable(false);
				txtpnDigiteAsSuas.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
				txtpnDigiteAsSuas.setText("Digite o valor a ser depositado:");
				txtpnDigiteAsSuas.setBounds(38, 274, 233, 19);
				txtpnDigiteAsSuas.setOpaque(false);
				contentPane.add(txtpnDigiteAsSuas);
				
				txtpnSaldoDisponvel = new JTextPane();
				txtpnSaldoDisponvel.setEditable(false);
				txtpnSaldoDisponvel.setFont(new Font("BancoDoBrasil Textos", Font.BOLD | Font.ITALIC, 14));
				txtpnSaldoDisponvel.setText("Saldo disponível: R$"+ c6.encontradados(conta)[8]);
				txtpnSaldoDisponvel.setBounds(675, 272, 262, 22);
				txtpnSaldoDisponvel.setOpaque(false);
				contentPane.add(txtpnSaldoDisponvel);
				
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(Double.parseDouble(textField_1.getText())>0) {
								c6.deposito(conta, Double.parseDouble(textField_1.getText()));
								txtpnOValorDigitado.setVisible(false);
								FinalCliente fc = new FinalCliente("6",conta,agencia);
								fc.setVisible(true);
								dispose();
							}
							else {
								throw new Excessao(2);
									//txtpnOValorDigitado.setVisible(true);
								//txtpnOValorDigitado.setVisible(true);
							}
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						} catch (Excessao e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						}
					}
				});
				btnNewButton_2.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				btnNewButton_2.setBounds(373, 272, 121, 21);
				contentPane.add(btnNewButton_2);
				
				JButton BotaoMenuC6 = new JButton("Voltar para o Menu do Cliente");
				BotaoMenuC6.addActionListener(new ActionListener() {
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
				BotaoMenuC6.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
				BotaoMenuC6.setBounds(10, 507, 241, 27);
		        contentPane.add(BotaoMenuC6);
		        
		        JLabel backgroundD = new JLabel(new ImageIcon("C:\\Users\\jonhv\\OneDrive\\Documentos\\Photoshop\\EMJOVI\\Modelo interface2.png"));
		        backgroundD.setBounds(-17, 483, 1012, 540);
		        contentPane.add(backgroundD);
		        
		        Canvas dcanvas = new Canvas();
		        dcanvas.setBackground(new Color(0, 0, 160));
		        dcanvas.setForeground(new Color(0, 0, 160));
		        dcanvas.setBounds(-25, -41, 100, 100);
		        contentPane.add(dcanvas);
		        
		        Canvas dcanvas_1 = new Canvas();
		        dcanvas_1.setForeground(new Color(0, 0, 160));
		        dcanvas_1.setBackground(new Color(0, 0, 128));
		        dcanvas_1.setBounds(57, -20, 100, 100);
		        contentPane.add(dcanvas_1);
		        
		        Canvas dcanvas_2 = new Canvas();
		        dcanvas_2.setForeground(new Color(0, 0, 160));
		        dcanvas_2.setBackground(new Color(0, 0, 160));
		        dcanvas_2.setBounds(127, -41, 100, 100);
		        contentPane.add(dcanvas_2);
		        
		        Canvas dcanvas_1_1 = new Canvas();
		        dcanvas_1_1.setForeground(new Color(0, 0, 160));
		        dcanvas_1_1.setBackground(new Color(0, 0, 128));
		        dcanvas_1_1.setBounds(209, -20, 100, 100);
		        contentPane.add(dcanvas_1_1);
		        
		        Canvas dcanvas_3 = new Canvas();
		        dcanvas_3.setForeground(new Color(0, 0, 160));
		        dcanvas_3.setBackground(new Color(0, 0, 160));
		        dcanvas_3.setBounds(264, -41, 100, 100);
		        contentPane.add(dcanvas_3);
		        
		        Canvas dcanvas_1_2 = new Canvas();
		        dcanvas_1_2.setForeground(new Color(0, 0, 160));
		        dcanvas_1_2.setBackground(new Color(0, 0, 128));
		        dcanvas_1_2.setBounds(346, -20, 100, 100);
		        contentPane.add(dcanvas_1_2);
		        
		        Canvas dcanvas_4 = new Canvas();
		        dcanvas_4.setForeground(new Color(0, 0, 160));
		        dcanvas_4.setBackground(new Color(0, 0, 160));
		        dcanvas_4.setBounds(394, -41, 100, 100);
		        contentPane.add(dcanvas_4);
		        
		        Canvas dcanvas_1_3 = new Canvas();
		        dcanvas_1_3.setForeground(new Color(0, 0, 160));
		        dcanvas_1_3.setBackground(new Color(0, 0, 128));
		        dcanvas_1_3.setBounds(476, -20, 100, 100);
		        contentPane.add(dcanvas_1_3);
		        
		        Canvas dcanvas_5 = new Canvas();
		        dcanvas_5.setForeground(new Color(0, 0, 160));
		        dcanvas_5.setBackground(new Color(0, 0, 160));
		        dcanvas_5.setBounds(518, -41, 100, 100);
		        contentPane.add(dcanvas_5);
		        
		        Canvas dcanvas_1_4 = new Canvas();
		        dcanvas_1_4.setForeground(new Color(0, 0, 160));
		        dcanvas_1_4.setBackground(new Color(0, 0, 128));
		        dcanvas_1_4.setBounds(600, -20, 100, 100);
		        contentPane.add(dcanvas_1_4);
		        
		        Canvas dcanvas_6 = new Canvas();
		        dcanvas_6.setForeground(new Color(0, 0, 160));
		        dcanvas_6.setBackground(new Color(0, 0, 160));
		        dcanvas_6.setBounds(665, -41, 100, 100);
		        contentPane.add(dcanvas_6);
		        
		        Canvas dcanvas_1_5 = new Canvas();
		        dcanvas_1_5.setForeground(new Color(0, 0, 160));
		        dcanvas_1_5.setBackground(new Color(0, 0, 128));
		        dcanvas_1_5.setBounds(747, -20, 100, 100);
		        contentPane.add(dcanvas_1_5);
		        
		        Canvas dcanvas_7 = new Canvas();
		        dcanvas_7.setForeground(new Color(0, 0, 160));
		        dcanvas_7.setBackground(new Color(0, 0, 160));
		        dcanvas_7.setBounds(790, -41, 100, 100);
		        contentPane.add(dcanvas_7);
		        
		        Canvas dcanvas_1_6 = new Canvas();
		        dcanvas_1_6.setForeground(new Color(0, 0, 160));
		        dcanvas_1_6.setBackground(new Color(0, 0, 128));
		        dcanvas_1_6.setBounds(872, -20, 100, 100);
		        contentPane.add(dcanvas_1_6);
				break;
			case 7:
				Cliente c7 = new Cliente();
				
				JTextPane textoContas = new JTextPane();
				textoContas.setForeground(new Color(0, 0, 160));
				textoContas.setEditable(false);
				textoContas.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 26));
				textoContas.setText("Pagamento de faturas");
				textoContas.setBounds(326, 10, 295, 32);
				textoContas.setOpaque(false);
				contentPane.add(textoContas);
				
				JButton BotaoMenuC7 = new JButton("Voltar para o Menu do Cliente");
				BotaoMenuC7.addActionListener(new ActionListener() {
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
				BotaoMenuC7.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
				BotaoMenuC7.setBounds(10, 507, 241, 27);
		        contentPane.add(BotaoMenuC7);
		        
		        JLabel background7 = new JLabel(new ImageIcon("C:\\Users\\jonhv\\OneDrive\\Documentos\\Photoshop\\EMJOVI\\Modelo interface2.png"));
		        background7.setBounds(-17, 483, 1012, 540);
		        contentPane.add(background7);
		        
		        JRadioButton rdbtnNewRadioButton = new JRadioButton("Inserir código");
		        rdbtnNewRadioButton.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		        rdbtnNewRadioButton.setBounds(23, 59, 197, 21);
		        contentPane.add(rdbtnNewRadioButton);
		        
		        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Buscar contas disponíveis");
		        rdbtnNewRadioButton_1.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		        rdbtnNewRadioButton_1.setBounds(23, 86, 197, 21);
		        contentPane.add(rdbtnNewRadioButton_1);
		        
		        ButtonGroup buttonGroup1 = new ButtonGroup(); //grupo que garante que apenas um radio button seja acionado
				
				buttonGroup1.add(rdbtnNewRadioButton);
				buttonGroup1.add(rdbtnNewRadioButton_1);
				
				JButton btnNewButton_7 = new JButton("Confirma");
				
				textField_3 = new JTextField();
				textField_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnNewButton_7.doClick();
					}
				});
		        textField_3.setBounds(130, 161, 126, 19);
		        contentPane.add(textField_3);
		        textField_3.setColumns(10);
		        
		        JTextPane txtpnDigiteOCdigo = new JTextPane();
		        txtpnDigiteOCdigo.setText("Digite o código");
		        txtpnDigiteOCdigo.setOpaque(false);
		        txtpnDigiteOCdigo.setForeground(new Color(0, 0, 0));
		        txtpnDigiteOCdigo.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		        txtpnDigiteOCdigo.setEditable(false);
		        txtpnDigiteOCdigo.setBounds(23, 161, 160, 21);
		        contentPane.add(txtpnDigiteOCdigo);
		        
		        textField_4 = new JTextField();
		        textField_4.setEditable(false);
		        textField_4.setColumns(10);
		        textField_4.setBounds(130, 190, 257, 19);
		        contentPane.add(textField_4);
		        
		        textField_5 = new JTextField();
		        textField_5.setEditable(false);
		        textField_5.setColumns(10);
		        textField_5.setBounds(130, 219, 257, 19);
		        contentPane.add(textField_5);
		        
		        textField_6 = new JTextField();
		        textField_6.setEditable(false);
		        textField_6.setColumns(10);
		        textField_6.setBounds(130, 248, 257, 19);
		        contentPane.add(textField_6);
		        
		        textField_7 = new JTextField();
		        textField_7.setEditable(false);
		        textField_7.setColumns(10);
		        textField_7.setBounds(130, 277, 257, 19);
		        contentPane.add(textField_7);
		        
		        JTextPane txtpnOCdigoNo = new JTextPane();
		        txtpnOCdigoNo.setText("O código não corresponde a nenhuma fatura ou ela já foi paga");
		        txtpnOCdigoNo.setOpaque(false);
		        txtpnOCdigoNo.setForeground(new Color(183, 0, 0));
		        txtpnOCdigoNo.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		        txtpnOCdigoNo.setEditable(false);
		        txtpnOCdigoNo.setBounds(398, 161, 419, 21);
		        txtpnOCdigoNo.setVisible(false);
		        contentPane.add(txtpnOCdigoNo);
		        
		        JTextPane txtpnValor = new JTextPane();
		        txtpnValor.setText("Valor (R$)");
		        txtpnValor.setOpaque(false);
		        txtpnValor.setForeground(Color.BLACK);
		        txtpnValor.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		        txtpnValor.setEditable(false);
		        txtpnValor.setBounds(48, 188, 76, 21);
		        contentPane.add(txtpnValor);
		        
		        JTextPane txtpnDigiteOCdigo_1_1 = new JTextPane();
		        txtpnDigiteOCdigo_1_1.setText("Descrição");
		        txtpnDigiteOCdigo_1_1.setOpaque(false);
		        txtpnDigiteOCdigo_1_1.setForeground(Color.BLACK);
		        txtpnDigiteOCdigo_1_1.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		        txtpnDigiteOCdigo_1_1.setEditable(false);
		        txtpnDigiteOCdigo_1_1.setBounds(57, 219, 70, 21);
		        contentPane.add(txtpnDigiteOCdigo_1_1);
		        
		        JTextPane txtpnDigiteOCdigo_1_2 = new JTextPane();
		        txtpnDigiteOCdigo_1_2.setText("Vencido?");
		        txtpnDigiteOCdigo_1_2.setOpaque(false);
		        txtpnDigiteOCdigo_1_2.setForeground(Color.BLACK);
		        txtpnDigiteOCdigo_1_2.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		        txtpnDigiteOCdigo_1_2.setEditable(false);
		        txtpnDigiteOCdigo_1_2.setBounds(57, 246, 70, 21);
		        contentPane.add(txtpnDigiteOCdigo_1_2);
		        
		        JTextPane txtpnDigiteOCdigo_1_3 = new JTextPane();
		        txtpnDigiteOCdigo_1_3.setText("Juros(%)");
		        txtpnDigiteOCdigo_1_3.setOpaque(false);
		        txtpnDigiteOCdigo_1_3.setForeground(Color.BLACK);
		        txtpnDigiteOCdigo_1_3.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		        txtpnDigiteOCdigo_1_3.setEditable(false);
		        txtpnDigiteOCdigo_1_3.setBounds(48, 275, 72, 21);
		        contentPane.add(txtpnDigiteOCdigo_1_3);
		        
		        textField_8 = new JTextField();
		        textField_8.setEditable(false);
		        textField_8.setBounds(130, 306, 257, 19);
		        contentPane.add(textField_8);
		        textField_8.setColumns(10);
		        
		        JTextPane txtpnValorTotal = new JTextPane();
		        txtpnValorTotal.setEditable(false);
		        txtpnValorTotal.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 14));
		        txtpnValorTotal.setText("Valor total (R$)" + valortotal);
		        txtpnValorTotal.setBounds(39, 306, 85, 19);
		        txtpnValorTotal.setOpaque(false);
		        contentPane.add(txtpnValorTotal);
		        
		        JButton btnNewButton_7_1 = new JButton("PAGAR");
		        btnNewButton_7_1.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		try {
							c7.pagarconta(conta, textField_3.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        		FinalCliente fc = new FinalCliente("7",conta,agencia);
		        		fc.setVisible(true);
		        		dispose();
		        	}
		        });
		        btnNewButton_7_1.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 13));
		        btnNewButton_7_1.setBounds(209, 332, 85, 21);
		        contentPane.add(btnNewButton_7_1);
		        
		        btnNewButton_7.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		try {
							if(c7.conferecod(textField_3.getText(),conta)) { //se existe código correspondente
								txtpnOCdigoNo.setVisible(false);
								textField_4.setText(c7.dadosfatura(textField_3.getText())[0]);
								textField_5.setText(c7.dadosfatura(textField_3.getText())[1]);
								System.out.println(c7.dadosfatura(textField_3.getText())[2]);
								String textVencimento = c7.dadosfatura(textField_3.getText())[2].equals("t") ? "Sim" : "Não";
								textField_6.setText(textVencimento); //sim ou não
								textField_7.setText(c7.dadosfatura(textField_3.getText())[3]);
								if (c7.dadosfatura(textField_3.getText())[2].equals("t")){ //se está vencido
						        	valortotal = Double.parseDouble(textField_4.getText()) + (Double.parseDouble(textField_7.getText()) * (Double.parseDouble(textField_4.getText())/100));
						        }
						        else {
						        	valortotal = Double.parseDouble(textField_4.getText());
						        }
								textField_8.setText(String.valueOf(valortotal));
								btnNewButton_7_1.requestFocusInWindow();
							}
							else {
								txtpnOCdigoNo.setVisible(true);
						        textField_4.setText("");
						        textField_5.setText("");
						        textField_6.setText("");
						        textField_7.setText("");
						        textField_8.setText("");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        	}
		        });
		        btnNewButton_7.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 10));
		        btnNewButton_7.setBounds(279, 160, 85, 21);
		        contentPane.add(btnNewButton_7);
		        
		        textField_3.setVisible(false);
		        textField_4.setVisible(false);
		        textField_5.setVisible(false);
		        textField_6.setVisible(false);
		        textField_7.setVisible(false);
		        textField_8.setVisible(false);
		        txtpnValor.setVisible(false);
		        txtpnDigiteOCdigo.setVisible(false);
		        txtpnDigiteOCdigo_1_1.setVisible(false);
		        txtpnDigiteOCdigo_1_2.setVisible(false);
		        txtpnDigiteOCdigo_1_3.setVisible(false);
		        btnNewButton_7.setVisible(false);
		        btnNewButton_7_1.setVisible(false);
		        txtpnValorTotal.setVisible(false);
		        
		        ArrayList<String> codigos = new ArrayList<String>();
		        codigos.addAll(c7.codigos());
		        
		        DefaultComboBoxModel<String> cods = new DefaultComboBoxModel<>();
				
				for(int i = 0; i < codigos.size(); i++) {
					cods.addElement("Código da Fatura: " + codigos.get(i));
				}
		        
		        JComboBox comboBox_1 = new JComboBox(cods);
		        comboBox_1.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		int i = comboBox_1.getSelectedIndex(); //qual posição do combobox foi escolhida
		        		textField_3.setText(codigos.get(i));
		        		btnNewButton_7.doClick();
		        		textField_3.setVisible(true);
		        		textField_3.setEnabled(false);
						textField_4.setVisible(true);
				        textField_5.setVisible(true);
				        textField_6.setVisible(true);
				        textField_7.setVisible(true);
				        textField_8.setVisible(true);
				        txtpnValor.setVisible(true);
				        txtpnDigiteOCdigo.setVisible(true);
				        txtpnDigiteOCdigo_1_1.setVisible(true);
				        txtpnDigiteOCdigo_1_2.setVisible(true);
				        txtpnDigiteOCdigo_1_3.setVisible(true);
				        //btnNewButton_7.setVisible(true);
				        btnNewButton_7_1.setVisible(true);
				        txtpnValorTotal.setVisible(true);
				        btnNewButton_7_1.requestFocusInWindow();
		        	}
		        });
		        comboBox_1.setToolTipText("Selecione a fatura");
		        comboBox_1.setBounds(23, 113, 939, 21);
		        contentPane.add(comboBox_1);
		        comboBox_1.setVisible(false);
		        
				JButton btnNewButton_6 = new JButton("Confirma escolha");
				btnNewButton_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (rdbtnNewRadioButton.isSelected()) { //se porta o código
							textField_3.setText("");
							txtpnOCdigoNo.setVisible(false);
							textField_3.setEnabled(true);
							textField_3.setVisible(true);
							textField_4.setVisible(true);
					        textField_5.setVisible(true);
					        textField_6.setVisible(true);
					        textField_7.setVisible(true);
					        textField_8.setVisible(true);
					        txtpnValor.setVisible(true);
					        txtpnDigiteOCdigo.setVisible(true);
					        txtpnDigiteOCdigo_1_1.setVisible(true);
					        txtpnDigiteOCdigo_1_2.setVisible(true);
					        txtpnDigiteOCdigo_1_3.setVisible(true);
					        btnNewButton_7.setVisible(true);
					        btnNewButton_7_1.setVisible(true);
					        txtpnValorTotal.setVisible(true);
					        comboBox_1.setVisible(false);
					        textField_3.requestFocusInWindow();
						}
						else if (rdbtnNewRadioButton_1.isSelected()){ //se quer buscar
							textField_3.setVisible(false);
							textField_4.setVisible(false);
					        textField_5.setVisible(false);
					        textField_6.setVisible(false);
					        textField_7.setVisible(false);
					        textField_8.setVisible(false);
					        txtpnValor.setVisible(false);
					        txtpnDigiteOCdigo.setVisible(false);
					        txtpnDigiteOCdigo_1_1.setVisible(false);
					        txtpnDigiteOCdigo_1_2.setVisible(false);
					        txtpnDigiteOCdigo_1_3.setVisible(false);
					        btnNewButton_7.setVisible(false);
					        btnNewButton_7_1.setVisible(false);
					        txtpnValorTotal.setVisible(false);
					        comboBox_1.setVisible(true);
						}
					}
				});
		        btnNewButton_6.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 10));
		        btnNewButton_6.setBounds(226, 70, 138, 21);
		        contentPane.add(btnNewButton_6);
				break;
			case 8:
				addWindowListener(new WindowAdapter() { // executa quando a janela é aberta
		            @Override
		            public void windowOpened(WindowEvent e) {
		                textField_10.requestFocusInWindow(); //coloca o foco, inicialmente, no textfield da agencia
		            }
		        });
				
				Cliente c8 = new Cliente();
				btnNewButton_2 = new JButton("Confirmar");
				btnNewButton_2.setEnabled(false);
				txtpnOValorDigitado = new JTextPane();
				txtpnOValorDigitado.setForeground(new Color(217, 0, 0));
				txtpnOValorDigitado.setText("Digite um valor maior que 0.");
				txtpnOValorDigitado.setOpaque(false);
				txtpnOValorDigitado.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
				txtpnOValorDigitado.setEditable(false);
				txtpnOValorDigitado.setBounds(41, 403, 486, 22);
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
				textField_1.setBounds(269, 362, 96, 19);
				contentPane.add(textField_1);
				textField_1.setColumns(10);
				textField_1.setVisible(false);
				
				JTextPane txtpnDeposito2 = new JTextPane();
				txtpnDeposito2.setForeground(new Color(0, 0, 160));
				txtpnDeposito2.setEditable(false);
				txtpnDeposito2.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 20));
				txtpnDeposito2.setText("Transação Bancária");
				txtpnDeposito2.setBounds(405, 217, 197, 32);
				txtpnDeposito2.setOpaque(false);
				contentPane.add(txtpnDeposito2);
				
				txtpnDigiteAsSuas = new JTextPane();
				txtpnDigiteAsSuas.setEditable(false);
				txtpnDigiteAsSuas.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
				txtpnDigiteAsSuas.setText("Digite o valor a ser depositado:");
				txtpnDigiteAsSuas.setBounds(41, 362, 233, 19);
				txtpnDigiteAsSuas.setOpaque(false);
				txtpnDigiteAsSuas.setVisible(false);
				contentPane.add(txtpnDigiteAsSuas);
				
				txtpnSaldoDisponvel = new JTextPane();
				txtpnSaldoDisponvel.setEditable(false);
				txtpnSaldoDisponvel.setFont(new Font("BancoDoBrasil Textos", Font.BOLD | Font.ITALIC, 14));
				txtpnSaldoDisponvel.setText("Saldo disponível: R$"+ c8.encontradados(conta)[8]);
				txtpnSaldoDisponvel.setBounds(624, 362, 262, 22);
				txtpnSaldoDisponvel.setOpaque(false);
				txtpnSaldoDisponvel.setVisible(false);
				contentPane.add(txtpnSaldoDisponvel);
				
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (Double.parseDouble(textField_1.getText()) > Double.parseDouble(c8.encontradados(conta)[8])) {
								txtpnOValorDigitado.setVisible(true);
								txtpnOValorDigitado.setText("O valor é maior que seu saldo atual");
								textField_1.requestFocusInWindow();
							}
							else if(Double.parseDouble(textField_1.getText())>0) {
								c8.deposito(textField_9.getText(), Double.parseDouble(textField_1.getText()));
								c8.saque(conta,Double.parseDouble(textField_1.getText()));
								txtpnOValorDigitado.setVisible(false);
								FinalCliente fc = new FinalCliente("8",conta,agencia);
								fc.setVisible(true);
								dispose();
							}
							else {
								txtpnOValorDigitado.setVisible(true);
								textField_1.requestFocusInWindow();
							}
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_2.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
				btnNewButton_2.setBounds(376, 360, 121, 21);
				btnNewButton_2.setVisible(false);
				contentPane.add(btnNewButton_2);
				
				JButton BotaoMenuC8 = new JButton("Voltar para o Menu do Cliente");
				BotaoMenuC8.addActionListener(new ActionListener() {
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
				BotaoMenuC8.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
				BotaoMenuC8.setBounds(10, 507, 241, 27);
		        contentPane.add(BotaoMenuC8);
		        
		        JLabel backgroundD2 = new JLabel(new ImageIcon("C:\\Users\\jonhv\\OneDrive\\Documentos\\Photoshop\\EMJOVI\\Modelo interface2.png"));
		        backgroundD2.setBounds(-17, 483, 1012, 540);
		        contentPane.add(backgroundD2);
		        
		        Canvas d2canvas = new Canvas();
		        d2canvas.setBackground(new Color(0, 0, 160));
		        d2canvas.setForeground(new Color(0, 0, 160));
		        d2canvas.setBounds(-25, -41, 100, 100);
		        contentPane.add(d2canvas);
		        
		        Canvas d2canvas_1 = new Canvas();
		        d2canvas_1.setForeground(new Color(0, 0, 160));
		        d2canvas_1.setBackground(new Color(0, 0, 128));
		        d2canvas_1.setBounds(57, -20, 100, 100);
		        contentPane.add(d2canvas_1);
		        
		        Canvas d2canvas_2 = new Canvas();
		        d2canvas_2.setForeground(new Color(0, 0, 160));
		        d2canvas_2.setBackground(new Color(0, 0, 160));
		        d2canvas_2.setBounds(127, -41, 100, 100);
		        contentPane.add(d2canvas_2);
		        
		        Canvas d2canvas_1_1 = new Canvas();
		        d2canvas_1_1.setForeground(new Color(0, 0, 160));
		        d2canvas_1_1.setBackground(new Color(0, 0, 128));
		        d2canvas_1_1.setBounds(209, -20, 100, 100);
		        contentPane.add(d2canvas_1_1);
		        
		        Canvas d2canvas_3 = new Canvas();
		        d2canvas_3.setForeground(new Color(0, 0, 160));
		        d2canvas_3.setBackground(new Color(0, 0, 160));
		        d2canvas_3.setBounds(264, -41, 100, 100);
		        contentPane.add(d2canvas_3);
		        
		        Canvas d2canvas_1_2 = new Canvas();
		        d2canvas_1_2.setForeground(new Color(0, 0, 160));
		        d2canvas_1_2.setBackground(new Color(0, 0, 128));
		        d2canvas_1_2.setBounds(346, -20, 100, 100);
		        contentPane.add(d2canvas_1_2);
		        
		        Canvas d2canvas_4 = new Canvas();
		        d2canvas_4.setForeground(new Color(0, 0, 160));
		        d2canvas_4.setBackground(new Color(0, 0, 160));
		        d2canvas_4.setBounds(394, -41, 100, 100);
		        contentPane.add(d2canvas_4);
		        
		        Canvas d2canvas_1_3 = new Canvas();
		        d2canvas_1_3.setForeground(new Color(0, 0, 160));
		        d2canvas_1_3.setBackground(new Color(0, 0, 128));
		        d2canvas_1_3.setBounds(476, -20, 100, 100);
		        contentPane.add(d2canvas_1_3);
		        
		        Canvas d2canvas_5 = new Canvas();
		        d2canvas_5.setForeground(new Color(0, 0, 160));
		        d2canvas_5.setBackground(new Color(0, 0, 160));
		        d2canvas_5.setBounds(518, -41, 100, 100);
		        contentPane.add(d2canvas_5);
		        
		        Canvas d2canvas_1_4 = new Canvas();
		        d2canvas_1_4.setForeground(new Color(0, 0, 160));
		        d2canvas_1_4.setBackground(new Color(0, 0, 128));
		        d2canvas_1_4.setBounds(600, -20, 100, 100);
		        contentPane.add(d2canvas_1_4);
		        
		        Canvas d2canvas_6 = new Canvas();
		        d2canvas_6.setForeground(new Color(0, 0, 160));
		        d2canvas_6.setBackground(new Color(0, 0, 160));
		        d2canvas_6.setBounds(665, -41, 100, 100);
		        contentPane.add(d2canvas_6);
		        
		        Canvas d2canvas_1_5 = new Canvas();
		        d2canvas_1_5.setForeground(new Color(0, 0, 160));
		        d2canvas_1_5.setBackground(new Color(0, 0, 128));
		        d2canvas_1_5.setBounds(747, -20, 100, 100);
		        contentPane.add(d2canvas_1_5);
		        
		        Canvas d2canvas_7 = new Canvas();
		        d2canvas_7.setForeground(new Color(0, 0, 160));
		        d2canvas_7.setBackground(new Color(0, 0, 160));
		        d2canvas_7.setBounds(790, -41, 100, 100);
		        contentPane.add(d2canvas_7);
		        
		        Canvas d2canvas_1_6 = new Canvas();
		        d2canvas_1_6.setForeground(new Color(0, 0, 160));
		        d2canvas_1_6.setBackground(new Color(0, 0, 128));
		        d2canvas_1_6.setBounds(872, -20, 100, 100);
		        contentPane.add(d2canvas_1_6);
		        
		        JButton btnConfirmaConta = new JButton("Confirmar");
		        
		        textField_9 = new JTextField();
		        textField_9.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		btnConfirmaConta.setEnabled(true);
		        		btnConfirmaConta.doClick();
		        	}
		        });
		        textField_9.setBounds(232, 298, 96, 19);
		        contentPane.add(textField_9);
		        textField_9.setColumns(10);
		        
		        JTextPane txtpnContaErrada = new JTextPane();
		        txtpnContaErrada.setText("A conta informada não existe");
		        txtpnContaErrada.setForeground(new Color(183, 0, 0));
		        txtpnContaErrada.setEditable(false);
		        txtpnContaErrada.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
		        txtpnContaErrada.setBounds(335, 282, 609, 22);
		        txtpnContaErrada.setOpaque(false);
		        txtpnContaErrada.setVisible(false);
				contentPane.add(txtpnContaErrada);
		        
		        JTextPane txtpnDigiteAConta = new JTextPane();
		        txtpnDigiteAConta.setText("Dados sobre o depósito:");
		        txtpnDigiteAConta.setOpaque(false);
		        txtpnDigiteAConta.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
		        txtpnDigiteAConta.setEditable(false);
		        txtpnDigiteAConta.setBounds(39, 242, 262, 19);
		        contentPane.add(txtpnDigiteAConta);
		        
		        
		        btnConfirmaConta.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		try {
							if (!c8.verificaconta(textField_9.getText(),textField_10.getText())) { //se a conta não existe
								btnNewButton_2.setVisible(false);
								txtpnSaldoDisponvel.setVisible(false);
								textField_1.setVisible(false);
								txtpnDigiteAsSuas.setVisible(false);
								txtpnContaErrada.setVisible(true);
							}
							else if (textField_9.getText().equals(conta) && textField_10.getText().equals(agencia)) {
								txtpnContaErrada.setText("Para depositar em sua própria conta volte ao menu e selecione DEPÓSITO");
								txtpnContaErrada.setVisible(true);
							}
							else {
								txtpnContaErrada.setVisible(false);
								btnNewButton_2.setVisible(true);
								txtpnSaldoDisponvel.setVisible(true);
								textField_1.setVisible(true);
								textField_1.requestFocusInWindow();
								txtpnDigiteAsSuas.setVisible(true);
								textField_9.setEnabled(false);
								textField_10.setEnabled(false);
								btnConfirmaConta.setEnabled(false);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        	}
		        });
		        btnConfirmaConta.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 12));
		        btnConfirmaConta.setEnabled(false);
		        btnConfirmaConta.setBounds(332, 311, 121, 21);
		        contentPane.add(btnConfirmaConta); 
		        
		        textField_10 = new JTextField();
		        textField_10.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		textField_9.requestFocusInWindow();
		        	}
		        });
		        textField_10.setColumns(10);
		        textField_10.setBounds(232, 272, 96, 19);
		        contentPane.add(textField_10);
		        
		        JTextPane txtpnAgncia = new JTextPane();
		        txtpnAgncia.setText("Agência");
		        txtpnAgncia.setOpaque(false);
		        txtpnAgncia.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
		        txtpnAgncia.setEditable(false);
		        txtpnAgncia.setBounds(169, 271, 262, 19);
		        contentPane.add(txtpnAgncia);
		        
		        JTextPane txtpnConta = new JTextPane();
		        txtpnConta.setText("Conta");
		        txtpnConta.setOpaque(false);
		        txtpnConta.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
		        txtpnConta.setEditable(false);
		        txtpnConta.setBounds(182, 295, 262, 19);
		        contentPane.add(txtpnConta);
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
