package ru.javavision.database;

import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthorizeWithDB {
    private static Statement stmt = null;
    private static Connection connection;
    private static String emailInDb = null;
    private static String passInDb = null;

    public static boolean getAuth(String uname, String pass) {
        try {
            connection = ConnectionActions.openConnection();
            stmt = connection.createStatement();
            String sqlFindEmail = "SELECT email FROM user WHERE email='" + uname + "'";
            ResultSet rs = stmt.executeQuery(sqlFindEmail);

            if (rs.next()) {      //перевод из resultset в стринг
                emailInDb = rs.getString("email");
                if (emailInDb != null) {                                               // если существует пользователь с таким email
                    String sqlCheckPass = "SELECT password FROM user WHERE email='" + uname + "'";
                    ResultSet rs2 = stmt.executeQuery(sqlCheckPass);
                    if (rs2.next()) {  //перевод из resultset в стринг
                        passInDb = rs2.getString("password");
                    }
                    if (passInDb.equals(pass)) {
                        System.out.println("Success authorization");
                        //TODO add action on success authorization
                        return true;
                    } else {
                        System.out.println(passInDb + "  " + pass);
                        System.out.println("Bad authorization, wrong password");
                        //TODO add action on bad authorization
                        return false;
                    }
                }
            } else {
                System.out.println("Bad authorization, user is not found");
                //TODO add action on bad authorization
                return false;
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionActions.closeConnection(connection);
        }
        return false;
    }
}
