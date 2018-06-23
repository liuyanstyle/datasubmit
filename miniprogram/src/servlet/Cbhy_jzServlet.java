package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cbhy_jz;
import dao.Cbhy_jzDAO;

public class Cbhy_jzServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Cbhy_jz cbhy_jz = new Cbhy_jz();

        cbhy_jz.setYear(request.getParameter("year"));
        cbhy_jz.setUnitname(request.getParameter("unitname"));
        cbhy_jz.setTime(request.getParameter("time"));
        cbhy_jz.setLocation(request.getParameter("location"));
        cbhy_jz.setPeopleNum(Integer.parseInt(request.getParameter("peopelNum")));
        cbhy_jz.setOrganizer(request.getParameter("organizer"));
        cbhy_jz.setPeopelList(request.getParameter("peopelList"));
        new Cbhy_jzDAO().add(cbhy_jz);


    }
}
