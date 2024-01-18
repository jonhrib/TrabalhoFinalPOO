package Classes;
import java.sql.SQLException;
import java.sql.Statement;

public class Gerente extends Conta {
	
	Gerente() throws ClassNotFoundException, SQLException {
		super();
		
	}

	String ID;
	
	@Override
	public boolean acessar(int cod, String s, String s1, String s2) throws SQLException {
		
		return false;
	}
	
	void criarconta (String nome, String uf, String agencia, String numconta, int idade, String cpf, String senha, String tipodeconta, double renda, double saldo, double divida, String telefone) throws SQLException {
		
		//System.out.println("insert into cliente (nome,uf,agencia,numconta,idade,cpf,senha,tipodeconta,renda,saldo,divida,telefone) VALUES ('" + nome + "'," + "'" + uf + "'," + "'" + agencia + "','" + numconta + "'," + idade + ",'" + cpf + "','" + senha + "','" + tipodeconta + "'," + renda + "," + saldo + "," + divida +  ",'" + telefone + "')");
		String SQLInsert = "insert into cliente (nome,uf,agencia,numconta,idade,cpf,senha,tipodeconta,renda,saldo,divida,telefone) VALUES ('" + nome + "'," + "'" + uf + "'," + "'" + agencia + "','" + numconta + "'," + idade + ",'" + cpf + "','" + senha + "','" + tipodeconta + "'," + renda + "," + saldo + "," + divida +  ",'" + telefone + "')";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(SQLInsert);
		
	}
	
	void excluirconta () {
		
	}
	
	boolean avaliaremprestimo () {
		
		return false;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}
