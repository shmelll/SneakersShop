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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String prodName=request.getParameter("productName");
            Integer prodPrice=Integer.parseInt(request.getParameter("productPrice"));
            String prodSize=request.getParameter("size");
            Integer prodId=Integer.parseInt(request.getParameter("productId"));
            Product.setSumPrice(prodPrice);

       //     HttpSession session = request.getSession();
            new Product(prodName,prodPrice,prodSize,prodId);
           // session.setAttribute("Cart", Product.getProductsMap());

         //   Product p =(Product) session.getAttribute("Cart");
         //   System.out.println(p);
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }


        response.sendRedirect("/main");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
