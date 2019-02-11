package servlets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DealServlet extends javax.servlet.http.HttpServlet {
    private String message;

    public void init() throws ServletException
    {
        // 执行必需的初始化
        message = "Hello World";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=GB2312");
//
        PrintWriter out = response.getWriter();
        String title = "使用 POST 方法读取表单数据";
        // 处理中文
        String name =new String(request.getParameter("name"));
        String email=new String(request.getParameter("email"));
        String address=new String(request.getParameter("address"));
        String introduce=new String(request.getParameter("introduce"));
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>用户名</b>："
                + name + "\n" +
                "  <li><b>电子邮件</b>："
                + email + "\n" +
                "  <li><b>地址</b>："
                + address + "\n" +
                "  <li><b>个人介绍</b>："
                + introduce + "\n" +
                "</ul>\n" +
                "</body></html>");
    }

    public void destroy()
    {
        // 什么也不做
    }
}
