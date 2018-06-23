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

import bean.Zlwhhd;

public class ZlwhhdDAO {

    public ZlwhhdDAO(){
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

    public void add(Zlwhhd zlwhhd) {

        String sql = "insert into zlwhhd values(null,?,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(1,zlwhhd.year);
            ps.setString(2, zlwhhd.date);
            ps.setString(3, zlwhhd.category);
            ps.setString(4, zlwhhd.theme);
            ps.setString(5, zlwhhd.appertainBrands);
            ps.setInt(6, zlwhhd.appertainPeriod);
            ps.setInt(7, zlwhhd.peopelSum);
            ps.setString(8, zlwhhd.note);
            ps.setString(9,df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                zlwhhd.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Zlwhhd> list() {
        List<Zlwhhd> zlwhhds = new ArrayList<Zlwhhd>();

        String sql = "select * from zlwhhd order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Zlwhhd zlwhhd = new Zlwhhd();

                zlwhhd.setYear(rs.getString(1));
                zlwhhd.setId(rs.getInt(2));
                zlwhhd.setDate(rs.getString(3));
                zlwhhd.setCategory(rs.getString(4));
                zlwhhd.setTheme(rs.getString(5));
                zlwhhd.setAppertainBrands(rs.getString(6));
                zlwhhd.setAppertainPeriod(rs.getInt(7));
                zlwhhd.setPeopelSum(rs.getInt(8));
                zlwhhd.setNote(rs.getString(9));


                zlwhhds.add(zlwhhd);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return zlwhhds;
    }
}

