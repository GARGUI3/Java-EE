package mx.edu.ulsaoaxaca.sistema.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.edu.ulsaoaxaca.sistema.bean.Cuenta;
import mx.edu.ulsaoaxaca.sistema.bean.Perfil;
import mx.edu.ulsaoaxaca.sistema.bean.Persona;

public class DAODesviacion {
	
	public ArrayList<Double> obtenerDatos() throws SQLException{

		DataSource d = new DataSource("desviacion");
		
		ArrayList<Double> datos = new ArrayList<Double>();
		ResultSet r= (ResultSet)d.ejecutarConsulta("select * from datos");
		
		if(r==null){
			System.out.println("No hay datos");
		}else{
			while(r.next()){
				
				Double x = r.getDouble(1);
				datos.add(x);
				
			}
		}
			
		return datos;
	}

}
