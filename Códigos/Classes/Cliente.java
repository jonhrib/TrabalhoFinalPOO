package Classes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente extends Conta {
	
	public Cliente() throws ClassNotFoundException, SQLException {
		super();
		
	}

	String numconta;
	int idade;
	String cpf;
	String tipodeconta;
	double renda;
	String telefone;
	double saldo;
	double divida;

	@Override
	public boolean acessar(int cod, String s, String s1, String s2) throws SQLException {
		Statement stmt = con.createStatement();
		boolean result = false;
		
		if (cod == 1) { //Agencia
			//"select nome,uf,agencia,numconta,idade,cpf,senha,tipodeconta,renda,saldo,divida,telefone from cliente"
			ResultSet dados = stmt.executeQuery("select agencia from cliente");
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
		else if (cod == 2) { //Conta
			ResultSet dados = stmt.executeQuery("select agencia,numconta from cliente");
			if (dados.isBeforeFirst()) {
				
				while (dados.next()) {
					String agencia = dados.getString(1);
					String conta = dados.getString(2);
					if (s.equals(agencia) && s1.equals(conta)) {
						result = true;
					}
				}
			}
			
			return result;
		}
		else if (cod == 3) { //Senha
			ResultSet dados = stmt.executeQuery("select agencia,numconta,senha from cliente");
			if (dados.isBeforeFirst()) {
				
				while (dados.next()) {
					String agencia = dados.getString(1);
					String conta = dados.getString(2);
					String senha = dados.getString(3);
					
					if (s.equals(agencia) && s1.equals(conta) && s2.equals(senha)) {
						result = true;
					}
				}
			}
			
			return result;
		}
		else return false;

	}
	
	public String[] encontradados (String conta) throws SQLException {
		Statement stmt = con.createStatement();
		String nome, uf, idade, cpf, tipo, telefone;
		
		ResultSet dados = stmt.executeQuery("select numconta,nome,uf,idade,cpf,tipodeconta,telefone from cliente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (conta.equals(teste)) {
					nome = dados.getString(2);
					uf = dados.getString(3);
					idade = dados.getString(4);
					cpf = dados.getString(5);
					tipo = dados.getString(6);
					telefone = dados.getString(7);
					String[] s = {nome,uf,idade,cpf,tipo,telefone};
					return s;
				}
			}
		}
		return null;
	}
	
	public double encontravalordoemprestimo (String conta) throws SQLException {
		Statement stmt = con.createStatement();
		
		ResultSet dados = stmt.executeQuery("select numconta,valordoemprestimo from cliente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (conta.equals(teste)) {
					double valor = dados.getDouble(2);
					return valor;
				}
			}
		}
		return 0;
	}
	
	void editarconta () {
		
	}
	
	void extrato () {
		
	}
	
	void consultardivida () {
		
	}
	
	double saque () {
		
		return 0;
	}
	
	public void atualizaemprestimo (String conta, double valorrequerido) throws SQLException {
		
		String SQLInsert = "update cliente set emprestimo = " + true + ", valorrequerido = " + valorrequerido + " where numconta = '" + conta + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
		
		
	}
	
	public void retirarvalordeemprestimo (String conta, double valor) throws SQLException {
		double empantigo = 0, empatual;
		
		Statement stmt = con.createStatement();
		
		ResultSet dados = stmt.executeQuery("select numconta,valordoemprestimo from cliente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (conta.equals(teste)) {
					empantigo = dados.getDouble(2);
				}
			}
		}
		empatual = empantigo - valor;
		
		String SQLInsert = "update cliente set valordoemprestimo = " + empatual + " where numconta = '" + conta + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
	}
	
	public void aumentardivida (String conta, double valor) throws SQLException {
		double dividaantiga = 0, dividaatual;
		
		Statement stmt = con.createStatement();
		
		ResultSet dados = stmt.executeQuery("select numconta,divida from cliente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (conta.equals(teste)) {
					dividaantiga = dados.getDouble(2);
				}
			}
		}
		dividaatual = valor+ dividaantiga;
		
		String SQLInsert = "update cliente set divida = " + dividaatual + " where numconta = '" + conta + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
	}
	
	public void deposito (String conta, double valord) throws SQLException {
		double saldoantigo = 0, saldoatual;
		
		Statement stmt = con.createStatement();
		
		ResultSet dados = stmt.executeQuery("select numconta,saldo from cliente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (conta.equals(teste)) {
					saldoantigo = dados.getDouble(2);
				}
			}
		}
		saldoatual = valord+ saldoantigo;
		
		String SQLInsert = "update cliente set saldo = " + saldoatual + " where numconta = '" + conta + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
	}
	
	boolean pediremprestimo () {
		
		return false;
	}

	public String getNumconta() {
		return numconta;
	}

	public void setNumconta(String numconta) {
		this.numconta = numconta;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipodeconta() {
		return tipodeconta;
	}

	public void setTipodeconta(String tipodeconta) {
		this.tipodeconta = tipodeconta;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getDivida() {
		return divida;
	}

	public void setDivida(double divida) {
		this.divida = divida;
	}

}
