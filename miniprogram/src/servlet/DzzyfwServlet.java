package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Dzzyfw;
import dao.DzzyfwDAO;

public class DzzyfwServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Dzzyfw dzzyfw = new Dzzyfw();

        dzzyfw.setYear(request.getParameter("year"));
        dzzyfw.setCategory(request.getParameter("category"));
        dzzyfw.setName(request.getParameter("name"));
        dzzyfw.setVisitNum(Integer.parseInt(request.getParameter("visitNum")));
        dzzyfw.setDownloadNum(Integer.parseInt(request.getParameter("downloadNum")));
        new DzzyfwDAO().add(dzzyfw);


    }
}