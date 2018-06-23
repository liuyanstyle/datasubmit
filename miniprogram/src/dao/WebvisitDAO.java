package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Webvisit;

public class WebvisitDAO {

    public WebvisitDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/[datasubmit]?characterEncoding=UTF-8", "root",
                "admin");
    }

    public void add(Webvisit webvisit) {

        String sql = "insert into webvisit values(null,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(1, webvisit.year);
            ps.setString(2, webvisit.webname);
            ps.setLong(3, webvisit.pvVisit);
            ps.setLong(4, webvisit.uvVisit);
            ps.setString(5,df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                webvisit.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Webvisit> list() {
        List<Webvisit> webvisits = new ArrayList<Webvisit>();

        String sql = "select * from webvisit";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Webvisit webvisit = new Webvisit();
                int id = rs.getInt(1);
                String year = rs.getString(2);
                String webname= rs.getString(3);
                Long pvVisit = rs.getLong(4);
                Long uvVisit = rs.getLong(5);

                webvisit.setId(id);
                webvisit.setYear(year);
                webvisit.setWebname(webname);
                webvisit.setPvVisit(pvVisit);
                webvisit.setUvVisit(uvVisit);


                webvisits.add(webvisit);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return webvisits;
    }
}
