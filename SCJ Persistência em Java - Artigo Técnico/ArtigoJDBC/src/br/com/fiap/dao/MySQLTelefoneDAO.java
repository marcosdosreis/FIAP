package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Telefone;

public class MySQLTelefoneDAO implements TelefoneDAO {
	Connection cn;
	PreparedStatement stmt;
	ResultSet rs;
	
	@Override
	public void inserirTelefone(Telefone telefone) throws Exception {
		
		try {
			cn=DaoFactory.abrirConexao();
			cn.setAutoCommit(false);

			String sql="INSERT INTO TELEFONES (IDCLIENTE,NUMTELEFONE) VALUES (?,?)";
			stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, telefone.getIdCliente());
			stmt.setString(2, telefone.getTelefone());
			stmt.execute();
			cn.commit();
			
			rs = stmt.getGeneratedKeys();
			if (rs.next()){
				telefone.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			throw e;
		}
		finally{
			cn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
 		}
	}
	
	@Override
	public List<Telefone> listarTelefones(int idCliente) throws Exception {
		List<Telefone> telefones = new ArrayList<>();
		
		try {
			cn=DaoFactory.abrirConexao();
			
			String sql="SELECT IDTELEFONE,NUMTELEFONE FROM TELEFONES WHERE IDCLIENTE=?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			while (rs.next()){
				telefones.add(new Telefone(rs.getString("NUMTELEFONE"), rs.getInt("IDTELEFONE"), idCliente));
			}
		} catch (Exception e) {
			throw e;
		}
		finally{
			cn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}
		
		return telefones;
		
	}
		
		
}
