package modelo;

import java.util.Calendar;

public class Manutencao {

	   private int id;
	   private Calendar data;
	   private int horimetro;
	   private int IdEquipamento;
	   private int IdTecnico;
	   private String motivo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public int getHorimetro() {
		return horimetro;
	}
	public void setHorimetro(int horimetro) {
		this.horimetro = horimetro;
	}
	public int getIdEquipamento() {
		return IdEquipamento;
	}
	public void setIdEquipamento(int idEquipamento) {
		IdEquipamento = idEquipamento;
	}
	public int getIdTecnico() {
		return IdTecnico;
	}
	public void setIdTecnico(int idTecnico) {
		IdTecnico = idTecnico;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	   
	
	
}
