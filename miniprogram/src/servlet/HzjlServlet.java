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

        hzjl.setUnitname(request.getParameter("unitname"));
        hzjl.setChattime(request.getParameter("chattime"));
        hzjl.setPeopelNum(Integer.parseInt((request.getParameter("peopelNum"))));
        hzjl.setPeopelList(request.getParameter("peopelList"));
        hzjl.setCategory(request.getParameter("category"));
        new HzjlDAO().add(hzjl);


    }
}