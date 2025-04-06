package controle;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import modelo.Aeroportos;

	public class AeroportoDao {
	    private Connection connection;

	    public AeroportoDao() {
	        this.connection = new ConnectionFactory().getConnection();
	    }

	    public void adiciona(Aeroportos aeroporto) {
	        String sql = "INSERT INTO Aeroportos (nome, quantidade_terminais, "
	        		+ "tamanho_area_total, capacidade_avioes, torres_controle, "
	        		+ "pistas_voo, localizacao) VALUES (?,?,?,?,?,?,?)";

	        try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, aeroporto.getNome());
	            stmt.setInt(2, aeroporto.getQuantidadeTerminais());
	            stmt.setDouble(3, aeroporto.getTamanhoAreaTotal());
	            stmt.setInt(4, aeroporto.getCapacidadeAvioes());
	            stmt.setInt(5, aeroporto.getTorresControle());
	            stmt.setInt(6, aeroporto.getPistasVoo());
	            stmt.setString(7, aeroporto.getLocalizacao());

	            stmt.execute();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    public void altera(Aeroportos aeroporto) {
	        String sql = "UPDATE Aeroportos SET nome=?, "
	        		+ "quantidade_terminais=?, "
	        		+ "tamanho_area_total=?, "
	        		+ "capacidade_avioes=?, "
	        		+ "torres_controle=?, "
	        		+ "pistas_voo=?, "
	        		+ "localizacao=? WHERE id=?";
	        try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, aeroporto.getNome());
	            stmt.setInt(2, aeroporto.getQuantidadeTerminais());
	            stmt.setDouble(3, aeroporto.getTamanhoAreaTotal());
	            stmt.setInt(4, aeroporto.getCapacidadeAvioes());
	            stmt.setInt(5, aeroporto.getTorresControle());
	            stmt.setInt(6, aeroporto.getPistasVoo());
	            stmt.setString(7, aeroporto.getLocalizacao());
	            stmt.setInt(8, aeroporto.getId());
	            stmt.execute();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    
	    public void remove(Aeroportos aeroporto) {
	        String sql = "DELETE FROM Aeroportos WHERE id=?";
	        try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setInt(1, aeroporto.getId());
	            stmt.execute();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
		/*
		 * public void remove(Aeroportos aeroporto) {
		 * 
		 * 
		 * 
		 * String sql = "DELETE FROM Aeroportos WHERE id=?";
		 * 
		 * try { PreparedStatement stmt = connection.prepareStatement(sql);
		 * stmt.setInt(1, aeroporto.getId()); stmt.execute(); stmt.close();
		 * 
		 * 
		 * } catch (SQLException e) { throw new RuntimeException(e); }
		 * 
		 * }
		 */
		 

	    public List<Aeroportos> getLista() {
	    	
	        String sql = "SELECT * FROM Aeroportos";
	        List<Aeroportos> aeroportos = new ArrayList<>();

	        try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                Aeroportos aeroporto = new Aeroportos();
	                aeroporto.setId(rs.getInt("id"));
	                aeroporto.setNome(rs.getString("nome"));
	                aeroporto.setQuantidadeTerminais(rs.getInt("quantidade_terminais"));
	                aeroporto.setTamanhoAreaTotal(rs.getDouble("tamanho_area_total"));
	                aeroporto.setCapacidadeAvioes(rs.getInt("capacidade_avioes"));
	                aeroporto.setTorresControle(rs.getInt("torres_controle"));
	                aeroporto.setPistasVoo(rs.getInt("pistas_voo"));
	                aeroporto.setLocalizacao(rs.getString("localizacao"));

	                aeroportos.add(aeroporto);
	            }

	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }

	        return aeroportos;
	    }
	    
	    public Aeroportos pesquisa(int id) {
	        String sql = "select * from Aeroportos where id = ?";
	        try {
	            PreparedStatement stmt = this.connection.prepareStatement(sql);
	            stmt.setLong(1, id);
	            ResultSet rs = stmt.executeQuery();

	            // criando o objeto Aeroporto
	            Aeroportos aeroporto = new Aeroportos();
	            while (rs.next()) {
	                aeroporto.setId(rs.getInt("id"));
	                aeroporto.setNome(rs.getString("nome"));
	                aeroporto.setQuantidadeTerminais(rs.getInt("quantidade_terminais"));
	                aeroporto.setTamanhoAreaTotal(rs.getDouble("tamanho_area_total"));
	                aeroporto.setCapacidadeAvioes(rs.getInt("capacidade_avioes"));
	                aeroporto.setTorresControle(rs.getInt("torres_controle"));
	                aeroporto.setPistasVoo(rs.getInt("pistas_voo"));
	                aeroporto.setLocalizacao(rs.getString("localizacao"));
	            }

	            rs.close();
	            stmt.close();
	            return aeroporto;
	        } catch (SQLException e) {
	            throw new DaoException(e);
	        }
	    }

	}

