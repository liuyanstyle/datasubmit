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

import bean.Hjqk;

public class HjqkDAO {

    public HjqkDAO(){
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

    public void add(Hjqk hjqk) {

        String sql = "insert into hjqk values(null,?,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(1,hjqk.year);
            ps.setString(2, hjqk.category);
            ps.setString(3,hjqk.type);
            ps.setString(6, hjqk.winYear);
            ps.setString(4, hjqk.name);
            ps.setString(5, hjqk.peopelList);
            ps.setString(7,hjqk.unitName);
            ps.setString(8,hjqk.extra);
            ps.setString(9,df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                hjqk.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Hjqk> list() {
        List<Hjqk> hjqks = new ArrayList<Hjqk>();

        String sql = "select * from hjqk order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Hjqk hjqk = new Hjqk();
                int id=rs.getInt(1);
                String year=rs.getString(2);
                String category = rs.getString(3);
                String type= rs.getString(4);
                String name=rs.getString(5);
                String peopelList = rs.getString(6);
                String winYear=rs.getString(7);
                String unitname=rs.getString(8);
                String extra=rs.getString(9);

                hjqk.setYear(year);
                hjqk.setId(id);
                hjqk.setName(name);
                hjqk.setUnitName(unitname);
                hjqk.setCategory(category);
                hjqk.setPeopelList(peopelList);
                hjqk.setWinYear(winYear);
                hjqk.setType(type);
                hjqk.setExtra(extra);

                hjqks.add(hjqk);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return hjqks;
    }
}

