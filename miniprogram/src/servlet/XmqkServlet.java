package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Xmqk;
import dao.XmqkDAO;

public class XmqkServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Xmqk xmqk = new Xmqk();

        xmqk.setYear(request.getParameter("year"));
        xmqk.setName(request.getParameter("name"));
        xmqk.setUnitName(request.getParameter("uniteName"));
        xmqk.setUnitName1(request.getParameter("uniteName1"));
        xmqk.setHeadPeople(request.getParameter("headPeople"));
        xmqk.setUnitName1(request.getParameter("peopelList"));
        xmqk.setFirsttime(request.getParameter("firsttime"));
        xmqk.setLasttime(request.getParameter("lasttime"));
        xmqk.setPeopelList(request.getParameter("peopelList"));
        xmqk.setExtra(request.getParameter("extra"));
        xmqk.setType(request.getParameter("type"));
        new XmqkDAO().add(xmqk);


    }
}