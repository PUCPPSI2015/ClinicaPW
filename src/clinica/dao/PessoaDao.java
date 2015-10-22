package clinica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import clinica.connection.*;
import clinica.inter.DAO;
import clinica.modelo.Pessoa;

public class PessoaDao implements DAO<Pessoa>{
	private Connection conn;
	
	public PessoaDao(){
		this.conn = new ConnectionBanc().getConnection();
	}

	@Override
	public void adiciona(Pessoa entidade) throws SQLException {
		String sql = "insert into Pacientes (Nome,CEP,Numero,Complemento)values(?,?,?,?)";
		
		PreparedStatement stmt = null;
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, entidade.getNome());
			stmt.setInt(2, entidade.getCEP());
			stmt.setInt(3, entidade.getNumero());
			stmt.setString(4, entidade.getComplemento());
			
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			stmt.close();
			conn.close();
		}
	}

	@Override
	public void altera(Pessoa entidade) throws SQLException {
		String sql = "update Pacientes set";
		int flag = 0;
		int cont = 1;
		
		if(entidade.getNome() != null && !entidade.getNome().equals("")){
			sql = sql + "Nome=?";
			flag = 1;
		}
		if(entidade.getCEP() <=0){
			if(flag==1)
				sql = sql + ",";
			
			sql = sql + "CEP=?";
			flag=1;
		}
		if(entidade.getNumero() <=0){
			if(flag==1)
				sql = sql + ",";
			
			sql = sql + "Numero=?";
			flag=1;
		}
		if(entidade.getComplemento() != null && !entidade.getComplemento().equals("")){
			if(flag==1)
				sql = sql + ",";
				
			sql = sql + "Complemento=?";
			flag=1;
		}
		sql = sql + "where ID=?";
		
		PreparedStatement stmt = null;
		try{
			stmt = (PreparedStatement)conn.prepareStatement(sql);
			if(entidade.getNome() != null && !entidade.getNome().equals("")){
				stmt.setString(cont, entidade.getNome());
				cont++;
			}
			if(entidade.getCEP() <=0){
				stmt.setInt(cont, entidade.getCEP());
				cont++;
			}
			if(entidade.getNumero() <=0){
				stmt.setInt(cont, entidade.getNumero());
				cont++;
			}
			if(entidade.getComplemento() != null && !entidade.getComplemento().equals("")){
				stmt.setString(cont, entidade.getComplemento());
				cont++;
			}
			stmt.setLong(cont, entidade.getId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			stmt.close();
			conn.close();
		}
		
	}

	@Override
	public void deleta(Pessoa entidade) throws SQLException {
		PreparedStatement stmt = null;
		try{
			stmt = (PreparedStatement)conn.prepareStatement("delete from Pacientes where ID =?");
			
			stmt.setLong(1, entidade.getId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			stmt.close();
			conn.close();
		}
		
	}

	@Override
	public Pessoa lista(String Pesquisa) throws SQLException {
		Pessoa entidade = new Pessoa();
		String sql = "select * from Pacientes where id=?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			stmt = (PreparedStatement)conn.prepareStatement(sql);
			
			stmt.setLong(1, entidade.getId());
			rs = stmt.executeQuery();
			
			if(rs.next()){
				entidade.setId(rs.getLong("id"));
				entidade.setNome(rs.getString("Nome"));
				entidade.setCEP(rs.getInt("CEP"));
				entidade.setCEP(rs.getInt("Numero"));
				entidade.setComplemento(rs.getString("Complemento"));
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			stmt.close();
			rs.close();
			conn.close();
		}
		
		return entidade;
	}

	@SuppressWarnings("null")
	@Override
	public List<Pessoa> listaTudo() throws SQLException {
		List<Pessoa>pessoas = new ArrayList<Pessoa>();
		String sql = "select * from Pacientes";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			Pessoa entidade = null;
			
			while(((ResultSet) stmt).next()){
				entidade = new Pessoa();
				
				entidade.setId(rs.getLong("id"));
				entidade.setNome(rs.getString("Nome"));
				entidade.setCEP(rs.getInt("CEP"));
				entidade.setNumero(rs.getInt("Numero"));
				entidade.setComplemento(rs.getString("Complemento"));
				
				pessoas.add(entidade);
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			stmt.close();
			rs.close();
			conn.close();
		
		}
		
		return pessoas;
	}
	
	
	
}
