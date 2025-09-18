package com.project.smart_citas.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author edavi
 */
import java.sql.*;

public class UsuarioDao extends Dao{

    // Insertar un usuario
    public Integer insertar(String nombre, String primerApellido, String segundoApellido, String email, String clave ) {
        Integer idGenerado = null;
        String sql = "INSERT INTO usuarios (nombre, primer_apellido, segundo_apellido , email, clave, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombre);
            stmt.setString(2, primerApellido);
            stmt.setString(3, segundoApellido);
            stmt.setString(4, email);
            stmt.setString(5, clave);
            stmt.setInt(6, 1);
            stmt.executeUpdate();
            
            int filasInsertadas = stmt.executeUpdate();
            if (filasInsertadas > 0) {
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        idGenerado = rs.getInt(1);
                    }
                }
             }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idGenerado;
    }
    
    // Eliminar usuario por ID
    public boolean eliminar(int id) {
        boolean isEliminado = false;
        String sql = "UPDATE usuarios SET estado_activo = 0 WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                isEliminado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isEliminado;
    }
}

