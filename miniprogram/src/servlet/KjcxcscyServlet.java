package servlet;

import bean.Kjcxcscy;
import dao.KjcxcscyDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KjcxcscyServlet extends HttpServlet{
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Kjcxcscy kjcxcscy = new Kjcxcscy();

        kjcxcscy.setYear(request.getParameter("year"));
        kjcxcscy.setCxNum(Integer.parseInt(request.getParameter("cxNum")));
        kjcxcscy.setHomeCXNum(Integer.parseInt((request.getParameter("homecxNum"))));
        kjcxcscy.setCscyNum(Integer.parseInt(request.getParameter("cscyNum")));
        new KjcxcscyDAO().add(kjcxcscy);


    }
}
