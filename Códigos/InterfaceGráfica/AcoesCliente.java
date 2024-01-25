package InterfaceGrafica;

import java.awt.EventQueue;


import javax.swing.JFrame;
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
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class AcoesCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane txtpnValorDisponvel;
	private JTextField textField;
	private double valorrequerido, valorfinal;

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
			case 1:
				
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
						int qtdparcela = Integer.parseInt(comboBox.getSelectedItem().toString());
						
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
									dispose();
								}
								else {
									FinalCliente fc = new FinalCliente("3.2",conta,agencia);
									fc.setVisible(true);
									c.deposito(conta,valorrequerido);
									c.aumentardivida(conta, valorfinal);
									c.retirarvalordeemprestimo(conta, valorrequerido);
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
				break;	
			case 4:
				
				break;
			case 5:
				
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
