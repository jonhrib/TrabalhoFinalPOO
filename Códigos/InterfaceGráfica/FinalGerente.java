package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FinalGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalGerente frame = new FinalGerente(null,null,null);
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
	public FinalGerente(String cod, String agencia, String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
        contentPane.setLayout(null);
        
        switch (cod) {
    	case "1":
    		JTextPane txtpnCadastroEfetivadoCom = new JTextPane();
            txtpnCadastroEfetivadoCom.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
            txtpnCadastroEfetivadoCom.setForeground(new Color(255, 255, 255));
            txtpnCadastroEfetivadoCom.setText("Cadastro efetivado com sucesso!");
            txtpnCadastroEfetivadoCom.setOpaque(false);
            txtpnCadastroEfetivadoCom.setBounds(303, 287, 339, 34);
            contentPane.add(txtpnCadastroEfetivadoCom);
    		break;
    	case "2":
    		JTextPane txtpnContaRemovida = new JTextPane();
    		txtpnContaRemovida.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
    		txtpnContaRemovida.setForeground(new Color(255, 255, 255));
    		txtpnContaRemovida.setText("Conta removida com sucesso!");
    		txtpnContaRemovida.setOpaque(false);
    		txtpnContaRemovida.setBounds(303, 287, 339, 34);
            contentPane.add(txtpnContaRemovida);
    		break;
    	case "3.1":
    		JTextPane txtpnEmpA = new JTextPane();
    		txtpnEmpA.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
    		txtpnEmpA.setForeground(new Color(255, 255, 255));
    		txtpnEmpA.setText("Empréstimo aprovado!");
    		txtpnEmpA.setOpaque(false);
    		txtpnEmpA.setBounds(303, 287, 339, 34);
            contentPane.add(txtpnEmpA);
    		break;
    	case "3.2":
    		JTextPane txtpnEmpR = new JTextPane();
    		txtpnEmpR.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
    		txtpnEmpR.setForeground(new Color(255, 255, 255));
    		txtpnEmpR.setText("Empréstimo negado!");
    		txtpnEmpR.setOpaque(false);
    		txtpnEmpR.setBounds(303, 287, 339, 34);
            contentPane.add(txtpnEmpR);
    		break;
    }
        
        JButton btnNewButton_1 = new JButton("Voltar para o Menu do Gerente");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MenuGerente mg = null;
				try {
					mg = new MenuGerente(agencia,id);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		mg.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnNewButton_1.setBounds(10, 518, 241, 27);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_1_1 = new JButton("Voltar para Menu Inicial");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Inicial i = new Inicial();
        		i.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnNewButton_1_1.setBounds(772, 518, 190, 27);
        contentPane.add(btnNewButton_1_1);
        

		// plano de fundo
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\jonhv\\OneDrive\\Documentos\\Photoshop\\EMJOVI\\Modelo interface2.png"));
        background.setBounds(-14, 0, 998, 592);
        contentPane.add(background);
        
	}

}
