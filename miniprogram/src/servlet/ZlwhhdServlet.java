package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Zlwhhd;
import dao.ZlwhhdDAO;

public class ZlwhhdServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Zlwhhd zlwhhd = new Zlwhhd();

        zlwhhd.setYear(request.getParameter("year"));
        zlwhhd.setDate(request.getParameter("date"));
        zlwhhd.setCategory(request.getParameter("category"));
        zlwhhd.setTheme(request.getParameter("theme"));
        zlwhhd.setAppertainBrands(request.getParameter("appertainBrands"));
        zlwhhd.setAppertainPeriod(Integer.parseInt(request.getParameter("appertainPeriod")));
        zlwhhd.setPeopelSum(Integer.parseInt(request.getParameter("peopelSum")));
        zlwhhd.setNote(request.getParameter("note"));
        new ZlwhhdDAO().add(zlwhhd);


    }
}