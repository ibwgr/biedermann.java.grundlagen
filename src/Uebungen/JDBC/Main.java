package Uebungen.JDBC;

import java.sql.*;

/**
 * Created by dieterbiedermann on 06.12.16.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres1", "postgres1");

            Statement statement = connection.createStatement();

            String land_iso = "LI";

            // execute
            statement.execute("drop table if exists laender");
            statement.execute("create table laender (land_iso varchar(2), land_name varchar(100))");
            statement.executeUpdate(" INSERT INTO laender VALUES('DE','Deutschland')");
            statement.executeUpdate(" INSERT INTO laender VALUES('LI','Liechtenstein')");

            // executeQuery
            ResultSet resultset = statement.executeQuery("SELECT land_name FROM laender");
            while (resultset.next()) {
                System.out.println(resultset.getString("land_name"));
            }
            resultset.close();

            resultset = statement.executeQuery("SELECT count(*) anzahl FROM laender");
            while (resultset.next()) {
                System.out.println(resultset.getString("anzahl"));
            }
            resultset.close();

            resultset = statement.executeQuery("SELECT land_name FROM laender where land_iso = '"+land_iso+"'");
            while (resultset.next()) {
                System.out.println(resultset.getString("land_name"));
            }
            resultset.close();

            // PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select land_name from laender where land_iso = ?"
            );
            preparedStatement.setString(1, land_iso);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                System.out.println(resultset.getString("land_name"));
            }
            resultset.close();
            preparedStatement.setString(1, "DE");
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                System.out.println(resultset.getString("land_name"));
            }
            resultset.close();

            // close
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Hello world");
    }
}
