package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Rcdwjs;
import dao.RcdwjsDAO;

public class RcdwjsServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Rcdwjs rcdwjs = new Rcdwjs();

        rcdwjs.setYear(request.getParameter("year"));
        rcdwjs.setPeopleNum(Integer.parseInt(request.getParameter("peopelNum")));
        rcdwjs.setDoctorNum(Integer.parseInt(request.getParameter("doctorNum")));
        rcdwjs.setUndergraduateNum(Integer.parseInt(request.getParameter("undergraduateNum")));
        rcdwjs.setMasterNum(Integer.parseInt(request.getParameter("masterNum")));
        rcdwjs.setOtherEducation(Integer.parseInt(request.getParameter("otherEducation")));
        rcdwjs.setHighProfessionNum(Integer.parseInt(request.getParameter("highProfessioNum")));
        rcdwjs.setDeputyHighNum(Integer.parseInt(request.getParameter("deputyHighNum")));
        rcdwjs.setIntermediaterNum(Integer.parseInt(request.getParameter("intermediaterNum")));
        rcdwjs.setOtherTitle(Integer.parseInt(request.getParameter("otherTitle")));
        rcdwjs.setAge1(Integer.parseInt(request.getParameter("age1")));
        rcdwjs.setAge2(Integer.parseInt(request.getParameter("age2")));
        rcdwjs.setAge3(Integer.parseInt(request.getParameter("age3")));
        rcdwjs.setAge4(Integer.parseInt(request.getParameter("age4")));
        rcdwjs.setCategory(request.getParameter("category"));


        new RcdwjsDAO().add(rcdwjs);


    }
}