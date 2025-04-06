package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import modelo.Equipamento;

public class EquipamentoDAO {

	// a conexão com o banco de dados

	private Connection connection;

	public EquipamentoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public boolean adiciona(Equipamento equipamento) {
		boolean flag = false;

		String sql = "insert into equipamentos"
				+ "(nomeequipamento,datacompra,precocompra,validade,quantidade,lote,marca,tecnicoresponsavel) "
				+ "values (?,?,?,?,?,?,?,?)";
		try {
			// prepared statement para inserção

			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, equipamento.getNomeEquipamento());
			stmt.setDate(2, new Date(equipamento.getDataCompra().getTimeInMillis()));
			stmt.setDouble(3, equipamento.getPrecoCompra());
			stmt.setString(4, equipamento.getValidade());
			stmt.setInt(5, equipamento.getQuantidade());
			stmt.setString(6, equipamento.getLote());
			stmt.setString(7, equipamento.getMarca());
			stmt.setString(8, equipamento.getTecnicoResponsavel());

			// executa

			stmt.execute();
			stmt.close();

			flag = true;

		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return flag;
	}

	public List<Equipamento> getLista() {

		String sql = "select * from	equipamentos";

		try {
			List<Equipamento> equipamentos = new ArrayList<Equipamento>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				// criando o objeto Contato

				Equipamento equipamento = new Equipamento();

				equipamento.setId(rs.getLong("id"));
				equipamento.setNomeEquipamento(rs.getString("nomeequipamento"));
				equipamento.setPrecoCompra(rs.getDouble("precocompra"));
				equipamento.setValidade(rs.getString("validade"));
				equipamento.setLote(rs.getString("lote"));
				equipamento.setQuantidade(rs.getInt("quantidade"));
				equipamento.setMarca(rs.getString("marca"));
				equipamento.setTecnicoResponsavel(rs.getString("tecnicoresponsavel"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datacompra"));
				equipamento.setDataCompra(data);

				// adicionando o objeto à lista
				equipamentos.add(equipamento);
			}
			rs.close();
			stmt.close();

			return equipamentos;

		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public boolean altera(Equipamento equipamento) {
		boolean flag = false;

		String sql = "update equipamentos set nomeequipamento=?, dataCompra=?, "
				+ "precocompra=?, validade=?, quantidade=?, lote=?, marca=?, tecnicoresponsavel=?  where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, equipamento.getNomeEquipamento());
			stmt.setDate(2, new Date(equipamento.getDataCompra().getTimeInMillis()));
			stmt.setDouble(3, equipamento.getPrecoCompra());
			stmt.setString(4, equipamento.getValidade());
			stmt.setInt(5, equipamento.getQuantidade());
			stmt.setString(6, equipamento.getLote());
			stmt.setString(7, equipamento.getMarca());
			stmt.setString(8, equipamento.getTecnicoResponsavel());
			stmt.setLong(9, equipamento.getId());
			stmt.execute();
			stmt.close();

			flag = true;

		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return flag;
	}

	public boolean remove(Equipamento equipamento) {
		boolean flag = false;

		String sql = "delete from equipamentos where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, equipamento.getId());
			stmt.execute();
			stmt.close();

			flag = true;

		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return flag;
	}

	public Equipamento pesquisa(int id) {

		String sql = "select * from	equipamentos where id = ?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, (long) id);
			ResultSet rs = stmt.executeQuery();

			// criando o objeto Contato
			Equipamento equipamento = new Equipamento();

			while (rs.next()) {

				equipamento.setId(rs.getLong("id"));
				equipamento.setNomeEquipamento(rs.getString("nomeequipamento"));
				equipamento.setPrecoCompra(rs.getDouble("precocompra"));
				equipamento.setValidade(rs.getString("validade"));
				equipamento.setLote(rs.getString("lote"));
				equipamento.setQuantidade(rs.getInt("quantidade"));
				equipamento.setMarca(rs.getString("marca"));
				equipamento.setTecnicoResponsavel(rs.getString("tecnicoresponsavel"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datacompra"));
				equipamento.setDataCompra(data);
			}
			rs.close();
			stmt.close();

			return equipamento;

		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

}
