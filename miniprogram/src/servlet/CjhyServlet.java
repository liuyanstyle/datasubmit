package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cjhy;
import dao.CjhyDAO;

public class CjhyServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Cjhy cjhy = new Cjhy();

<<<<<<< HEAD
        cjhy.setYear(request.getParameter("year"));
=======
>>>>>>> 47a8143bb6fe0c953270471544ef19fb139754a5
        cjhy.setName(request.getParameter("name"));
        cjhy.setDate(request.getParameter("date"));
        cjhy.setSite(request.getParameter("site"));
        cjhy.setPeopleList(request.getParameter("peopelList"));
        new CjhyDAO().add(cjhy);


    }
}