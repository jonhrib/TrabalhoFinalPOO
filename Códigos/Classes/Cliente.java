//INSERT into contas (cod,valor,descricao,vencido,juros) values ('0005712', 2.59, 'Estacionamento do Seu Jorge', false,0.00)
package Classes;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

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
	ArrayList<String> cod = new ArrayList<String>();

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
	
	@Override
	public String[] encontradados (String conta) throws SQLException {
		Statement stmt = con.createStatement();
		String nome, uf, idade, cpf, tipo, telefone,renda,senha,saldo,divida,transacoes;
		
		ResultSet dados = stmt.executeQuery("select numconta,nome,uf,idade,cpf,tipodeconta,telefone,renda,senha,saldo,divida,transacoes from cliente");
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
					renda = dados.getString(8);
					senha = dados.getString(9);
					saldo = dados.getString(10);
					divida = dados.getString(11);
					transacoes = dados.getString(12).toString();
					String[] s = {nome,uf,idade,cpf,tipo,telefone,renda,senha,saldo,divida,transacoes};
					return s;
				}
			}
		}
		return null;
	}
	
	public String [] dadosfatura (String cod) throws SQLException {
		String valor = null,descricao = null,vencido = null,juros = null;
		Statement stmt = con.createStatement();
		ResultSet dados = stmt.executeQuery("select cod,valor,descricao,vencido,juros from contas");
		
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (cod.equals(teste)) {
					valor = dados.getString(2);
					descricao = dados.getString(3);
					vencido = dados.getString(4);
					juros = dados.getString(5);
				}
			}
		}
		
		String [] s = {valor,descricao,vencido,juros};
		return s;
	}
	
	public void pagarconta (String numconta, String cod) throws SQLException {
		Statement stmt = con.createStatement();
		
		ResultSet dados = stmt.executeQuery("select cod,valor,vencido,juros from contas");
		String valor = null, vencido = null, juros = null;
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (cod.equals(teste)) {
					valor = dados.getString(2);
					vencido = dados.getString(3);
					juros = dados.getString(4);
				}
			}
		}
		Double pagar;
		if (vencido.equals("t")) {
			pagar = Double.parseDouble(valor) + ((Double.parseDouble(juros)/100)*Double.parseDouble(valor));
		}
		else {
			pagar = Double.parseDouble(valor);
		}
		
		saque(numconta, pagar);
		
		String SQLInsert = "update contas set clientes = COALESCE(clientes, ARRAY[]::TEXT[]) || ARRAY['"+numconta+"'] where cod = '" + cod + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
	}
	
	public ArrayList<String> codigos() throws SQLException{
		Statement stmt = con.createStatement();
		
		ResultSet dados = stmt.executeQuery("select cod from contas");
		String codigo = null;
		
		if (dados.isBeforeFirst()) {
			while (dados.next()) {
				codigo = dados.getString(1);
				cod.add(codigo);
			}
		}
		return cod;
	}
	
	public boolean conferecod (String cod, String conta) throws SQLException {
		boolean result = false;
		
		Statement stmt = con.createStatement();
		ResultSet dados = stmt.executeQuery("select cod,clientes from contas");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String codigo = dados.getString(1);
				if (cod.equals(codigo)) {
					result = true;
					java.sql.Array clientesArray = dados.getArray("clientes");
					
					if (clientesArray != null) {
						String[] clientes = (String[]) dados.getArray("clientes").getArray(); //pega os clientes que pagaram a conta
		                if (clientes.length > 0) {
		                	for (String cliente : clientes) {
			                    if (conta.equals(cliente)) { //se a conta atual já pagou a conta
			                        result = false;
			                        break;  // Se encontrou a conta, não é necessário continuar o loop
			                    }
		                	}
		                }
		                else {
		                	result = true;
		                }
					}
				}
			}
		}
		return result;
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
	
	public void editarconta (int cod, String conta, String nome, String renda, String telefone, String senha) throws SQLException {
		if (cod == 1) { //sem senha
			double rendad = Double.parseDouble(renda);
			String SQLInsert = "update cliente set nome = '" + nome + "', renda = " + rendad + ", telefone = '" + telefone + "' where numconta = '" + conta + "'";
			Statement stmts = con.createStatement();
			stmts.executeUpdate(SQLInsert);
		}
		else if (cod ==2) { //com senha
			double rendad = Double.parseDouble(renda);
			String SQLInsert = "update cliente set nome = '" + nome + "', renda = " + rendad + ", telefone = '" + telefone + "', senha = '"+ senha + "' where numconta = '" + conta + "'";
			Statement stmts = con.createStatement();
			stmts.executeUpdate(SQLInsert);
		}
	}
	
	public void pagardivida (String conta,double valor) throws SQLException {
		DecimalFormat df = new DecimalFormat("0.00");
		double dividaantigo = 0, dividaatual,saldoatual,saldoantigo=0;
		
		Statement stmt = con.createStatement();
		
		ResultSet dados = stmt.executeQuery("select numconta,divida,saldo from cliente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (conta.equals(teste)) {
					dividaantigo = dados.getDouble(2);
					saldoantigo = dados.getDouble(3);
				}
			}
		}
		dividaatual = dividaantigo-valor;
		saldoatual = saldoantigo-valor;
		
		String saldodecimalf = df.format(saldoatual);
		
		saldoatual = Double.parseDouble(saldodecimalf.replaceAll(",","."));
		
		String auxiliar = "-"+valor;
		String SQLInsert = "update cliente set divida = " + dividaatual + ",saldo = "+ saldoatual +",transacoes = COALESCE(transacoes, ARRAY[]::TEXT[]) || ARRAY['"+auxiliar+"'] where numconta = '" + conta + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
	}
	
	public void saque (String conta,double valor) throws SQLException {
		DecimalFormat df = new DecimalFormat("0.00");
		Statement stmt = con.createStatement();
		
		ResultSet dados = stmt.executeQuery("select numconta,saldo from cliente");
		double saldoantigo=0;
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (conta.equals(teste)) {
					saldoantigo = dados.getDouble(2);
					
				}
			
			}
		}
		double saldo = saldoantigo - valor;
		
		String saldodecimalf = df.format(saldo);
		
		saldo = Double.parseDouble(saldodecimalf.replaceAll(",","."));
		
		String auxiliar = "-"+valor;
		String SQLInsert = "update cliente set saldo = " + saldo + ",transacoes = COALESCE(transacoes, ARRAY[]::TEXT[]) || ARRAY['"+auxiliar+"'] where numconta = '" + conta + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
		
	}
	
	public void atualizaemprestimo (String conta, double valorrequerido) throws SQLException {
		
		String SQLInsert = "update cliente set emprestimo = " + true + ", valorrequerido = " + valorrequerido + " where numconta = '" + conta + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
		
		
	}
	
	public void atualizarparcelas (String conta, int parcelas, double valorfinal) throws SQLException {
		
		String SQLInsert = "update cliente set parcelas = " + parcelas + ", propostafinal = " + valorfinal + " where numconta = '" + conta + "'";
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
		DecimalFormat df = new DecimalFormat("0.00");
		
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
		
		String dividadecimalf = df.format(dividaatual);
		
		dividaatual = Double.parseDouble(dividadecimalf.replaceAll(",","."));
		
		String SQLInsert = "update cliente set divida = " + dividaatual + " where numconta = '" + conta + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
	}
	
	public void deposito (String conta, double valord) throws SQLException {
		DecimalFormat df = new DecimalFormat("0.00");
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
		
		String saldodecimalf = df.format(saldoatual);
		
		saldoatual = Double.parseDouble(saldodecimalf.replaceAll(",","."));
		
		String aux="+"+valord;
		String SQLInsert = "update cliente set saldo = " + saldoatual + ",transacoes = COALESCE(transacoes, ARRAY[]::TEXT[]) || ARRAY['"+aux+"'] where numconta = '" + conta + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
	}
	
	public boolean verificaconta (String conta, String agencia) throws SQLException{
		Statement stmt = con.createStatement();
		int cont = 0;
		
		ResultSet dados = stmt.executeQuery("select agencia, numconta from cliente");
		if (dados.isBeforeFirst()) {
			
			while (dados.next()) {
				String teste = dados.getString(1);
				if (agencia.equals(teste)) {
					if (conta.equals(dados.getString(2))) {
						cont++;
					}
				}
			}
			if (cont > 0) return true;
			else return false;
		}
		return false;
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
