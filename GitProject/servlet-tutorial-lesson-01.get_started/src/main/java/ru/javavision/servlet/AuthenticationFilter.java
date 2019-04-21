package ru.javavision.servlet;

import ru.javavision.database.ConnectionActions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "AuthenticationFilter")
public class AuthenticationFilter extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = ConnectionActions.openConnection();
        String emailInDb = null;
        String passInDb = null;

        String uname = (String) request.getParameter("email");
        String pass = (String) request.getParameter("pass");

        Statement stmt = null;
        try {
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
                        response.sendRedirect("/main");
                        System.out.println("Success authorization");
                        //TODO add action on success authorization
                    } else {
                        System.out.println(passInDb + "  " + pass);
                        System.out.println("Bad authorization, wrong password");
                        //TODO add action on success authorization
                    }
                }
            } else {
                System.out.println("Bad authorization, user is not found");
                //TODO add action on success authorization
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionActions.closeConnection(connection);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
