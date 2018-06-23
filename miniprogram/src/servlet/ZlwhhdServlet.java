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

<<<<<<< HEAD
        zlwhhd.setYear(request.getParameter("year"));
=======
>>>>>>> 47a8143bb6fe0c953270471544ef19fb139754a5
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