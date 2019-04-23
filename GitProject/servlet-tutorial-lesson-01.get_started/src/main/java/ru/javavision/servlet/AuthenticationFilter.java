package ru.javavision.servlet;

import com.mysql.cj.Session;
import ru.javavision.database.AuthorizeWithDB;
import ru.javavision.database.ConnectionActions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "AuthenticationFilter")
public class AuthenticationFilter extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("authorized", false);

        String uname = (String) request.getParameter("email");
        String pass = (String) request.getParameter("pass");
        if(AuthorizeWithDB.getAuth(uname, pass)){
            session.setAttribute("authorized", true);
            response.sendRedirect("/main");
        }
        else {response.sendRedirect("/main");}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
