package ru.javavision.servlet;

import com.mysql.cj.Session;
import ru.javavision.Models.Product;
import ru.javavision.database.AddingOrderInDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("authorized")==null) {
            response.sendRedirect("authorization");
        }
        else {
            List prods = Product.getProductsList();
            Integer userid =(Integer)session.getAttribute("userID");
            for(int i=0; i<prods.size(); i++){
                Product product= (Product) prods.get(i);
                AddingOrderInDB.addOrder(product.getId(),userid, Integer.parseInt(((Product) prods.get(i)).getAvaibleSizes()));
            }
            response.sendRedirect("/main");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
