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

import bean.Dj_gh;

public class Dj_ghDAO {

    public Dj_ghDAO(){
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

    public void add(Dj_gh dj_gh) {

        String sql = "insert into dj_gh values(null,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(1,dj_gh.year);
            ps.setString(2, dj_gh.activitytime);
            ps.setString(3, dj_gh.theme);
            ps.setString(4, dj_gh.category);
            ps.setString(5, dj_gh.extra);
            ps.setString(6,df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                dj_gh.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Dj_gh> list() {
        List<Dj_gh> dj_ghs = new ArrayList<Dj_gh>();

        String sql = "select * from dj_gh order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Dj_gh dj_gh = new Dj_gh();
                String year=rs.getString(2);
                int id = rs.getInt(1);
                String activitytime = rs.getString(3);
                String theme= rs.getString(4);
                String category=rs.getString(5);
                String extra = rs.getString(6);

                dj_gh.setYear(year);
                dj_gh.setId(id);
                dj_gh.setActivitytime(activitytime);
                dj_gh.setTheme(theme);
                dj_gh.setCategory(category);
                dj_gh.setExtra(extra);

                dj_ghs.add(dj_gh);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return dj_ghs;
    }
}

