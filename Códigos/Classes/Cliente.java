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
	
	void editarconta () {
		
	}
	
	void extrato () {
		
	}
	
	void consultardivida () {
		
	}
	
	double saque () {
		
		return 0;
	}
	
	double deposito () {
		
		return 0;
	}
	
	boolean pediremprestimo () {
		
		return false;
	}
	
	public static String formatarCPF(String cpf) {
	    cpf = cpf.replaceAll("[^0-9]", "");
	        // Aplica a formatação do CPF (###.###.###-##)
	    return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
   }
	
	public static String formatarTelefone(String telefone) {
	    // Remove qualquer caracter que não seja um dígito
	    telefone = telefone.replaceAll("[^0-9]", "");

	    // Aplica a formatação do telefone (xx) xxxx-xxxx
	    return "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 6) + "-" + telefone.substring(6, 10);
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
		this.cpf = formatarCPF(cpf);
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
		this.telefone = formatarTelefone(telefone);
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
