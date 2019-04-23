package ru.javavision.database;

import java.sql.*;

public class RegistrationWithDB {
    private static Connection connection;
    private static String emailInDb = null;
    public static boolean getRegistration(String email, String password, String phone, Integer postcode, String address ) {
        try {
            connection = ConnectionActions.openConnection();
            Statement stmt = connection.createStatement();
            String sql = "SELECT email FROM user WHERE email='" + email + "'";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            if (rs.next()) {
                emailInDb = rs.getString("email");
            }
            if (emailInDb == null) {
                System.out.println("ADDING");
                String k = "insert into user (password, phone, email, adress, postcode) values (?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(k);
                ps.setString(1, password);
                ps.setString(2, phone);
                ps.setString(3, email);
                ps.setString(4, address);
                ps.setString(5, String.valueOf(postcode));
                ps.execute();
                ps.close();
                //success registration
                return true;
            } else {
                //bad registration
                System.out.println("User " + emailInDb + " is already registered !");
                return false;
            }

        } catch (
                SQLException e) {
            // e.printStackTrace();
            System.err.println("ERROR!!!" + e);
        } finally {
            ConnectionActions.closeConnection(connection);
        }
        return false;
    }
}
