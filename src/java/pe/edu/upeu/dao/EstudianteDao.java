/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.dao;

import java.util.List;
import pe.edu.upeu.entity.Estudiante;

/**
 *
 * @author AEACOP
 */
public interface EstudianteDao {
    public void agregarAlumno(Estudiante estudiante);
    public List<Estudiante> obtenerestudiantes();
}