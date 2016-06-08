<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<head>
    <title>Login</title>
</head>
<body style="text-align: center;">

<h2>LOGIN</h2>
<form method="POST" action="principal.html">

	<input type="text" placeholder="usuario" name="u"/>
	<br>
	<br>
	<input type="password" placeholder="contraseña" name="c"/> 
	<br>
	<br>
	<input type="submit" value="Ingresar"/>

</form>
</body>
</html>