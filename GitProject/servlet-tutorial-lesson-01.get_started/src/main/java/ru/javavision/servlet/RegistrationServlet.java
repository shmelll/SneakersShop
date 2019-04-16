package ru.javavision.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("registrationForm");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname =(String) request.getParameter("email");
        String password =(String) request.getParameter("password");
        String phone =(String) request.getParameter("phone");
        String postcode =(String) request.getParameter("postcode");
        String address =(String) request.getParameter("address");
        response.sendRedirect("/main");
    }
}
