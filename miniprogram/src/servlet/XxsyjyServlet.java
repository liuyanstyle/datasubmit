package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Xxsyjy;
import dao.XxsyjyDAO;

public class XxsyjyServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Xxsyjy xxsyjy = new Xxsyjy();

        xxsyjy.setYear(request.getParameter("year"));
        xxsyjy.setCourseName(request.getParameter("courseName"));
        xxsyjy.setObject(request.getParameter("object"));
        xxsyjy.setClassSum(Integer.parseInt(request.getParameter("classSum")));
        xxsyjy.setStudentSum(Integer.parseInt(request.getParameter("studentSum")));
        xxsyjy.setCategory(request.getParameter("category"));
        new XxsyjyDAO().add(xxsyjy);


    }
}