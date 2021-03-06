package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import dao.*;
import org.json.*;
import net.sf.json.JSONArray;


public class GetAlldataServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<Hzjl> hzjls =new HzjlDAO().list();
        //String  hzjl= JSONArray.fromObject(hzjls).toString();

        List<Kjcxcscy>  kjcxcscys =new KjcxcscyDAO().list();
        //String kjcxcscy = JSONArray.fromObject(kjcxcscys ).toString();

        List<Kjsy>  kjsys =new KjsyDAO().list();
        //String kjsy = JSONArray.fromObject(kjsys).toString();

        List<Qwcd>  qwcds =new QwcdDAO().list();
        //String qwcd = JSONArray.fromObject(qwcds).toString();

        List<Webvisit>  webvisits =new WebvisitDAO().list();
        //String webvisit = JSONArray.fromObject(webvisits ).toString();

        List<Wechatyy>  wechatyys =new WechatyyDAO().list();
        //String wechatyy = JSONArray.fromObject(wechatyys).toString();

        List<Xxsyjy>  xxsyjys=new XxsyjyDAO().list();
       // String xxsyjy= JSONArray.fromObject(xxsyjys).toString();

        List<Zyjs>  zyjss =new ZyjsDAO().list();
        //String zyjs = JSONArray.fromObject(zyjss).toString();

        List<Zlwhhd>  zlwhhds =new ZlwhhdDAO().list();
        //String zlwhhd = JSONArray.fromObject(zlwhhds ).toString();



        PrintWriter out =response.getWriter();
        JSONObject alldata=new JSONObject();
        alldata.put("hzjl",hzjls);
        alldata.put("kjcxcscy ",kjcxcscys);
        alldata.put("qwcd",qwcds);
        alldata.put("webvisit",webvisits);
        alldata.put("wechatyy",wechatyys);
        alldata.put("xxsyjy",xxsyjys);
        alldata.put("zlwhhd",zlwhhds);
        alldata.put("zyjs",zyjss);
        alldata.put("kjsy",kjsys);
        out.print(alldata);


    }
}