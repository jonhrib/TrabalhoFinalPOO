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

public class FinalCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalCliente frame = new FinalCliente(null,null,null);
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
	public FinalCliente(String cod, String conta, String agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
        contentPane.setLayout(null);
        
        switch (cod) {
    	case "1.1":
    		JTextPane txtpnCadastroEfetivadoCom = new JTextPane();
            txtpnCadastroEfetivadoCom.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
            txtpnCadastroEfetivadoCom.setForeground(new Color(255, 255, 255));
            txtpnCadastroEfetivadoCom.setText("Dados modificados com sucesso!");
            txtpnCadastroEfetivadoCom.setOpaque(false);
            txtpnCadastroEfetivadoCom.setBounds(305, 285, 339, 34);
            contentPane.add(txtpnCadastroEfetivadoCom);
    		break;
    	case "1.2":
    		JTextPane txtpnContaRemovida = new JTextPane();
    		txtpnContaRemovida.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
    		txtpnContaRemovida.setForeground(new Color(255, 255, 255));
    		txtpnContaRemovida.setText("Os dados não foram modificados!");
    		txtpnContaRemovida.setOpaque(false);
    		txtpnContaRemovida.setBounds(315, 287, 339, 34);
            contentPane.add(txtpnContaRemovida);
    		break;
    	case "3.1":
    		JTextPane txtpnPedidoEncaminhado = new JTextPane();
    		txtpnPedidoEncaminhado.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
    	    txtpnPedidoEncaminhado.setForeground(new Color(255, 255, 255));
    	    txtpnPedidoEncaminhado.setText("Seu pedido foi encaminhado para análise!");
    	    txtpnPedidoEncaminhado.setOpaque(false);
    	    txtpnPedidoEncaminhado.setBounds(269, 286, 463, 34);
    	    txtpnPedidoEncaminhado.setEditable(false);
    	    contentPane.add(txtpnPedidoEncaminhado);
    		break;
    		
    	case "3.2":
    		JTextPane txtpnPedidoAprovado = new JTextPane();
    		txtpnPedidoAprovado.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
    		txtpnPedidoAprovado.setForeground(new Color(255, 255, 255));
    		txtpnPedidoAprovado.setText("Seu pedido foi efetuado com sucesso!");
    		txtpnPedidoAprovado.setOpaque(false);
    		txtpnPedidoAprovado.setBounds(287, 286, 463, 34);
    		txtpnPedidoAprovado.setEditable(false);
    	    contentPane.add(txtpnPedidoAprovado);
    		break;
    	case "5":
    		JTextPane txtpnSaque = new JTextPane();
    		txtpnSaque.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
    		txtpnSaque.setForeground(new Color(255, 255, 255));
    		txtpnSaque.setText("Seu saque foi efetuado com sucesso!");
    		txtpnSaque.setOpaque(false);
    		txtpnSaque.setBounds(287, 286, 463, 34);
    		txtpnSaque.setEditable(false);
    	    contentPane.add(txtpnSaque);
    		break;
    }
        
        JButton btnNewButton_1 = new JButton("Voltar para o Menu do Cliente");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MenuCliente mg = null;
				try {
					mg = new MenuCliente(agencia,conta);
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
