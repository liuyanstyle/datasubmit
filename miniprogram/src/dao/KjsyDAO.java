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

import bean.Kjsy;

public class KjsyDAO {

    public KjsyDAO(){
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

    public void add(Kjsy kjsy) {

        String sql = "insert into kjsy values(null,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(1, kjsy.year);
            ps.setString(2, kjsy.category);
            ps.setString(3, kjsy.name);
            ps.setString(4, kjsy.campus);
            ps.setInt(5, kjsy.capacity);
            ps.setLong(6, kjsy.reservationTimes);
            ps.setLong(7, kjsy.reservationtime);
            ps.setLong(8, kjsy.useTimes);
            ps.setLong(9, kjsy.usetime);
            ps.setString(10,df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                kjsy.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Kjsy> list() {
        List<Kjsy> kjsys = new ArrayList<Kjsy>();

        String sql = "select * from kjsy order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Kjsy kjsy = new Kjsy();

                kjsy.setId(rs.getInt(1));
                kjsy.setYear(rs.getString(2));
                kjsy.setCategory(rs.getString(3));
                kjsy.setName(rs.getString(4));
                kjsy.setCampus(rs.getString(5));
                kjsy.setCapacity(rs.getInt(6));
                kjsy.setReservationTimes(rs.getLong(7));
                kjsy.setReservationtime(rs.getLong(8));
                kjsy.setUseTimes(rs.getLong(9));
                kjsy.setUsetime(rs.getLong(10));


                kjsys.add(kjsy);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return kjsys;
    }
}
