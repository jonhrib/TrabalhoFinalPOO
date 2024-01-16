
public class Cliente extends Conta {
	String numconta;
	int idade;
	String cpf;
	String tipodeconta;
	double renda;
	String telefone;
	double saldo;
	double divida;

	@Override
	void acessar() {
		
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
