package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Wechatyy;
import dao.WechatyyDAO;

public class WechatyyServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Wechatyy wechat = new Wechatyy();

        wechat.setYear(request.getParameter("year"));
        wechat.setAddedFance(Integer.parseInt(request.getParameter("addedFance")));
        wechat.setPushTimes(Integer.parseInt(request.getParameter("pushTimes")));
        wechat.setMaterial(Integer.parseInt(request.getParameter("material")));
        wechat.setMessageSend(Integer.parseInt(request.getParameter("messageSend")));
        wechat.setMessageShare(Integer.parseInt(request.getParameter("messageShare")));
        wechat.setFanceSum(Integer.parseInt(request.getParameter("FanceSum")));

        new WechatyyDAO().add(wechat);


    }
}