package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Xkfw;
import dao.XkfwDAO;

public class XkfwServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Xkfw xkfw = new Xkfw();

        xkfw.setYear(request.getParameter("year"));
        xkfw.setServerTheme(request.getParameter("serverTheme"));
        xkfw.setDecisionTheme(request.getParameter("decisionTheme"));
        xkfw.setPeopelNum(Integer.parseInt(request.getParameter("peopelNum")));
        xkfw.setServiceTime(Integer.parseInt(request.getParameter("serviceTime")));
        xkfw.setDecisionTime(Integer.parseInt(request.getParameter("decisionTime")));

        new XkfwDAO().add(xkfw);


    }
}