package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Qwcd;
import dao.QwcdDAO;

public class QwcdServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Qwcd qwcd = new Qwcd();

        qwcd.setYear(request.getParameter("year"));
        qwcd.setCompleteSum(Integer.parseInt(request.getParameter("completeSum")));
        qwcd.setBackSum(Integer.parseInt(request.getParameter("backSum")));
        qwcd.setPayment(Integer.parseInt(request.getParameter("payment")));
        qwcd.setName(request.getParameter("name"));
        new QwcdDAO().add(qwcd);


    }
}