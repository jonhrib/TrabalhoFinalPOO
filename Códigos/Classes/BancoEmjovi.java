package Classes;

import java.sql.SQLException;

public interface BancoEmjovi {

	public abstract boolean acessar (int cod, String s, String s1, String s2) throws SQLException;
	
	public abstract String[] encontradados (String conta) throws SQLException;
}
