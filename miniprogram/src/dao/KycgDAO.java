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

import bean.Kycg;

public class KycgDAO {

    public KycgDAO(){
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

    public void add(Kycg kycg) {

        String sql = "insert into kycg values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(1, kycg.year);
            ps.setString(4, kycg.firstAuthor);
            ps.setString(2, kycg.name);
            ps.setString(3,kycg.type);
            ps.setString(5, kycg.otherAuthor);
            ps.setString(6, kycg.source);
            ps.setString(7, kycg.form);
            ps.setString(8, kycg.range);
            ps.setString(9, kycg.isTranslate);
            ps.setString(10, kycg.studyCategory);
            ps.setString(11, kycg.situation);
            ps.setString(12, kycg.subject);
            ps.setString(13, kycg.unitName);
            ps.setString(14,kycg.publishTime);
            ps.setString(15,kycg.issbn);
            ps.setString(16,kycg.category);
            ps.setString(17,kycg.extra);
            ps.setString(18,df.format(day));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                kycg.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }




    public List<Kycg> list() {
        List<Kycg> kycgs = new ArrayList<Kycg>();

        String sql = "select * from kycg order by 序号";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Kycg kycg = new Kycg();

                kycg.setId(rs.getInt(1));
                kycg.setYear(rs.getString(2));
                kycg.setName(rs.getString(3));
                kycg.setType(rs.getString(4));
                kycg.setFirstAuthor(rs.getString(5));
                kycg.setOtherAuthor(rs.getString(6));
                kycg.setSource(rs.getString(7));
                kycg.setForm(rs.getString(8));
                kycg.setRange(rs.getString(9));
                kycg.setIsTranslate(rs.getString(10));
                kycg.setStudyCategory(rs.getString(11));
                kycg.setSituation(rs.getString(12));
                kycg.setSubject(rs.getString(13));
                kycg.setUnitName(rs.getString(14));
                kycg.setPublishTime(rs.getString(15));
                kycg.setIssbn(rs.getString(16));
                kycg.setCategory(rs.getString(17));
                kycg.setExtra(rs.getString(18));



                kycgs.add(kycg);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return kycgs;
    }
}
