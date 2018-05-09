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

import bean.Qwcd;

public class QwcdDAO {

    public QwcdDAO(){
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

    public void add(Qwcd qwcd) {

        String sql = "insert into qwcd values(null,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(1, qwcd.year);
            ps.setInt(2, qwcd.completeSum);
            ps.setInt(3, qwcd.backSum);
            ps.setInt(4, qwcd.payment);
            ps.setString(5, qwcd.name);
            ps.setString(6,df.format(day));
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                qwcd.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Qwcd> list() {
        List<Qwcd> qwcds = new ArrayList<Qwcd>();

        String sql = "select * from qwcd order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Qwcd qwcd = new Qwcd();

                qwcd.setId(rs.getInt(1));
                qwcd.setYear(rs.getString(2));
                qwcd.setCompleteSum(rs.getInt(3));
                qwcd.setBackSum(rs.getInt(4));
                qwcd.setPayment(rs.getInt(5));
                qwcd.setName(rs.getString(6));


                qwcds.add(qwcd);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return qwcds;
    }
}
