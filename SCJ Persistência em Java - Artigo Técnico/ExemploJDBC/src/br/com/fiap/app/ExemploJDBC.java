package br.com.fiap.app;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExemploJDBC {

	public static void main(String[] args) {
		PreparedStatement stmt;
		ResultSet rs;
		Connection cn;		
		try {
			
			System.out.println("Consultando Telefones ...");
			String url="jdbc:mysql://localhost:3306/agenda";
			cn = DriverManager.getConnection(url,"root","root");
			cn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			try {
				String sql="SELECT IDTELEFONE,NUMTELEFONE FROM TELEFONES WHERE IDCLIENTE=?";
				stmt = cn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				stmt.setInt(1, 1);
				rs = stmt.executeQuery();
				while (rs.next()){
					System.out.println(rs.getString("IDTELEFONE") + "-"+ rs.getString("NUMTELEFONE"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				cn.close();
			}

			System.out.println("Consulta de Telefones Finalizada!");
			
			cn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
