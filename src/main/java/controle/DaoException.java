package controle;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class DaoException extends RuntimeException{

	public DaoException(SQLException e) {
		System.out.println(e);
	}

}
