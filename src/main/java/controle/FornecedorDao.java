package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import modelo.Fornecedor;

public class FornecedorDao {
	
	private Connection connection;
	
	
	public FornecedorDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public long calculaChave() {
		long chave = 0;
		
		String sql = "select ifnull(max(id),0) as id from fornecedores";
		
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
	
	public boolean adiciona(Fornecedor fornecedor) {
		boolean flag = false;
		
		String sql = "insert into fornecedores " + 
		             "(nome,cnpj,telefone,email,endereco) " + 
				     "values (?,?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getCnpj());
			stmt.setString(3, fornecedor.getTelefone());
			stmt.setString(4, fornecedor.getEmail());
			stmt.setString(5, fornecedor.getEndereco());
			

			// executa
			stmt.execute();
			stmt.close();
			
			flag = true;

		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
		return flag;
	}

	public List<Fornecedor> getLista() {
			
			String sql = "select * from	fornecedores";
			
			try {
				List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					
					// criando o objeto Fornecedor
					Fornecedor fornecedor = new Fornecedor();
					fornecedor.setId(rs.getLong("id"));
					fornecedor.setNome(rs.getString("nome"));
					fornecedor.setCnpj(rs.getString("cnpj"));
					fornecedor.setTelefone(rs.getString("telefone"));
					fornecedor.setEmail(rs.getString("email"));
					fornecedor.setEndereco(rs.getString("endereco"));
					
					
					
					// adicionando o objeto à lista
					fornecedores.add(fornecedor);
				}
				rs.close();
				stmt.close();
				
				return fornecedores;
				
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
	
	public boolean altera(Fornecedor fornecedor) {
		boolean flag = false;
		
		String sql = "update fornecedores set nome=?, cnpj=?, " + 
	                 "telefone=?, email=?, endereco=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getCnpj());
			stmt.setString(3, fornecedor.getTelefone());
			stmt.setString(4, fornecedor.getEmail());
			stmt.setString(5, fornecedor.getEndereco());
			
			stmt.setLong(6, fornecedor.getId());
			stmt.execute();
			stmt.close();
			
			flag = true;
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
		return flag;
	}
	
	
	public boolean remove(Fornecedor fornecedor) {
		boolean flag = false;
		
		String sql = "delete from fornecedores where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, fornecedor.getId());
			stmt.execute();
			stmt.close();
			
			flag = true;
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
		return flag;
	}

	
	public Fornecedor pesquisa(int id) {
		
		String sql = "select * from	fornecedores where id = ?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, (long) id);
			ResultSet rs = stmt.executeQuery();
			
			// criando o objeto Fornecedor
			Fornecedor fornecedor = new Fornecedor();
			
			while (rs.next()) {
				
				fornecedor.setId(rs.getLong("id"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setCnpj(rs.getString("cnpj"));
				fornecedor.setTelefone(rs.getString("telefone"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setEndereco(rs.getString("endereco"));
				
				// montando a data através do Calendar
				
			}
			rs.close();
			stmt.close();
			
			return fornecedor;
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	
}
