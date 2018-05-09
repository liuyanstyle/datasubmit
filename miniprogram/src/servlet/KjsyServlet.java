package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Kjsy;
import dao.KjsyDAO;

public class KjsyServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Kjsy kjsy = new Kjsy();

        kjsy.setYear(request.getParameter("year"));
        kjsy.setCategory(request.getParameter("category"));
        kjsy.setName(request.getParameter("name"));
        kjsy.setCampus(request.getParameter("campus"));
        kjsy.setCapacity(Integer.parseInt(request.getParameter("capacity")));
        kjsy.setReservationTimes(Long.parseLong(request.getParameter("reservationTimes")));
        kjsy.setReservationtime(Long.parseLong(request.getParameter("reservationtime")));
        kjsy.setUseTimes(Long.parseLong(request.getParameter("useTimes")));
        kjsy.setUsetime(Long.parseLong(request.getParameter("usetime")));
        new KjsyDAO().add(kjsy);


    }
}