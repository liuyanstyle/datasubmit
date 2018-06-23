package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hjqk;
import dao.HjqkDAO;

public class HjqkServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Hjqk hjqk = new Hjqk();

        hjqk.setYear(request.getParameter("year"));
        hjqk.setName(request.getParameter("name"));
        hjqk.setType(request.getParameter("type"));
        hjqk.setCategory(request.getParameter("category"));
        hjqk.setUnitName(request.getParameter("unitName"));
        hjqk.setWinYear(request.getParameter("winYear"));
        hjqk.setPeopelList(request.getParameter("peopleList"));
        hjqk.setExtra(request.getParameter("extra"));
        hjqk.setType(request.getParameter("type"));
        new HjqkDAO().add(hjqk);


    }
}