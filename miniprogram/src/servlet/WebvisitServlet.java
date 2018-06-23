package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Webvisit;
import dao.WebvisitDAO;

public class WebvisitServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Webvisit webvisit = new Webvisit();

        webvisit.setYear(request.getParameter("year"));
        webvisit.setWebname(request.getParameter("webname"));
        webvisit.setPvVisit(Long.parseLong((request.getParameter("pvVisit"))));
        webvisit.setUvVisit(Long.parseLong(request.getParameter("uvVisit")));
        new WebvisitDAO().add(webvisit);


    }
}