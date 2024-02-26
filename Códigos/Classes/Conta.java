package Classes;
import java.sql.SQLException;


public abstract class Conta extends Conexao implements BancoEmjovi {
	
	Conta() throws ClassNotFoundException, SQLException {
		super();
	}

	protected String UF;
	protected String agencia;
	protected String senha;
	protected String nome;
	
	@Override
	public abstract boolean acessar(int cod, String s, String s1, String s2) throws SQLException;

	@Override
	public abstract String[] encontradados(String conta) throws SQLException;
	
//	public static String formatarTelefone(String telefone) {
//		//remove tudo que não sejam números de 0 a 9
//	    telefone = telefone.replaceAll("[^0-9]", ""); //regex ou expressão regular
//
//	    // Aplica a formatação do telefone (xx) xxxx-xxxx
//	    return "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 7) + "-" + telefone.substring(7, 11);
//	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
