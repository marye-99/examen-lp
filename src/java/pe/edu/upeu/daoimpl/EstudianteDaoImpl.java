/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.daoimpl;

import java.util.List;
import pe.edu.upeu.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import pe.edu.upeu.dao.EstudianteDao;
import pe.edu.upeu.entity.Estudiante;

/**
 *
 * @author AEACOP
 */
public class EstudianteDaoImpl implements EstudianteDao{

    @Override
    public void agregarAlumno(Estudiante alumno) {
        String query = "INSERT INTO usuarios (nombre, apellidos, correo, telefono, ep) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, alumno.getNombres());
            ps.setString(2, alumno.getApellidos());
            ps.setString(3, alumno.getCorreo());
            ps.setInt(4, alumno.getTelefono());
            ps.setInt(5, alumno.getIdcarrera());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Estudiante> obtenerAlumnos() {
        List<Estudiante> alumnos = new ArrayList<>();
        String query = "SELECT * FROM usuarios";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Estudiante alumno = new Estudiante();
                alumno.setIdestudiante(rs.getInt("id"));
                alumno.setNombres(rs.getString("nombre"));
                alumno.setApellidos(rs.getString("apellidos"));
                alumno.setCorreo(rs.getString("correo"));
                alumno.setTelefono(rs.getInt("telefono"));
                alumno.setIdcarrera(rs.getInt("idcarrera"));
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    @Override
    public List<Estudiante> obtenerestudiantes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
