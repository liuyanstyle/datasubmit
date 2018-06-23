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

import bean.Rcdwjs;

public class RcdwjsDAO {

    public RcdwjsDAO(){
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

    public void add(Rcdwjs rcdwjs) {

        String sql = "insert into rcdwjs values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(1, rcdwjs.year);
            ps.setString(2, rcdwjs.category);
            ps.setInt(3, rcdwjs.peopleNum);
            ps.setInt(4, rcdwjs.doctorNum);
            ps.setInt(5, rcdwjs.undergraduateNum);
            ps.setInt(6, rcdwjs.masterNum);
            ps.setInt(7, rcdwjs.otherEducation);
            ps.setInt(8, rcdwjs.highProfessionNum);
            ps.setInt(9, rcdwjs.deputyHighNum);
            ps.setInt(10, rcdwjs.intermediaterNum);
            ps.setInt(11, rcdwjs.otherTitle);
            ps.setInt(12,rcdwjs.age1);
            ps.setInt(13,rcdwjs.age2);
            ps.setInt(14,rcdwjs.age3);
            ps.setInt(15,rcdwjs.age4);
            ps.setString(16,df.format(day));
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                rcdwjs.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Rcdwjs> list() {
        List<Rcdwjs> rcdwjss = new ArrayList<Rcdwjs>();

        String sql = "select * from rcdwjs order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Rcdwjs rcdwjs = new Rcdwjs();

                rcdwjs.setId(rs.getInt(1));
                rcdwjs.setYear(rs.getString(2));
                rcdwjs.setCategory(rs.getString(3));
                rcdwjs.setPeopleNum(rs.getInt(4));
                rcdwjs.setDoctorNum(rs.getInt(5));
                rcdwjs.setUndergraduateNum(rs.getInt(6));
                rcdwjs.setMasterNum(rs.getInt(7));
                rcdwjs.setOtherEducation(rs.getInt(8));
                rcdwjs.setHighProfessionNum(rs.getInt(9));
                rcdwjs.setDeputyHighNum(rs.getInt(10));
                rcdwjs.setIntermediaterNum(rs.getInt(11));
                rcdwjs.setOtherTitle(rs.getInt(12));
                rcdwjs.setAge1(rs.getInt(13));
                rcdwjs.setAge2(rs.getInt(14));
                rcdwjs.setAge3(rs.getInt(15));
                rcdwjs.setAge4(rs.getInt(16));


                rcdwjss.add(rcdwjs);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return rcdwjss;
    }
}
