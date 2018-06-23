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

import bean.Xkfw;

public class XkfwDAO {

    public XkfwDAO(){
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

    public void add(Xkfw xkfw) {

        String sql = "insert into xkfw values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(1, xkfw.year);
            ps.setInt(2, xkfw.peopelNum);
            ps.setInt(3, xkfw.serviceTime);
            ps.setString(4, xkfw.serverTheme);
            ps.setInt(5, xkfw.decisionTime);
            ps.setString(6, xkfw.decisionTheme);
            ps.setString(7, df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                xkfw.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Xkfw> list() {
        List<Xkfw> xkfws = new ArrayList<Xkfw>();

        String sql = "select * from xkfw order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Xkfw xkfw = new Xkfw();

                xkfw.setId(rs.getInt(1));
                xkfw.setYear(rs.getString(2));
                xkfw.setPeopelNum(rs.getInt(3));
                xkfw.setServiceTime(rs.getInt(4));
                xkfw.setServerTheme(rs.getString(5));
                xkfw.setDecisionTime(rs.getInt(6));
                xkfw.setDecisionTheme(rs.getString(7));



                xkfws.add(xkfw);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return xkfws;
    }
}
