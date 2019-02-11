import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;



@WebServlet(name = "ConfigDemoServlet")
public class ConfigDemoServlet extends HttpServlet {
    String servletName=null;
    ServletConfig config=null;
    String email=null;
    String telephone=null;
    public void init() {
        config = getServletConfig();
        servletName = config.getServletName();
        email = config.getInitParameter("email");
        telephone = config.getInitParameter("telephone");
    }


    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Servlet名称："+servletName+"<br>");
        out.println("Email地址："+email+"<br>");
        out.println("电话："+telephone);
        out.println("</body></html>");

    }

}
