import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        ServletContext sc= this .getServletContext();
        Student st=(Student)sc.getAttribute("s");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset= UTF-8");
        String name = st.getName();
        name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
        String id = st.getSno();
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h3> 学号： "+id+"</h3><p>");
        pw.println("<h3> 姓名： "+name+"</h3><p>");
        pw.println("<a href=\"/test2/input.html\"> 返回 </a>");
        pw.println("</body>");
        pw.println("</html>");
    }
}
