package ru.javavision.servlet;

//import com.mysql.fabric.jdbc.FabricMySQLDriver;

import ru.javavision.database.ConnectionActions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("registrationForm");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionActions.openConnection();

        String email =(String) request.getParameter("email");
        String password =(String) request.getParameter("password");
        String phone =(String) request.getParameter("phone");
        String postcode =(String) request.getParameter("postcode");
        String address =(String) request.getParameter("address");
        response.sendRedirect("/main");

        try
        {
         //   Statement statement = connection.createStatement();
         //   statement.execute("INSERT INTO user(password, phone, email, adress, postcode) VALUES("+password+","+phone+","+email+","+address+","+postcode+");");

            String k="insert into user (password, phone, email, adress, postcode) values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(k);
            ps.setString(1, password);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, postcode);
            ps.execute();
            ps.close();

        }
        catch (SQLException e)
        {
           // e.printStackTrace();
            System.err.println(e);
        }
        finally {
            ConnectionActions.closeConnection(connection);
        }
    }
}
