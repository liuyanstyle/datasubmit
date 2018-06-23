package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Dj_gh;
import dao.Dj_ghDAO;

public class Dj_ghServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Dj_gh dj_gh = new Dj_gh();

        dj_gh.setYear(request.getParameter("year"));
        dj_gh.setCategory(request.getParameter("category"));
        dj_gh.setActivitytime(request.getParameter("activitytime"));
        dj_gh.setTheme(request.getParameter("theme"));
        dj_gh.setYear(request.getParameter("year"));
        dj_gh.setExtra(request.getParameter("extra"));
        new Dj_ghDAO().add(dj_gh);


    }
}