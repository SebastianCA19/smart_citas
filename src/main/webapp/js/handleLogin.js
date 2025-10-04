document.getElementById("login-form").addEventListener("submit", async function (e) {
    e.preventDefault();

    const correo = document.getElementById("correo").value;
    const claveUsuario = document.getElementById("clave").value;

    if (!correo || !claveUsuario) {
        Toastify({
            text: "Error al iniciar sesión",
            duration: 3000,
            gravity: "top",
            position: "right",
            style: {
                backgroundColor: "red",
                fontWeight: "bold"
            }
        }).showToast();
        return;
    }

    try {
        const response = await fetch(this.action, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                email: correo,
                clave: claveUsuario
            })
        });

        const result = await response.json();

        if (result.success) {
            Toastify({
                text: "✓ ¡Login exitoso!",
                duration: 3000,
                gravity: "top",
                position: "right",
                style: {
                    background: "#2563eb",
                    fontWeight: "bold",
                    text: "white",
                }
            }).showToast();
            setTimeout(() => {
                window.location.href = "./pacientes_home.jsp";
            }, 3000);
        }

    } catch (error) {
        Toastify({
            text: "Error inesperado en el servidor.",
            duration: 3000,
            gravity: "top",
            position: "right",
            style: {
                backgroundColor: "red",
                fontWeight: "bold"
            }
        }).showToast();
    }
});
