<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
    <title>Principal</title>
</head>
<body style="text-align: center;">

<h2>Usuarios Registrados</h2>

 <table border="1" style="width:100%">
    <tr>
    	<td>Usuario</td>
        <td>Nombre</td>
        <td>Sexo</td>
        <td>Fecha Nacimiento</td>
    </tr>
    <c:forEach items="${cuentas}" var="c">
	    <tr>
	    	<td><c:out value="${c.usuario}"/></td>
	    	<td><c:out value="${c.persona.nombre}"/></td>
	    	<td><c:out value="${c.persona.sexo}"/></td>
	    	<td><c:out value="${c.persona.fechaNacimiento}"/></td>
	    </tr>
	</c:forEach>
</table>

<br>
<form method="GET" action="login.html">
	<button type="submit">Cerrar Sesion</button>
</form>
  
</body>
</html>