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

import bean.Dzzyfw;

public class DzzyfwDAO {

    public DzzyfwDAO(){
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

    public void add(Dzzyfw dzzfw) {

        String sql = "insert into dzzfw values(null,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(1, dzzfw.year);
            ps.setString(5, dzzfw.category);
            ps.setString(2, dzzfw.name);
            ps.setInt(3, dzzfw.visitNum);
            ps.setInt(4, dzzfw.downloadNum);
            ps.setString(6, df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                dzzfw.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Dzzyfw> list() {
        List<Dzzyfw> dzzfws = new ArrayList<Dzzyfw>();

        String sql = "select * from dzzfw order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Dzzyfw dzzfw = new Dzzyfw();

                dzzfw.setId(rs.getInt(1));
                dzzfw.setYear(rs.getString(2));
                dzzfw.setCategory(rs.getString(6));
                dzzfw.setName(rs.getString(3));
                dzzfw.setVisitNum(rs.getInt(4));
                dzzfw.setDownloadNum(rs.getInt(5));



                dzzfws.add(dzzfw);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return dzzfws;
    }
}
