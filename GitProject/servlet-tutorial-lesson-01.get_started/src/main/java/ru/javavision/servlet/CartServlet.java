package ru.javavision.servlet;

import ru.javavision.database.Products;
import ru.javavision.Models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String prodName=request.getParameter("productName");
            Integer prodPrice=Integer.parseInt(request.getParameter("productPrice"));
            String prodSize=request.getParameter("productSize");
            Integer prodId=Integer.parseInt(request.getParameter("productId"));
            Product.setSumPrice(prodPrice);
            //Product product = new Product(prodName,prodPrice,prodSize,prodId);

            HttpSession session = request.getSession();
            session.setAttribute("Cart", new Product(prodName,prodPrice,prodSize,prodId));
            Product p =(Product) session.getAttribute("Cart");
            //System.out.println(p);
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }


        response.sendRedirect("/main");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
