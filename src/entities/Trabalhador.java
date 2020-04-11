package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	
	//Atributos
	private String name;
	private NivelTrabalhador nivel;
	private Double salarioBase;
	
	//Atributos Composição, Contem um departamento e varios contratos(Alocados em uma lista).
	private Departamento departamento;
	private List<HoraContrato> contrato = new ArrayList<>();
		
	//Construtores
	public Trabalhador() {		
	}

	public Trabalhador(String name, NivelTrabalhador nivel, Double salariobase, Departamento departamento) {
		this.name = name;
		this.nivel = nivel;
		this.salarioBase = salariobase;
		this.departamento = departamento;
	}

	// Métodos get e set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContrato() {
		return contrato;
	}

	
	//Método adiciona contrato
	public void addContrato (HoraContrato contrato) {
		this.contrato.add(contrato);
	}
	
	//Método remove contrato
	public void removeContrato(HoraContrato contrato) {
		this.contrato.remove(contrato);
	}
	
	//Métodp que calcula a renda do trabalhador somando o salario fixo com os contratos do mês
	//Utilizamos Calendar para pegar a data da classe HoraContrato e comparar dentro do if
	//a data informada pelo usuario.
	public double renda(int ano, int mes) {
		double soma = this.salarioBase;
		
		Calendar cal = Calendar.getInstance();
		for (HoraContrato c : contrato) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if(ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
}
