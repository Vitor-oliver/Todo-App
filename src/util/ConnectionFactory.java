package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	//Coneccao com banco de dados
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/todoApp";
	public static final String USER = "root";
	public static final String PASS = "";

	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception ex) {
			throw new RuntimeException("Erro na conexão com o banco de dados");
		}
		
	}
	
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		}catch(Exception ex) {
			throw new RuntimeException("Erro ao fecha a conexão com o banco de dados", ex);
		}
	}
	
	
}