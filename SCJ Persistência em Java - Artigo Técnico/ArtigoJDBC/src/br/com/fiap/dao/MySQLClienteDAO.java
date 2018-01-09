package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Telefone;

public class MySQLClienteDAO implements ClienteDAO {
	Connection cn;
	PreparedStatement stmt;
	ResultSet rs;

	@Override
	public void inserirCliente(Cliente cliente) throws Exception{

		try {
			cn = DaoFactory.abrirConexao();
			cn.setAutoCommit(false);
			stmt = cn.prepareStatement("INSERT INTO CLIENTES (NOME) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cliente.getNome()); 
			stmt.execute();
			cn.commit();
			
			rs = stmt.getGeneratedKeys();
			while (rs.next()){
				cliente.setId(rs.getInt(1));
			}
		} catch (Exception e) { 
			throw e;
		} finally { 
			cn.close();
			if (stmt != null) stmt.close();
		} 
	}
	

	@Override
	public Cliente buscarCliente(int id) throws Exception{ 

		Cliente cliente = null;
		List<Telefone> telefones = new ArrayList<>();

		try {
			cn=DaoFactory.abrirConexao();
			String sql="SELECT IDTELEFONE,NUMTELEFONE FROM TELEFONES WHERE IDCLIENTE=?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()){
				telefones.add(new Telefone(rs.getString("NUMTELEFONE"), rs.getInt("IDTELEFONE"), id));
			}

			sql="SELECT NOME FROM CLIENTES WHERE IDCLIENTE=?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()){
				cliente = new Cliente(rs.getString("NOME"), telefones);
			}

		} catch (Exception e) {
			throw e;
		}
		finally{
			cn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}

		return cliente;

	} 

}