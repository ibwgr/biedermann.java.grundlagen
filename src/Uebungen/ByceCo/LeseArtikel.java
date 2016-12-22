package Uebungen.ByceCo;

import java.sql.*;

/**
 * Created by dieterbiedermann on 06.12.16.
 */
public class LeseArtikel {

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres1", "postgres1");
            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("SELECT * FROM artikel");
            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "\t" + resultset.getString(2)
                        + "\t\t\t\t" + resultset.getString(3)
                        + "\t\t" + resultset.getString(4)
                        + "\t" + resultset.getString(5)
                        + "\t" + resultset.getString(6)
                );
            }
            resultset.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}