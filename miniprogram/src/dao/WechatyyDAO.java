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

import bean.Wechatyy;

public class WechatyyDAO {

    public WechatyyDAO(){
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

    public void add(Wechatyy wechatyy) {

        String sql = "insert into wechatyy values(null,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(1, wechatyy.year);
            ps.setInt(2, wechatyy.addedFance);
            ps.setInt(3, wechatyy.pushTimes);
            ps.setInt(4, wechatyy.material);
            ps.setInt(5, wechatyy.messageSend);
            ps.setInt(6, wechatyy.messageShare);
            ps.setInt(7, wechatyy.FanceSum);
            ps.setString(8,df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                wechatyy.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Wechatyy> list() {
        List<Wechatyy> wechatyys = new ArrayList<Wechatyy>();

        String sql = "select * from wechatyy order by  序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Wechatyy wechatyy = new Wechatyy();

                wechatyy.setId(rs.getInt(1));
                wechatyy.setYear(rs.getString(2));
                wechatyy.setAddedFance(rs.getInt(3));
                wechatyy.setPushTimes(rs.getInt(4));
                wechatyy.setMaterial(rs.getInt(5));
                wechatyy.setMessageSend(rs.getInt(6));
                wechatyy.setMessageShare(rs.getInt(7));
                wechatyy.setFanceSum(rs.getInt(8));

                wechatyys.add(wechatyy);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return wechatyys;
    }
}

