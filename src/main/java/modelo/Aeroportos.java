package modelo;

public class Aeroportos {

	    private int id;
	    private String nome;
	    private int quantidadeTerminais;
	    private double tamanhoAreaTotal;
	    private int capacidadeAvioes;
	    private int torresControle;
	    private int pistasVoo;
	    private String localizacao;
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getQuantidadeTerminais() {
			return quantidadeTerminais;
		}
		public void setQuantidadeTerminais(int quantidadeTerminais) {
			this.quantidadeTerminais = quantidadeTerminais;
		}
		public double getTamanhoAreaTotal() {
			return tamanhoAreaTotal;
		}
		public void setTamanhoAreaTotal(double tamanhoAreaTotal) {
			this.tamanhoAreaTotal = tamanhoAreaTotal;
		}
		public int getCapacidadeAvioes() {
			return capacidadeAvioes;
		}
		public void setCapacidadeAvioes(int capacidadeAvioes) {
			this.capacidadeAvioes = capacidadeAvioes;
		}
		public int getTorresControle() {
			return torresControle;
		}
		public void setTorresControle(int torresControle) {
			this.torresControle = torresControle;
		}
		public int getPistasVoo() {
			return pistasVoo;
		}
		public void setPistasVoo(int pistasVoo) {
			this.pistasVoo = pistasVoo;
		}
		public String getLocalizacao() {
			return localizacao;
		}
		public void setLocalizacao(String localizacao) {
			this.localizacao = localizacao;
		}	

}
