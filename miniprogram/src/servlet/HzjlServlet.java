package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hzjl;
import dao.HzjlDAO;

public class HzjlServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Hzjl hzjl = new Hzjl();

<<<<<<< HEAD
        hzjl.setYear(request.getParameter("year"));
=======
>>>>>>> 47a8143bb6fe0c953270471544ef19fb139754a5
        hzjl.setUnitname(request.getParameter("unitname"));
        hzjl.setChattime(request.getParameter("chattime"));
        hzjl.setPeopelNum(Integer.parseInt((request.getParameter("peopelNum"))));
        hzjl.setPeopelList(request.getParameter("peopelList"));
        hzjl.setCategory(request.getParameter("category"));
        new HzjlDAO().add(hzjl);


    }
}