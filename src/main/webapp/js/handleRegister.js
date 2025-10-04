document.getElementById("register-form").addEventListener("submit", async function(e) {
    e.preventDefault();

    const clave = document.getElementById("clave").value;
    const confirmar = document.getElementById("confirmar-clave").value;

    if (clave !== confirmar) {
        Toastify({
            text: "Las contraseñas no coinciden",
            duration: 3000,
            gravity: "top",
            position: "right",
            backgroundColor: "red",
        }).showToast();
        return;
    }

    const data = {
        nombre: document.getElementById("nombre").value,
        "primer-apellido": document.getElementById("primer-apellido").value,
        "segundo-apellido": document.getElementById("segundo-apellido").value,
        correo: document.getElementById("correo").value,
        clave: document.getElementById("clave").value
    };

    try {
        const response = await fetch(this.action, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        const result = await response.json();

        Toastify({
            text: result.success ? "✓ Registro exitoso, ya puedes iniciar sesión" : "Hubo un error, no te has podido registrar",
            duration: 3000,
            gravity: "top",
            position: "right",
            backgroundColor: result.success ? "green" : "red",
            style: {
                fontWeight: "bold"
            }
        }).showToast();


    } catch (error) {
        Toastify({
        text: "Error inesperado en el servidor.",
        duration: 3000,
        gravity: "top",
        position: "right",
        backgroundColor: "red",
        style: {
            fontWeight: "bold"
        }
        }).showToast();
    }
});