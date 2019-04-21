package ru.javavision.servlet;

//import com.mysql.fabric.jdbc.FabricMySQLDriver;

import ru.javavision.database.ConnectionActions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
        String emailInDb = null;

        String email =(String) request.getParameter("email");
        String password =(String) request.getParameter("password");
        String phone =(String) request.getParameter("phone");
        String postcode =(String) request.getParameter("postcode");
        String address =(String) request.getParameter("address");

        try
        {
            Statement stmt = connection.createStatement();
            String sql = "SELECT email FROM user WHERE email='"+email+"'";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            if(rs.next()){
                emailInDb = rs.getString("email");
            }
            if(emailInDb==null) {
                System.out.println("ADDING");
                String k = "insert into user (password, phone, email, adress, postcode) values (?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(k);
                ps.setString(1, password);
                ps.setString(2, phone);
                ps.setString(3, email);
                ps.setString(4, address);
                ps.setString(5, postcode);
                ps.execute();
                ps.close();
                response.sendRedirect("/main");
            }
            else {
                response.sendRedirect("/registration");
                                                            //TODO make the code under work
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User with this email is already registered !');");
                out.println("</script>");

                System.out.println("User " +emailInDb+" is already registered !");

            }

        }
        catch (SQLException e)
        {
           // e.printStackTrace();
            System.err.println("ERROR!!!"+e);
        }
        finally {
            ConnectionActions.closeConnection(connection);
        }
    }
}
