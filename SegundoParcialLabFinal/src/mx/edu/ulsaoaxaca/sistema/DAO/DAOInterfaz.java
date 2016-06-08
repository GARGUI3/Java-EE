package mx.edu.ulsaoaxaca.sistema.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import mx.edu.ulsaoaxaca.sistema.bean.Cuenta;

public interface DAOInterfaz {
	
	public ArrayList<Cuenta> usuarios() throws SQLException;
	public Integer loguear(String user, String contra) throws SQLException;
	public Cuenta usuario(String user) throws SQLException;

}
