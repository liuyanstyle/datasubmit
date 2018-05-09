package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Zyjs;
import dao.ZyjsDAO;

public class ZyjsServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");;

        Zyjs zyjs = new Zyjs();
        Date day=new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        zyjs.setYear(request.getParameter("year"));
        zyjs.setCategory(request.getParameter("category"));
        zyjs.setType(request.getParameter("type"));
        zyjs.setPurchaseCategoryNum(Integer.parseInt(request.getParameter("purchaseCategoryNum")));
        zyjs.setPurchaseNum(Integer.parseInt(request.getParameter("purchaseNum")));
        zyjs.setMoney(request.getParameter("money"));
        zyjs.setThisyearRefill(Integer.parseInt(request.getParameter("thisyearRefill")));
        zyjs.setLogout(Integer.parseInt(request.getParameter("logout")));
        zyjs.setThisyearAdd(Integer.parseInt(request.getParameter("thisyearAdd")));
        zyjs.setFormeryearSum(Integer.parseInt(request.getParameter("formeryearSum")));
        zyjs.setAllSum(Integer.parseInt(request.getParameter("allSum")));
        zyjs.setDate(df.format(day));
        System.out.println(zyjs);
        new ZyjsDAO().add(zyjs);


    }
}