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

import bean.Kjcxcscy;

public class KjcxcscyDAO {

    public KjcxcscyDAO(){
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

    public void add(Kjcxcscy kjcscscy) {

        String sql = "insert into kjcxcscy values(null,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(1, kjcscscy.year);
            ps.setInt(2, kjcscscy.cxNum);
            ps.setInt(3, kjcscscy.homeCXNum);
            ps.setInt(4, kjcscscy.cscyNum);
            ps.setString(5,df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                kjcscscy.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Kjcxcscy> list() {
        List<Kjcxcscy> kjcscscys = new ArrayList<Kjcxcscy>();

        String sql = "select * from kjcxcscy order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Kjcxcscy kjcscscy = new Kjcxcscy();
                int id = rs.getInt(1);
                String year = rs.getString(2);
                int cxNum = rs.getInt(3);
                int homeCXNum = rs.getInt(4);
                int cscyNum = rs.getInt(5);

                kjcscscy.setId(id);
                kjcscscy.setCscyNum(cscyNum);
                kjcscscy.setYear(year);
                kjcscscy.setCxNum(cxNum);
                kjcscscy.setHomeCXNum(homeCXNum);


                kjcscscys.add(kjcscscy);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return kjcscscys;
    }
}

