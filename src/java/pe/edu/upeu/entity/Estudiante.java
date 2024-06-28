/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author AEACOP
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    private int idestudiante;
    private String nombres;
    private String apellidos;
    private String correo;
    private int telefono;
    private int idcarrera;

    public void add(List<Estudiante> estudiantes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}