package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ConfirmaSenha extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfirmaSenha dialog = new ConfirmaSenha(null,null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfirmaSenha(String senhaatual, String conta, String agencia) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnSenhaIncorreta = new JTextPane();
		txtpnSenhaIncorreta.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(116, 119, 131, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnSenhaAtuak = new JTextPane();
		txtpnSenhaAtuak.setEditable(false);
		txtpnSenhaAtuak.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
		txtpnSenhaAtuak.setText("Senha Atual");
		txtpnSenhaAtuak.setBounds(257, 119, 75, 19);
		txtpnSenhaAtuak.setOpaque(false);
		contentPanel.add(txtpnSenhaAtuak);
		
		JTextPane txtpnParaContinuarDigite = new JTextPane();
		txtpnParaContinuarDigite.setEditable(false);
		txtpnParaContinuarDigite.setText("Para continuar digite a sua senha atual");
		txtpnParaContinuarDigite.setOpaque(false);
		txtpnParaContinuarDigite.setFont(new Font("BancoDoBrasil Textos", Font.BOLD, 14));
		txtpnParaContinuarDigite.setBounds(81, 74, 279, 19);
		contentPanel.add(txtpnParaContinuarDigite);

		txtpnSenhaIncorreta.setEditable(false);
		txtpnSenhaIncorreta.setForeground(new Color(221, 0, 0));
		txtpnSenhaIncorreta.setText("Senha Incorreta");
		txtpnSenhaIncorreta.setOpaque(false);
		txtpnSenhaIncorreta.setFont(new Font("BancoDoBrasil Textos", Font.PLAIN, 12));
		txtpnSenhaIncorreta.setBounds(165, 158, 104, 19);
		contentPanel.add(txtpnSenhaIncorreta);
		
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textField.getText().equals(senhaatual)) {
						txtpnSenhaIncorreta.setVisible(false);
						FinalCliente fc = new FinalCliente("1.1",conta,agencia);
						fc.setVisible(true);
						dispose();
					}
					else {
						txtpnSenhaIncorreta.setVisible(true);
					}
				}
			});
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FinalCliente fc = new FinalCliente("1.2",conta,agencia);
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}
	}

}
