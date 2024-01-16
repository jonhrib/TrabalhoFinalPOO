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
		
		g.criarconta();
	}
}

