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

import bean.Cjhy;

public class CjhyDAO {

    public CjhyDAO(){
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

    public void add(Cjhy cjhy) {

        String sql = "insert into cjhy values(null,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(1, cjhy.name);
            ps.setString(2, cjhy.date);
            ps.setString(3, cjhy.site);
            ps.setString(4, cjhy.peopleList);
            ps.setString(5,df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                cjhy.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Cjhy> list() {
        List<Cjhy> cjhys = new ArrayList<Cjhy>();

        String sql = "select * from cjhy order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cjhy cjhy = new Cjhy();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String date= rs.getString(3);
                String site=rs.getString(4);
                String peopleList = rs.getString(5);

                cjhy.setId(id);
                cjhy.setName(name);
                cjhy.setDate(date);
                cjhy.setSite(site);
                cjhy.setPeopleList(peopleList);

                cjhys.add(cjhy);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return cjhys;
    }
}

