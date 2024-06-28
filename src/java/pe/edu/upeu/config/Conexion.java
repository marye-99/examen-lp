
package pe.edu.upeu.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author AEACOP
 */
public class Conexion {
    private static Connection conexion;

    public static Connection getConexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            if(conexion==null){
                conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##examen", "123");
            }
            
        } catch (ClassNotFoundException | SQLException cnfe) {
            System.out.println("Error1: " + cnfe);
        }
        return conexion;
    }
}
