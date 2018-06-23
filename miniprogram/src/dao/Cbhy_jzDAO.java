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

import bean.Cbhy_jz;

public class Cbhy_jzDAO {

    public Cbhy_jzDAO(){
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

    public void add(Cbhy_jz cbhy_jz) {

        String sql = "insert into cbhy_jz values(null,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(1,cbhy_jz.year);
            ps.setString(2, cbhy_jz.unitname);
            ps.setString(3,cbhy_jz.time);
            ps.setInt(6, cbhy_jz.peopleNum);
            ps.setString(5, cbhy_jz.location);
            ps.setString(4, cbhy_jz.organizer);
            ps.setString(7,cbhy_jz.peopelList);
            ps.setString(8,df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                cbhy_jz.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Cbhy_jz> list() {
        List<Cbhy_jz> cbhy_jzs = new ArrayList<Cbhy_jz>();

        String sql = "select * from cbhy_jz order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cbhy_jz cbhy_jz = new Cbhy_jz();
                int id=rs.getInt(1);
                String year=rs.getString(2);
                String name = rs.getString(3);
                String date= rs.getString(4);
                String site=rs.getString(5);
                int peopleNum = rs.getInt(6);
                String peopleList=rs.getString(7);

                cbhy_jz.setYear(year);
                cbhy_jz.setId(id);
                cbhy_jz.setUnitname(name);
                cbhy_jz.setTime(date);
                cbhy_jz.setLocation(site);
                cbhy_jz.setPeopelList(peopleList);
                cbhy_jz.setPeopleNum(peopleNum);

                cbhy_jzs.add(cbhy_jz);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return cbhy_jzs;
    }
}

