<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Citas</title>
    <link rel="stylesheet" href="css/register.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
</head>
<body>
    <div id="container">
        <div id="left-container">
            <h1>Smart Citas</h1>
            <div id="register-container">
                <h1>Registrarse</h1>
                <p>¿Ya tienes una cuenta?<a style="font-weight: bold;" href="./login.jsp">Iniciar Sesión.</a></p>
                <form id="register-form" action="<%=request.getContextPath()%>/register" method="post">
                <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" required>

                    <label for="primer-apellido">Primer Apellido:</label>
                    <input type="text" id="primer-apellido" name="primer-apellido" required>

                    <label for="segundo-apellido">Segundo Apellido:</label>
                    <input type="text" id="segundo-apellido" name="segundo-apellido" required>

                    <label for="correo">Correo electrónico:</label>
                    <input type="email" id="correo" name="correo" required>

                    <label for="clave">Contraseña:</label>
                    <input type="password" id="clave" name="clave" required>

                    <label for="confirmar-clave">Verificar Contraseña:</label>
                    <input type="password" id="confirmar-clave" name="confirmar-clave" required>

                    <button type="submit">Registrarse</button>
                </form>
            </div>
        </div>
        <div id="right-container">
            <img src="img/login-image.jpg" alt="login-image">
        </div>
    </div>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
<script>
        // Esto lo genera el servidor antes de enviar el HTML
        const contextPath = "<%= request.getContextPath() %>";
</script>
<script src="js/handleRegister.js"></script>
</body>
</html>