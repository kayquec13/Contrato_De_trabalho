package entities;

public class Departamento {
	
	// Atributo
	private String name;
	
	//Construtores
	public Departamento() {
		
	}
	
	public Departamento(String departamento) {
		this.name = departamento;
	}
	
	
	//Métodos get e set
	public String getNome() {
		return name;
	}
	
	public void setNome(String nome) {
		this.name = name;
	}
	
	
	
}
