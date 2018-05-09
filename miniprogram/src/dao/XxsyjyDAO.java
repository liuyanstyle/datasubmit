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

import bean.Xxsyjy;

public class XxsyjyDAO {

    public XxsyjyDAO(){
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

    public void add(Xxsyjy xxsyjy) {

        String sql = "insert into xxsyjy values(null,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(1, xxsyjy.year);
            ps.setString(2, xxsyjy.courseName);
            ps.setString(3, xxsyjy.object);
            ps.setInt(4, xxsyjy.classSum);
            ps.setInt(5, xxsyjy.studentSum);
            ps.setString(6, xxsyjy.category);
            ps.setString(7,df.format(day));
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                xxsyjy.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Xxsyjy> list() {
        List<Xxsyjy> xxsyjys = new ArrayList<Xxsyjy>();

        String sql = "select * from xxsyjy order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Xxsyjy xxsyjy = new Xxsyjy();

                xxsyjy.setId(rs.getInt(1));
                xxsyjy.setYear(rs.getString(2));
                xxsyjy.setCourseName(rs.getString(3));
                xxsyjy.setObject(rs.getString(4));
                xxsyjy.setClassSum(rs.getInt(5));
                xxsyjy.setStudentSum(rs.getInt(6));
                xxsyjy.setCategory(rs.getString(7));


                xxsyjys.add(xxsyjy);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return xxsyjys;
    }
}

