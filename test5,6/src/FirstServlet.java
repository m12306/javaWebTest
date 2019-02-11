import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
        String id = request.getParameter("id");
        Student s= new Student(id,name);
        ServletContext sc= this .getServletContext();
        sc.setAttribute("s", s);
        RequestDispatcher
                rd=request.getRequestDispatcher("/SecondServlet");
        rd.forward(request, response);
    }

}
