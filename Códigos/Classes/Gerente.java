package Classes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Gerente extends Conta {
	
	public Gerente() throws ClassNotFoundException, SQLException {
		super();
		
	}

	String ID;
	
	@Override
	public boolean acessar(int cod, String s, String s1, String s2) throws SQLException {
		Statement stmt = con.createStatement();
		boolean result = false;
		
		if (cod == 1) { //Agencia
			//"select nome,uf,agencia,numconta,idade,cpf,senha,tipodeconta,renda,saldo,divida,telefone from cliente"
			ResultSet dados = stmt.executeQuery("select agencia from gerente");
			if (dados.isBeforeFirst()) {
				
				while (dados.next()) {
					String agencia = dados.getString(1);
					if (s.equals(agencia)) {
						result = true;
					}
				}
			}
			
			return result;
		} 
		else if (cod == 2) { //ID
			ResultSet dados = stmt.executeQuery("select agencia,id from gerente");
			if (dados.isBeforeFirst()) {
				
				while (dados.next()) {
					String agencia = dados.getString(1);
					String id = dados.getString(2);
					if (s.equals(agencia) && s1.equals(id)) {
						result = true;
					}
				}
			}
			
			return result;
		}
		else if (cod == 3) { //Senha
			ResultSet dados = stmt.executeQuery("select agencia,id,senha from gerente");
			if (dados.isBeforeFirst()) {
				
				while (dados.next()) {
					String agencia = dados.getString(1);
					String id = dados.getString(2);
					String senha = dados.getString(3);
					
					if (s.equals(agencia) && s1.equals(id) && s2.equals(senha)) {
						result = true;
					}
				}
			}
			
			return result;
		}
		else return false;
	}
	
	public String[] encontranome (String id) throws SQLException {
		Statement stmt = con.createStatement();
		String nome, uf;
		
		ResultSet dados = stmt.executeQuery("select id,nome,uf from gerente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (id.equals(teste)) {
					nome = dados.getString(2);
					uf = dados.getString(3);
					String[] s = {nome,uf};
					return s;
				}
			}
		}
		return null;
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
