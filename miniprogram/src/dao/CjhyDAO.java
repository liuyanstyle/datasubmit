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

<<<<<<< HEAD
        String sql = "insert into cjhy values(null,?,?,?,?,?,?)";
=======
        String sql = "insert into cjhy values(null,?,?,?,?,?)";
>>>>>>> 47a8143bb6fe0c953270471544ef19fb139754a5
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

<<<<<<< HEAD
            ps.setString(1,cjhy.year);
            ps.setString(2, cjhy.name);
            ps.setString(3, cjhy.date);
            ps.setString(4, cjhy.site);
            ps.setString(5, cjhy.peopleList);
            ps.setString(6,df.format(day));
=======
            ps.setString(1, cjhy.name);
            ps.setString(2, cjhy.date);
            ps.setString(3, cjhy.site);
            ps.setString(4, cjhy.peopleList);
            ps.setString(5,df.format(day));
>>>>>>> 47a8143bb6fe0c953270471544ef19fb139754a5

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
<<<<<<< HEAD
                String year=rs.getString(2);
                int id = rs.getInt(1);
                String name = rs.getString(3);
                String date= rs.getString(4);
                String site=rs.getString(5);
                String peopleList = rs.getString(6);

                cjhy.setYear(year);
=======
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String date= rs.getString(3);
                String site=rs.getString(4);
                String peopleList = rs.getString(5);

>>>>>>> 47a8143bb6fe0c953270471544ef19fb139754a5
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

