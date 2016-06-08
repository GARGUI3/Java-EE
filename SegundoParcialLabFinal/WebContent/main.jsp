<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mx.edu.ulsaoaxaca.sistema.bean.Cuenta" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>

<%	

			if(session.getAttribute("usuario") == null){
				session.invalidate();
				response.sendRedirect("index.html");
			}else{
			    
		    	Cuenta c =(Cuenta) session.getAttribute("cuentas");
	
				if(c!=null){
			
					out.println("ID: " + c.getId() + " Usuario: " + c.getUsuario() + " Contrasena: " + c.getContrasena() + " Activo: " + c.getUsuarioActivo() + "<br>");
					out.println("Nombre: " + c.getPersona().getNombre() + " Fecha nacimiento: " + c.getPersona().getFechaNacimiento() + " Sexo: " + c.getPersona().getSexo() + "<br>");
					out.println("Nombre: " + c.getPerfil().getNombre() + " Descripcion: " + c.getPerfil().getDescripcion() + "<br>");
					out.println("<br>");
				}
				
				String us =(String) session.getAttribute("usuario");
				if(us != null){
					String idd =(String) session.getId();
					out.println("ID: " + idd + " Nombre: " + us);
					out.println("<br>");
				}
				Double des =(Double) session.getAttribute("desviacion");
				if(des != null){
					out.println("Desviacion Estandar: " + des);
					out.println("<br>");
				}
			}

%>

<form action="logout" method="POST">
	<button type="submit">Cerrar Sesion</button>
</form>

</body>
</html>