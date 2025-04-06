package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import modelo.Manutencao;

public class ManutencaoDao {

	// a conexão com o banco de dados
	private Connection connection;

	public ManutencaoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public boolean adiciona(Manutencao manutencao) {
		boolean flag = false;
		
		String sql = "insert into manutencoes " + 
		             "(id,data,horimetro,idequipamento,idtecnico,motivo) " + 
				     "values (?,?,?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			
			stmt.setInt(1, manutencao.getId());
			stmt.setDate(2, new Date(manutencao.getData().getTimeInMillis()));
			stmt.setInt(3, manutencao.getHorimetro());
			stmt.setInt(4, manutencao.getIdEquipamento());
			stmt.setInt(5, manutencao.getIdTecnico());
			stmt.setString(6, manutencao.getMotivo());

			// executa
			stmt.execute();
			stmt.close();
			
			flag = true;

		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
		return flag;
	}

	public List<Manutencao> getLista() {
		
		String sql = "select * from	manutencoes";
		
		try {
			List<Manutencao> manutencoes = new ArrayList<Manutencao>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				// criando o objeto Manutencao
				Manutencao manutencao = new Manutencao();
				manutencao.setId(rs.getInt("id"));
				manutencao.setHorimetro(rs.getInt("horimetro"));
				manutencao.setIdEquipamento(rs.getInt("idequipamento"));
				manutencao.setIdTecnico(rs.getInt("idtecnico"));
				manutencao.setMotivo(rs.getString("motivo"));
				
				
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				manutencao.setData(data);
				
				// adicionando o objeto à lista
				manutencoes.add(manutencao);
			}
			rs.close();
			stmt.close();
			
			return manutencoes;
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public boolean altera(Manutencao manutencao) {
		boolean flag = false;
		
		String sql = "update manutencoes set data=?, horimetro=?, " + 
	                 "idequipamento=?, idtecnico=?, motivo=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			stmt.setDate(1, new Date(manutencao.getData().getTimeInMillis()));
			stmt.setInt(2, manutencao.getHorimetro());
			stmt.setInt(3, manutencao.getIdEquipamento());
			stmt.setInt(4, manutencao.getIdTecnico());
			stmt.setString(5, manutencao.getMotivo());
			stmt.setInt(6, manutencao.getId());
			stmt.execute();
			stmt.close();
			
			flag = true;
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
		return flag;
	}

	public boolean remove(Manutencao manutencao) {
		boolean flag = false;
		
		String sql = "delete from manutencoes where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, manutencao.getId());
			stmt.execute();
			stmt.close();
			
			flag = true;
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
		return flag;
	}
	
	public List<Manutencao> getListaNome() {
		
		String sql = "select * from	manutencoes where nome like 'C%'";
		
		try {
			List<Manutencao> manutencoes = new ArrayList<Manutencao>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				// criando o objeto Contato
				Manutencao manutencao = new Manutencao();
				manutencao.setId(rs.getInt("id"));
				manutencao.setHorimetro(rs.getInt("horimetro"));
				manutencao.setIdEquipamento(rs.getInt("idequipamento"));
				manutencao.setIdTecnico(rs.getInt("idtecnico"));
				
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				manutencao.setData(data);
				
				// adicionando o objeto à lista
				manutencoes.add(manutencao);
			}
			rs.close();
			stmt.close();
			
			return manutencoes;
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	 public Manutencao pesquisa(int id) {
	        String sql = "select * from manutencoes where id = ?";
	        try {
	            PreparedStatement stmt = this.connection.prepareStatement(sql);
	            stmt.setLong(1, id);
	            ResultSet rs = stmt.executeQuery();

	            // criando o objeto Aeroporto
	            Manutencao manutencao = new Manutencao();
	            while (rs.next()) {
	            	manutencao.setId(rs.getInt("id"));
	            	manutencao.setHorimetro(rs.getInt("horimetro"));
	            	manutencao.setIdTecnico(rs.getInt("idtecnico"));
	            	manutencao.setIdEquipamento(rs.getInt("idequipamento"));
	            	manutencao.setMotivo(rs.getString("motivo"));

	            	// montando a data através do Calendar
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("data"));
					manutencao.setData(data);
	            	
	            }

	            rs.close();
	            stmt.close();
	            return manutencao;
	        } catch (SQLException e) {
	            throw new DaoException(e);
	        }
	    }

	}

