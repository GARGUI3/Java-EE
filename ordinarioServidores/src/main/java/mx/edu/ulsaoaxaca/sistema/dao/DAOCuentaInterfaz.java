package mx.edu.ulsaoaxaca.sistema.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import mx.edu.ulsaoaxaca.sistema.bean.Cuenta;



public interface DAOCuentaInterfaz {
	
	public boolean logueo(String u, String c) throws SQLException;
	public ArrayList<Cuenta> datosCuentas() throws SQLException;
}
