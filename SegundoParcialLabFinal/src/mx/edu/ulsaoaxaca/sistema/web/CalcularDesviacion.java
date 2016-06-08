package mx.edu.ulsaoaxaca.sistema.web;

import java.util.ArrayList;

public class CalcularDesviacion {
	
	public Double Desviacion(ArrayList<Double> datos){
		
		Double suma = 0.0;
		
		for(Double d: datos){
			suma+=d;
		}
		
		Double media = suma/datos.size();
		
		Double sumatoria = 0.0;
		
		for(Double d: datos){
			Double x = Math.pow((d-media), 2);
			sumatoria += x;
		}
		
		
		
		System.out.println((1.0/(datos.size()-1.0)));
		
		Double resul = Math.sqrt(((1.0/(datos.size()-1.0))*sumatoria));
		
		return resul;
		
	}

}
