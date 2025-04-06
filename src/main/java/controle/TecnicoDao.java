package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import modelo.Tecnico;

public class TecnicoDao {
	
	private Connection connection;
	
	
	public TecnicoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public long calculaChave() {
		long chave = 0;
		
		String sql = "select ifnull(max(id),0) as id from tecnicos";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);	
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
                chave = rs.getLong("id") + 1;
            } 
            else {
                chave = 1;
            }
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return chave;
	}
	
	public boolean adiciona(Tecnico tecnico) {
		boolean flag = false;
		
		String sql = "insert into tecnicos " + 
		             "(nome,cpf,telefone,setor) " + 
				     "values (?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, tecnico.getNome());
			stmt.setString(2, tecnico.getCpf());
			stmt.setString(3, tecnico.getTelefone());
			stmt.setString(4, tecnico.getSetor());
			

			// executa
			stmt.execute();
			stmt.close();
			
			flag = true;

		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
		return flag;
	}

	public List<Tecnico> getLista() {
			
			String sql = "select * from	tecnicos";
			
			try {
				List<Tecnico> tecnicos = new ArrayList<Tecnico>();
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					
					// criando o objeto Tecnico
					Tecnico tecnico = new Tecnico();
					tecnico.setId(rs.getLong("id"));
					tecnico.setNome(rs.getString("nome"));
					tecnico.setCpf(rs.getString("cpf"));
					tecnico.setTelefone(rs.getString("telefone"));
					tecnico.setSetor(rs.getString("setor"));
					
					
					
					// adicionando o objeto à lista
					tecnicos.add(tecnico);
				}
				rs.close();
				stmt.close();
				
				return tecnicos;
				
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
	
	public boolean altera(Tecnico tecnico) {
		boolean flag = false;
		
		String sql = "update tecnicos set nome=?, cpf=?, " + 
	                 "telefone=?, setor=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, tecnico.getNome());
			stmt.setString(2, tecnico.getCpf());
			stmt.setString(3, tecnico.getTelefone());
			stmt.setString(4, tecnico.getSetor());
			stmt.setLong(5, tecnico.getId());
			stmt.execute();
			stmt.close();
			
			flag = true;
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
		return flag;
	}
	
	
	public boolean remove(Tecnico tecnico) {
		boolean flag = false;
		
		String sql = "delete from tecnicos where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, tecnico.getId());
			stmt.execute();
			stmt.close();
			
			flag = true;
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
		return flag;
	}

	
	public Tecnico pesquisa(int id) {
		
		String sql = "select * from	tecnicos where id = ?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, (long) id);
			ResultSet rs = stmt.executeQuery();
			
			// criando o objeto Contato
			Tecnico tecnico = new Tecnico();
			
			while (rs.next()) {
				
				tecnico.setId(rs.getLong("id"));
				tecnico.setNome(rs.getString("nome"));
				tecnico.setCpf(rs.getString("cpf"));
				tecnico.setTelefone(rs.getString("telefone"));
				tecnico.setSetor(rs.getString("setor"));
				
				// montando a data através do Calendar
				
			}
			rs.close();
			stmt.close();
			
			return tecnico;
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	
}
