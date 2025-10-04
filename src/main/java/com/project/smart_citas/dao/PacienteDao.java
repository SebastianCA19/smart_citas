/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.smart_citas.dao;

import com.project.smart_citas.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edavi
 */
public class PacienteDao extends UsuarioDao{
    
    // Obtener todos los pacientes
    public List<Paciente> obtener() {
        List<Paciente> lis = new ArrayList<>();
        String sql = "SELECT u.* FROM usuarios u \n"
                + "INNER JOIN pacientes p ON u.id_usuario = p.id_paciente \n"
                + "WHERE u.estado_activo = 1;";
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String primerApellido = rs.getString("primer_apellido");
                String segundoApellido = rs.getString("segundo_apellido");
                String email = rs.getString("email");
                String clave = rs.getString("clave");
                Integer estadoActivo = rs.getInt("estado_activo");
                Paciente p = new Paciente(id, nombre, primerApellido, segundoApellido, email, clave, estadoActivo);
                lis.add(p);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lis;
    }
    
     // Insertar un paciente
    public Integer insertar(String nombre, String primerApellido, String segundoApellido, String email, String clave ) {
        Integer idPaciente = super.insertar(nombre, primerApellido, segundoApellido, email, clave);

        String sql = "INSERT INTO pacientes (id_paciente) VALUES (?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idPaciente);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idPaciente;
    }

    // Actualizar paciente por ID
    public boolean actualizar(int id, String nuevoNombre, String nuevoEmail) {
        boolean isInsertado = false;
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevoEmail);
            stmt.setInt(3, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                isInsertado = true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInsertado;
    }

    // Eliminar paciente por ID
    public boolean eliminar(int id) {
        return super.eliminar(id);
    }
    
}
