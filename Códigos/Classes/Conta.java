package Classes;
import java.sql.SQLException;


public abstract class Conta extends Conexao implements BancoEmjovi {
	
	Conta() throws ClassNotFoundException, SQLException {
		super();
	}

	String UF;
	String agencia;
	String senha;
	String nome;

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
