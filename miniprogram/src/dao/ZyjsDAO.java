package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Zyjs;

public class ZyjsDAO {

    public ZyjsDAO(){
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

    public void add(Zyjs zyjs) {

        String sql = "insert into zyjs values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

<<<<<<< HEAD


=======
>>>>>>> 47a8143bb6fe0c953270471544ef19fb139754a5
            ps.setString(1, zyjs.year);
            ps.setString(2, zyjs.category);
            ps.setString(3, zyjs.type);
            ps.setInt(4, zyjs.purchaseCategoryNum);
            ps.setInt(5, zyjs.purchaseNum);
            ps.setString(6, zyjs.money);
            ps.setInt(7, zyjs.thisyearAdd);
            ps.setInt(8, zyjs.thisyearRefill);
            ps.setInt(9, zyjs.logout);
            ps.setInt(10, zyjs.formeryearSum);
            ps.setInt(11, zyjs.allSum);
            ps.setString(12, zyjs.date);

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                zyjs.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Zyjs> list() {
        List<Zyjs> zyjss = new ArrayList<Zyjs>();

        String sql = "select * from zyjs order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Zyjs zyjs = new Zyjs();

                zyjs.setId(rs.getInt(1));
                zyjs.setYear(rs.getString(2));
                zyjs.setCategory(rs.getString(3));
                zyjs.setType(rs.getString(4));
                zyjs.setPurchaseCategoryNum(rs.getInt(5));
                zyjs.setPurchaseNum(rs.getInt(6));
                zyjs.setMoney(rs.getString(7));
                zyjs.setThisyearAdd(rs.getInt(8));
                zyjs.setThisyearRefill(rs.getInt(9));
                zyjs.setLogout(rs.getInt(10));
                zyjs.setFormeryearSum(rs.getInt(11));
                zyjs.setAllSum(rs.getInt(12));
                zyjs.setDate(rs.getString(13));


                zyjss.add(zyjs);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return zyjss;
    }
}
