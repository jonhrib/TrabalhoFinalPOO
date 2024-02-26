package Classes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

//INSERT INTO gerente (nome, uf, agencia, senha, id) VALUES ('Alberto Cruz', 'SC', '0148-97','ac4567', '0147')
//INSERT INTO gerente (nome, uf, agencia, senha, id) VALUES ('Sidneizinho', 'PR', '0517-52','37000000', '0537')
//INSERT INTO gerente (nome, uf, agencia, senha, id) VALUES ('Rosamaria Serena', 'PR', '0248-91','14145aa', '1782')
//INSERT INTO gerente (nome, uf, agencia, senha, id) VALUES ('Aracy Grassano', 'SP', '0457-52','1789654', '112')

public class Gerente extends Conta {
	
	public Gerente() throws ClassNotFoundException, SQLException {
		super();
		
	}

	private String ID;
	private ArrayList<String []> pedidosdeemprestimo = new ArrayList<String []>();
	
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
	
	@Override
	public String[] encontradados (String conta) throws SQLException {
		Statement stmt = con.createStatement();
		String nome, uf, agencia, numconta, idade, cpf, senha, tipodeconta, renda, saldo, divida, telefone;
		
		ResultSet dados = stmt.executeQuery("select numconta, nome, uf, agencia, idade, cpf, senha, tipodeconta, renda, saldo, divida, telefone from cliente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (conta.equals(teste)) {
					nome = dados.getString(2);
					uf = dados.getString(3);
					agencia = dados.getString(4);
					idade = dados.getString(5);
					cpf = dados.getString(6);
					senha = dados.getString(7);
					tipodeconta = dados.getString(8);
					renda = dados.getString(9);
					saldo = dados.getString(10);
					divida = dados.getString(11);
					telefone = dados.getString(12);
					String[] s = {nome,uf,agencia, idade, cpf, senha, tipodeconta, renda, saldo, divida, telefone};
					return s;
				}
			}
		}
		return null;
	}
	
	public String[] encontranome (String id) throws SQLException {
		Statement stmt = con.createStatement();
		String nome, uf, senha;
		
		ResultSet dados = stmt.executeQuery("select id,nome,uf,senha from gerente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (id.equals(teste)) {
					nome = dados.getString(2);
					uf = dados.getString(3);
					senha = dados.getString(4);
					String[] s = {nome,uf,senha};
					return s;
				}
			}
		}
		return null;
	}
	
	public void removerconta (String conta) throws SQLException {
		String SQLInsert = "delete from cliente where numconta = '" + conta + "'";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(SQLInsert);
	}
	
	public boolean verificaconta (String conta, String agencia) throws SQLException{
		Statement stmt = con.createStatement();
		int cont = 0;
		
		ResultSet dados = stmt.executeQuery("select numconta, agencia from cliente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (dados.getString(2).equals(agencia)) {
					if (conta.equals(teste)) {
						cont++;
					}
				}
			}
			if (cont > 0) return true;
			else return false;
		}
		return false;
	}
	
	public void criarconta (String nome, String uf, String agencia, String numconta, int idade, String cpf, String senha, String tipodeconta, double renda, double saldo, double divida, String telefone, double valordoemprestimo) throws SQLException {
		
		//System.out.println("insert into cliente (nome,uf,agencia,numconta,idade,cpf,senha,tipodeconta,renda,saldo,divida,telefone) VALUES ('" + nome + "'," + "'" + uf + "'," + "'" + agencia + "','" + numconta + "'," + idade + ",'" + cpf + "','" + senha + "','" + tipodeconta + "'," + renda + "," + saldo + "," + divida +  ",'" + telefone + "')");
		String SQLInsert = "insert into cliente (nome,uf,agencia,numconta,idade,cpf,senha,tipodeconta,renda,saldo,divida,telefone,valordoemprestimo) VALUES ('" + nome + "'," + "'" + uf + "'," + "'" + agencia + "','" + numconta + "'," + idade + ",'" + cpf + "','" + senha + "','" + tipodeconta + "'," + renda + "," + saldo + "," + divida +  ",'" + telefone + "'," + valordoemprestimo +")";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(SQLInsert);
		
	}
	
	public void autorizaemprestimo (String conta, double valorrequerido, double propostafinal) throws SQLException {
		DecimalFormat df = new DecimalFormat("0.00");
		// valorp = 0
		// saldo += valorrequerido
		// divida += propostafinal
		// emprestimo = false
		
		double saldoantigo = 0, dividaantiga = 0;
		
		Statement stmt = con.createStatement();
		
		ResultSet dados = stmt.executeQuery("select numconta,valordoemprestimo,valorrequerido, saldo, divida from cliente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (conta.equals(teste)) {
					saldoantigo = dados.getDouble(4);
					dividaantiga = dados.getDouble(5);
				}
			}
		}
		String auxiliar = "+"+valorrequerido;
		double saldoatual = saldoantigo + valorrequerido;
		double dividatual = dividaantiga + propostafinal;
		
		String dividadecimalf = df.format(dividatual);
		
		dividatual = Double.parseDouble(dividadecimalf.replaceAll(",","."));
		
		String SQLInsert = "update cliente set emprestimo = " + false + ", valordoemprestimo = " + 0 + ", valorrequerido = " + 0 + ", saldo = " + saldoatual + ", divida = " + dividatual + ",transacoes = COALESCE(transacoes, ARRAY[]::TEXT[]) || ARRAY['"+auxiliar+"'] where numconta = '" + conta + "'";
		//String SQLInsert = "update cliente set emprestimo = " + false + ", valordoemprestimo = " + 0 + ", valorrequerido = " + 0 + ", saldo = " + saldoatual + ", divida = " + dividatual + " where numconta = '" + conta + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
	}
	
	public void negaemprestimo (String conta, double valorrequerido, double propostafinal) throws SQLException {
		String SQLInsert = "update cliente set emprestimo = " + false + ", valorrequerido = " + 0 + " where numconta = '" + conta + "'";
		//String SQLInsert = "update cliente set emprestimo = " + false + ", valordoemprestimo = " + 0 + ", valorrequerido = " + 0 + ", saldo = " + saldoatual + ", divida = " + dividatual + " where numconta = '" + conta + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
	}
	
	public ArrayList<String []> avaliaremprestimo (String agencia) throws SQLException {
		Statement stmt = con.createStatement();
		String numconta, tipodeconta, renda, saldo, divida, valordoemprestimo, valorrequerido, parcelas, propostafinal;
		boolean emprestimo;
		
		ResultSet dados = stmt.executeQuery("select agencia, numconta, tipodeconta, renda, saldo, divida, emprestimo, valordoemprestimo, valorrequerido, parcelas, propostafinal from cliente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1); //agencia
				if (agencia.equals(teste)) {
					emprestimo = dados.getBoolean(7);
					if (emprestimo) {
						numconta = dados.getString(2);
						valordoemprestimo = dados.getString(8);
						valorrequerido = dados.getString(9);
						tipodeconta = dados.getString(3);
						renda = dados.getString(4);
						saldo = dados.getString(5);
						divida = dados.getString(6);
						parcelas = dados.getString(10);
						propostafinal = dados.getString(11);
						//System.out.println (numconta + " " + tipodeconta + " "+ renda + " " +saldo + " "  +divida +" " + valordoemprestimo +" " + valorrequerido);
						String[] s = {numconta, tipodeconta, renda, saldo, divida, valordoemprestimo, valorrequerido, parcelas, propostafinal};
						pedidosdeemprestimo.add(s);
					}
				}
			}
		}
		
		return pedidosdeemprestimo;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public static String formatarCPF(String cpf) {
		//remove tudo que não sejam números de 0 a 9
	    cpf = cpf.replaceAll("[^0-9]", ""); //regex ou expressão regular
	    
	    // Aplica a formatação do CPF (###.###.###-##)
	    return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
   }
	
	public static String formatarTelefone(String telefone) {
		//remove tudo que não sejam números de 0 a 9
	    telefone = telefone.replaceAll("[^0-9]", ""); //regex ou expressão regular

	    // Aplica a formatação do telefone (xx) xxxx-xxxx
	    return "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 7) + "-" + telefone.substring(7, 11);
	}

}
