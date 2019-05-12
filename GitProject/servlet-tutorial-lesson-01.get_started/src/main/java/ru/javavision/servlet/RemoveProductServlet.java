package ru.javavision.servlet;

import ru.javavision.Models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveProductServlet")
public class RemoveProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product prod =(Product)Product.getProductsList().get(Integer.parseInt(request.getParameter("prodNum")));
        Product.setSumPriceRemove(prod.getPrice());  //for change sumprice on main page

        Product.removeProduct(Integer.parseInt(request.getParameter("prodNum")));
            response.sendRedirect("/cart");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
