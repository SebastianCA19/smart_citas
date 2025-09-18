package com.project.smart_citas.controller;

import com.project.smart_citas.dao.PacienteDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private PacienteDao pacienteDao = new PacienteDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        String primerApellido = req.getParameter("primer-apellido");
        String segundoApellido = req.getParameter("segundo-apellido");
        String correo = req.getParameter("correo");
        String clave = req.getParameter("clave");

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            Integer idPaciente = pacienteDao.insertar(nombre, primerApellido, segundoApellido, correo, clave);

            if (idPaciente == null) {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().write("{\"success\": false, \"message\": \"Error al registrar el paciente.\"}");
            } else {
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("{\"success\": true, \"message\": \"Registro exitoso.\"}");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("{\"success\": false, \"message\": \"Error interno: " + e.getMessage() + "\"}");
        }
    }
}
