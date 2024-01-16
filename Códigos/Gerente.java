import java.sql.SQLException;
import java.sql.Statement;

public class Gerente extends Conta {
	
	Gerente() throws ClassNotFoundException, SQLException {
		super();
		
	}

	String ID;
	
	@Override
	boolean acessar() {
		
		return false;
	}
	
	void criarconta () throws SQLException {
	
//		String SQLInsert = "insert into cliente (nome,uf,agencia,numconta,idade,cpf,senha,tipodeconta,renda,saldo,divida,telefone) VALUES ('Jorge','PR','0001','003',18,'000.115.879-98','123456AB','Estudantil',2500,256.89,5000,'(43)xxxx-xxxx')";
//		Statement stmt = con.createStatement();
//		stmt.executeUpdate(SQLInsert);
		
		
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
