package superior.technology;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorDAO {
	public Connection getConnection(String url, String id, String pssd)
			throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pssd);
		} catch (Exception exception) {
			System.out.println("Exception: " + exception);
			conn = null;
		}
		return conn;
	}
}