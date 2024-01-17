import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s = new Scanner (System.in);
		
//		Cliente c = new Cliente ();
//		
//		c.setAgencia("0083");
//		c.setIdade(15);
//		c.setNome("Jorginho");
//		
//		System.out.println(c.getNome());
//		System.out.println(c.getAgencia());
//		System.out.println(c.getIdade());
		
		Gerente g = new Gerente ();
		
		g.criarconta("Robert","PR","0001","003",18,"000.115.879-98","123456AB","Estudantil",2500,256.89,5000,"(43)xxxx-xxxx");
	}
}
