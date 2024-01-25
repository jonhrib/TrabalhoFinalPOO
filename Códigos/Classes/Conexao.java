package Classes;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	private String databaseURL;
	private String User;
	private String password;
	protected Connection con;
	
	Conexao () throws ClassNotFoundException, SQLException {
		databaseURL = "jdbc:postgresql://localhost:5432/BancoEMJOVI";
		User = "postgres";
		password = "130604";
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(databaseURL,User,password);
		//System.out.println("Conexão realizada com sucesso!!");
	}
	
}
