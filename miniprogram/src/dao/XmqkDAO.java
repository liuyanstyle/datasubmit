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

import bean.Xmqk;

public class XmqkDAO {

    public XmqkDAO(){
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

    public void add(Xmqk xmqk) {

        String sql = "insert into xmqk values(null,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(1, xmqk.year);
            ps.setString(2, xmqk.unitName);
            ps.setString(3, xmqk.name);
            ps.setString(4, xmqk.headPeople);
            ps.setString(5, xmqk.peopelList);
            ps.setString(6, xmqk.unitName1);
            ps.setString(7, xmqk.firsttime);
            ps.setString(8, xmqk.type);
            ps.setString(9, xmqk.lasttime);
            ps.setString(10, xmqk.extra);
            ps.setString(11, df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                xmqk.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Xmqk> list() {
        List<Xmqk> xmqks = new ArrayList<Xmqk>();

        String sql = "select * from xmqk order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Xmqk xmqk = new Xmqk();

                xmqk.setId(rs.getInt(1));
                xmqk.setYear(rs.getString(2));
                xmqk.setUnitName(rs.getString(3));
                xmqk.setName(rs.getString(4));
                xmqk.setHeadPeople(rs.getString(5));
                xmqk.setPeopelList(rs.getString(6));
                xmqk.setUnitName1(rs.getString(7));
                xmqk.setFirsttime(rs.getString(8));
                xmqk.setType(rs.getString(9));
                xmqk.setLasttime(rs.getString(10));
                xmqk.setExtra(rs.getString(11));


                xmqks.add(xmqk);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return xmqks;
    }
}
