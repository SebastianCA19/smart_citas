/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.smart_citas.model;

/**
 *
 * @author edavi
 */
public class Paciente extends Usuario{
    
    public Paciente(Integer id, String nombre, String primerApellido, String segundoApellido, String email, String clave, Integer estadoActivo) {
        super(id, nombre, primerApellido, segundoApellido, email, clave, estadoActivo);
    }
    
}
