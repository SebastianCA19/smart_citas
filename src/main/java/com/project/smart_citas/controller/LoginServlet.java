package com.project.smart_citas.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.project.smart_citas.dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDao usuarioDao = new UsuarioDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = reader.readLine()) != null){
            sb.append(line);
        }
        String requestBody = sb.toString();
        JsonObject json = JsonParser.parseString(requestBody).getAsJsonObject();

        String email = json.get("email").getAsString();
        String clave = json.get("clave").getAsString();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try{
            Integer idUsuario = usuarioDao.obterUsuario(email, clave);

            if(idUsuario == null){
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("{\"success\": false, \"message\": \"Usuario no encontrado\"}");
            }else{
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("{\"success\": true, \"message\": \"Login exitoso.\"}");
            }
        }catch(Exception e){
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("{\"success\": false, \"message\": \"Error interno.\"}");
        }
    }
}
