package entities;

import java.sql.Date;

public class HoraContrato {
	
	//Atributos
	private Date data;
	private Double valorPorHora;
	private Integer hora;
	
	//Construtores
	public HoraContrato() {
		super();
	}

	public HoraContrato(Date data, Double valorPorHora, Integer hora) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.hora = hora;
	}

	//Métodos get e set
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}
	
	
	//Método calcula valor por hora
	public double valorTotal() {
		return this.valorPorHora * this.hora;
	}
	
	
}
