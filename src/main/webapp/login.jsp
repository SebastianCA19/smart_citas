<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Citas</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&display=swap" rel="stylesheet">
</head>
<body>
    <div id="container">
        <div id="left-container">
            <h1>Smart Citas</h1>
            <div id="login-container">
                <h1>Iniciar Sesión</h1>
                <p>¿No tienes una cuenta?<a style="font-weight: bold;" href="register.jsp">Registrate Aquí.</a></p>
                <form id="login-form" action="#" method="post">
                    <label for="email">Correo electrónico:</label>
                    <input type="email" id="email" name="email" required>

                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" required>

                    <button type="submit">Iniciar sesión</button>
                </form>
                <p style="margin-top: 10px; text-align: center">¿Olvidaste tu contraseña?<a style="font-weight: bold;" href="#">Clic Aquí.</a></p>
            </div>
        </div>
        <div id="right-container">
            <img src="img/login-image.jpg" alt="login-image">
        </div>
    </div>
</body>
</html>