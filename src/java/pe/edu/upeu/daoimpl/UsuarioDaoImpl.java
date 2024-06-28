
package pe.edu.upeu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.config.Conexion;
import pe.edu.upeu.dao.UsuarioDao;
import pe.edu.upeu.dto.UsuarioLogin;
import pe.edu.upeu.entity.Usuario;

/**
 *
 * @author AEACOP
 */
public class UsuarioDaoImpl implements UsuarioDao{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx= null;
    @Override
    public int createUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteUsuario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario readUsuario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> readAllUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean buscarUsuario(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UsuarioLogin> login(String username, String clave) {
        List<UsuarioLogin> lista = new ArrayList<>();
        String SQL = "SELECT u.idusuario, u.username, e.sexo, r.nombre as rol, p.nombre FROM usuario u " +
                     "inner join empleado e on u.idempleado = e.idempleado " +
                     "inner join rol r on u.idrol = r.idrol " +
                     "inner join rol_privilegios rp on r.idrol = rp.idrol " +
                     "inner join privilegios p on rp.idprivilegio = p.idprivilegio " +
                     "where u.username = ? and u.clave = ? ";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, username);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while(rs.next()){
                UsuarioLogin login = new UsuarioLogin();
                login.setIdusuario(rs.getInt("idusuario"));
                login.setUsername(rs.getString("username"));
                login.setRol(rs.getString("rol"));
                login.setSexo(rs.getString("sexo"));
                login.setNombrep(rs.getString("nombre"));
                lista.add(login);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+ e.getClass().getName() + ": " + e.getMessage());
        }
        return lista;
    }
    
}
