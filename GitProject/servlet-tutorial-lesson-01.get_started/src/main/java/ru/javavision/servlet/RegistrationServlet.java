package ru.javavision.servlet;

//import com.mysql.fabric.jdbc.FabricMySQLDriver;

import ru.javavision.database.ConnectionActions;
import ru.javavision.database.Products;
import ru.javavision.database.RegistrationWithDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("authorized")==null) {
            response.sendRedirect("registrationForm");
        }
        else if(!(boolean)session.getAttribute("authorized")){
            response.sendRedirect("registrationForm");
        }
        else {
            response.sendRedirect("/main");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email =(String) request.getParameter("email");
        String password =(String) request.getParameter("password");
        String phone =(String) request.getParameter("phone");
        Integer postcode = Integer.valueOf((String) request.getParameter("postcode"));
        String address =(String) request.getParameter("address");

        if(RegistrationWithDB.getRegistration(email,password,phone,postcode,address)){
            response.sendRedirect("authorization"); //success
        }
        else {response.sendRedirect("/registration");} //bad
    }
}
