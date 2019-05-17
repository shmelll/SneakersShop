package ru.javavision.database;

import ru.javavision.Models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Products {
    private static Connection connection = null;
    private static Statement stmt = null;
    private static Statement stmt2 = null;
    static ResultSet rsSizes = null;
    static ResultSet rsNamesWithId = null;

    static List<Product> productsList = new ArrayList<>();


    public static void fillLists() throws SQLException {
        try {
            connection = ConnectionActions.openConnection();
            stmt = connection.createStatement();
            stmt2 = connection.createStatement();

            String sqlFindNames = "SELECT productname, productid, productprice FROM product";
            rsNamesWithId = stmt.executeQuery(sqlFindNames);
            while (rsNamesWithId.next()) {

                String sqlFindQuantitySize = "SELECT size FROM stock s  INNER JOIN product p ON s.productid = p.productid WHERE (s.productid=" + rsNamesWithId.getString("productid") + ") AND (quantity = 1)";
                rsSizes = stmt2.executeQuery(sqlFindQuantitySize);
                List<Integer> Sizes = new ArrayList();
                while (rsSizes.next()){
                    Sizes.add(Integer.parseInt(rsSizes.getString("size")));
                }
                productsList.add(new Product(rsNamesWithId.getString("productname"),
                                            Integer.parseInt(rsNamesWithId.getString("productprice")),
                                            null,
                                            rsNamesWithId.getInt("productid"),
                                            Sizes));
            }

        } catch (SQLException e) {
            //   e.printStackTrace();
        } finally {
            if (rsSizes != null) {
                rsSizes.close();
            }
            if(rsNamesWithId!=null){
                rsNamesWithId.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            ConnectionActions.closeConnection(connection);
        }
    }

    public static String writeName(int countNames) {

        return productsList.get(countNames).getName();
    }

    public static String writePrice(int countPrices) {
        return Integer.toString(productsList.get(countPrices).getPrice());
    }


    public static List<Integer> getSizesList(int c) {

        return productsList.get(c).getAllSizes();
    }


    public static String getProductidInDB(int num) {
        return Integer.toString(productsList.get(num).getId());
    }

}
