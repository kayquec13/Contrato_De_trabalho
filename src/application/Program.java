package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com o nome do departamento do funcionario: ");
		String nomeDepartamento = sc.next();
		System.out.println();
		
		System.out.println("Entre com os dados do funcionario: ");
		System.out.println("Nome: ");
		String nomeFuncionario = sc.next();
		System.out.println("Nivel: ");
		String nivelTrabalhador = sc.next();
		System.out.println("Salario Base: ");
		double salarioBase = sc.nextDouble();		
		//Departamento departamento = new Departamento (nomeDepartamento);
		Trabalhador trabalhador = new Trabalhador(nomeFuncionario, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase, new Departamento(nomeDepartamento) );
		
		System.out.println();
		System.out.println("Quantos contratos o funcionario tem ? ");
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			System.out.println("Entre com os dados do " + i + "Contrato: ");
			System.out.println("Date (DD/MM/YYYY): ");
			Date contratoData = sdf.parse(sc.next());
			
			System.out.println("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			
			System.out.println("Duração do contrato (horas): ");
			Integer horas = sc.nextInt();
			
			HoraContrato contrato = new HoraContrato(contratoData, valorPorHora, horas);
			trabalhador.addContrato(contrato);
		}
		
		System.out.println();
		System.out.println("Entre com o mes e ano para calcular a renda(MM/YYYY) : ");
		String mesAno =sc.next();
		
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome: " +  trabalhador.getName());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("A renda do mes: " + mesAno + ": " + trabalhador.renda(ano, mes));
		
		
		
		sc.close();
	}

}
