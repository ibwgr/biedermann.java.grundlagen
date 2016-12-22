package Uebungen.ByceCo;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by dieterbiedermann on 06.12.16.
 */
public class LeseTeilenummerPrepared {

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres1", "postgres1");
            Statement statement = connection.createStatement();

            Scanner s = new Scanner(System.in);
            System.out.print("TNR -> ");
            int tnr = s.nextInt();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM artikel where tnr = ?"
            );
            preparedStatement.setInt(1, tnr);

            ResultSet resultset = preparedStatement.executeQuery();
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
