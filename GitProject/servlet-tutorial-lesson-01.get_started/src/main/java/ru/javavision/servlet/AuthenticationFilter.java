package ru.javavision.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AuthenticationFilter")
public class AuthenticationFilter extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname =(String) request.getParameter("email");
        String pass =(String) request.getParameter("pass");
        if (uname.equals("Dima") && pass.equals("123")) {
            response.sendRedirect("/main");
        } else {
            response.sendRedirect("/registration");
        }

    }
}
