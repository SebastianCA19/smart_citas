document.getElementById("register-form").addEventListener("submit", async function(e) {
    e.preventDefault(); // evita que recargue la página

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
        return; // no enviar nada al backend
    }

    const formData = new FormData(this);


    console.log("URL que se está usando:", contextPath + "/register");
    console.log("Action del formulario:", this.action);
    try {
        const response = await fetch(this.action, {
            method: "POST",
            body: formData
        });

        const data = await response.json();

    Toastify({
        text: data.message,
        duration: 3000,
        gravity: "top",
        position: "right",
        backgroundColor: data.success ? "green" : "red",
    }).showToast();

    } catch (error) {
        console.log(error);
        Toastify({
        text: "Error inesperado en el servidor.",
        duration: 3000,
        gravity: "top",
        position: "right",
        backgroundColor: "red",
        }).showToast();
    }
});