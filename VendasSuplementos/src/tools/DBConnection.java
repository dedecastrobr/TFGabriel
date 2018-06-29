package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {
	private Connection conn = null;

	private String USER = "root";
	private String PASSWD = "root";

	public DBConnection() {

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost/TrabalhoLPBD?user=" + USER + "&password=" + PASSWD);

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public Connection getConn() {
		return conn;
	}

	public void executeSQL(String sql) {

		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();
			if (stmt.execute(sql)) {
				rs = stmt.getResultSet();
				while (rs.next()) {
					System.out.println(rs.getString(2));
				}
			} else {
				int count = stmt.getUpdateCount();
				if (count == 1) {
					System.out.println("Registro Inserido com sucesso!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean checkValue(String Value) {
		try {
			int x = Integer.parseInt(Value);
			return true;
			
		}catch(Exception e) {
			return false;
		}
	}
}
