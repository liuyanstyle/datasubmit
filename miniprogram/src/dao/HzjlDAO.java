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

import bean.Hzjl;

public class HzjlDAO {

    public HzjlDAO(){
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

    public void add(Hzjl hzjl) {

        String sql = "insert into hzjl values(null,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(1,hzjl.year);
            ps.setString(2, hzjl.unitname);
            ps.setString(3, hzjl.chattime);
            ps.setInt(4, hzjl.peopelNum);
            ps.setString(5, hzjl.peopelList);
            ps.setString(6, hzjl.category);
            ps.setString(7,df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                hzjl.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Hzjl> list() {
        List<Hzjl> hzjls = new ArrayList<Hzjl>();

        String sql = "select * from hzjl order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Hzjl hzjl = new Hzjl();
                String year=rs.getString(1);
                int id = rs.getInt(2);
                String unitname = rs.getString(3);
                String chattime = rs.getString(4);
                int peopelNum = rs.getInt(5);
                String peopelList = rs.getString(6);
                String category= rs.getString(7);

                hzjl.setYear(year);
                hzjl.setId(id);
                hzjl.setCategory(category);
                hzjl.setChattime(chattime);
                hzjl.setPeopelList(peopelList);
                hzjl.setPeopelNum(peopelNum);
                hzjl.setUnitname(unitname);


                hzjls.add(hzjl);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return hzjls;
    }
}
