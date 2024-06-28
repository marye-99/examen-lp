import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.dao.EstudianteDao;
import pe.edu.upeu.daoimpl.EstudianteDaoImpl;
import pe.edu.upeu.entity.Estudiante;

@WebServlet("/usuarios")
public class EstudiantesController extends HttpServlet {
    private EstudianteDao estudianteDao = (EstudianteDao) new EstudianteDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        int ep = Integer.parseInt(request.getParameter("ep"));

        Estudiante estudiante = new Estudiante();
        estudiante.setNombres(nombre);
        estudiante.setApellidos(apellidos);
        estudiante.setCorreo(correo);
        estudiante.setTelefono(telefono);
        estudiante.setIdcarrera(ep);

        estudianteDao.agregarAlumno(estudiante);
        
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Estudiante> alumnos = estudianteDao.obtenerestudiantes();
        String json = new Gson().toJson(alumnos);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(json);
        out.close();
    }
}
