package Semesterarbeit;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by dieterbiedermann on 27.12.16.
 */
public class DatabaseHandler {

    Connection connection;
    PreparedStatement stmtExists, stmtInsert, stmtUpdate;
    ResultSet resultSet;
    PreparedStatement ps;
    PreparedStatement preparedStatement;
    StringBuilder sb;
    int counter = 0;
    FileImportController fileImportController;

    public DatabaseHandler(FileImportController fileImportController) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/trip_planner_db", "postgres1", "postgres1");

//            stmtExists = connection.prepareStatement("select count(*) cnt from poi where id = ?");
//            stmtInsert = connection.prepareStatement("insert into poi (category, id, latitude, longitude, name) values (?,?,?,?,?)");
//            stmtInsert = connection.prepareStatement("insert into poi (category, id, latitude, longitude, name) values (?,?,?,?,?)");
//            stmtUpdate = connection.prepareStatement("update poi set ? where id = ?");

            this.fileImportController = fileImportController;

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

    public void prepareInsert() {
        StringBuilder build = new StringBuilder("insert into poi2 (category, id, latitude, longitude, name) values ");
        for (int i = 0; i < 1000; i++) {
            build.append("(?, ?, ?, ?, ?)");
            if (i < 999) {
                build.append(", ");
            } else {
                build.append(";");
            }
        }
        try {
            ps = connection.prepareStatement(build.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPoi2(String[] s) {

        try {
            connection.setAutoCommit(false);

            String stmt = "";
            stmt = stmt + "'"+s[0]+"'";
            stmt = stmt + ",'"+s[1]+"'";
            stmt = stmt + ",'"+s[2]+"'";
            stmt = stmt + ",'"+s[3]+"'";
            stmt = stmt + ",'"+s[4]+"'";

            ps.setString(1, s[0]);
            ps.setString(2, s[1]);
            ps.setString(3, s[2]);
            ps.setString(4, s[3]);
            ps.setString(5, s[4]);


            int result = ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized void insertMultiValuePois(ArrayList<String> poiList) {

        try {
            if (connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost/trip_planner_db", "postgres1", "postgres1");
            }
            connection.setAutoCommit(false);

            sb = new StringBuilder();
            sb.append("insert into poi2 (category, id, latitude, longitude, name) values ");
            sb.append("(");

            for (int i = 1; i <= poiList.size(); i++) {
                sb.append("?");
                if (i % 5 == 0) {
                    sb.append("),(");
                } else {
                    sb.append(",");
                }
            }
            if ("(".equals(String.valueOf(sb.charAt(sb.length()-1)))) {
                sb.delete(sb.length()-2,sb.length());
            } else {
                sb.append(")");
            }
            //sb.append(" ON CONFLICT DO UPDATE");
            preparedStatement = connection.prepareStatement(sb.toString());

            int cnt = 0;
            for (String poi:poiList) {
                cnt++;
                preparedStatement.setString(cnt, poi);
            }

            preparedStatement.addBatch();
            counter++;

/*
            if (counter == 500) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
                connection.commit();
                counter = 0;
            }
*/
        } catch (SQLException e) {
/*
            if (connection != null) {
                try {
                    if (!connection.isClosed()) {
                        connection.rollback();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
*/
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
/*
                    if (counter > 0) {
                        preparedStatement.executeBatch();
                        preparedStatement.clearBatch();
                        connection.commit();
                    }
*/
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                    preparedStatement.close();
                    connection.commit();
//                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    fileImportController.addErrorQueue(poiList);
                }
            }
/*
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
*/
        }

    }
}
