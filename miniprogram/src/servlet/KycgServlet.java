package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Kycg;
import dao.KycgDAO;

public class KycgServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Kycg kycg = new Kycg();

        kycg.setYear(request.getParameter("year"));
        kycg.setName(request.getParameter("name"));
        kycg.setFirstAuthor(request.getParameter("firstAuthor"));
        kycg.setSource(request.getParameter("source"));
        kycg.setForm(request.getParameter("form"));
        kycg.setRange(request.getParameter("range"));
        kycg.setIsTranslate(request.getParameter("isTranslate"));
        kycg.setStudyCategory(request.getParameter("studyCategory"));
        kycg.setSituation(request.getParameter("situation"));
        kycg.setSubject(request.getParameter("subject"));
        kycg.setUnitName(request.getParameter("unitName"));
        kycg.setIssbn(request.getParameter("issbn"));
        kycg.setPublishTime(request.getParameter("publishTime"));
        kycg.setWordNum(request.getParameter("wordNum"));
        kycg.setCategory(request.getParameter("category"));
        kycg.setOtherAuthor(request.getParameter("otherAuthor"));
        kycg.setExtra(request.getParameter("extra"));
        kycg.setType(request.getParameter("type"));

        new KycgDAO().add(kycg);


    }
}