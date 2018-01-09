package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DaoFactory {

	public static final String url="jdbc:mysql://localhost:3306/agenda";
	
	public static Connection abrirConexao() throws Exception{
		return DriverManager.getConnection(url,"root","root");
	}
	
	public static ClienteDAO GetClienteDAO() {
		return new MySQLClienteDAO();
	}

	public static TelefoneDAO GetTelefoneDAO() {
		return new MySQLTelefoneDAO();
	}
}
