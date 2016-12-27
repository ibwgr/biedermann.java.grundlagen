package Semesterarbeit;

import java.sql.*;

/**
 * Created by dieterbiedermann on 27.12.16.
 */
public class DatabaseHandler {

    Connection connection;
    PreparedStatement stmtExists, stmtInsert, stmtUpdate;
    ResultSet resultSet;

    public DatabaseHandler() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/trip_planner_db", "postgres1", "postgres1");

            stmtExists = connection.prepareStatement("select count(*) cnt from poi where id = ?");
            stmtInsert = connection.prepareStatement("insert into poi (category, id, latitude, longitude, name) values (?,?,?,?,?)");
//            stmtInsert = connection.prepareStatement("insert into poi (category, id, latitude, longitude, name) values (?,?,?,?,?)");
            stmtUpdate = connection.prepareStatement("update poi set ? where id = ?");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean exists(String table, String id) {
        try {
            stmtExists.setString(1, id);
            resultSet = stmtExists.executeQuery();
            if (resultSet.next()) {
                int cnt = resultSet.getInt("cnt");
                System.out.println(cnt);
                if (cnt > 0) {
                    return true;
                } else {
                    return false;
                }
            }
            resultSet.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void insertPoi(String[] s) {
        try {
            String stmt = "";
            stmt = stmt + "'"+s[0]+"'";
            stmt = stmt + ",'"+s[1]+"'";
            stmt = stmt + ",'"+s[2]+"'";
            stmt = stmt + ",'"+s[3]+"'";
            stmt = stmt + ",'"+s[4]+"'";

            System.out.println(stmt);
            stmtInsert.setString(1, s[0]);
            stmtInsert.setString(2, s[1]);
            stmtInsert.setString(3, s[2]);
            stmtInsert.setString(4, s[3]);
            stmtInsert.setString(5, s[4]);
            stmtInsert.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
