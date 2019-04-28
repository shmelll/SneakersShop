package ru.javavision.database;

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
    static ResultSet rs = null;
    static List<String> productNames = new ArrayList<>();
    static List<String> productPrices = new ArrayList<>();
    // static List<String> picturesId = new ArrayList<>();
    static List<String> productId = new ArrayList<>();
    static Map<Integer, List> productQuanSize = new HashMap<Integer, List>();


    public static void fillLists() throws SQLException {
        try {
            connection = ConnectionActions.openConnection();
            stmt = connection.createStatement();

            String sqlFindNames = "SELECT productname, productid FROM product";
            rs = stmt.executeQuery(sqlFindNames);

            while (rs.next()) {
                productNames.add(rs.getString("productname"));
                productId.add(rs.getString("productid"));
            }

            String sqlFindPrices = "SELECT productprice FROM product";
            rs = stmt.executeQuery(sqlFindPrices);
            while (rs.next()) {
                productPrices.add(rs.getString("productprice"));
            }

            // SELECT size from stock s  INNER JOIN product p ON s.productid = p.productid WHERE (s.productid=3) AND (quantity = 1)   --- запрос для получеия доступных размеров
            for (int i = 0; i < productId.size(); i++) {
                String sqlFindQuantitySize = "SELECT size from stock s  INNER JOIN product p ON s.productid = p.productid WHERE (s.productid=" + productId.get(i) + ") AND (quantity = 1)";
                rs = stmt.executeQuery(sqlFindQuantitySize);
                List a = new ArrayList<>();
                while (rs.next()) {
                    a.add(Integer.parseInt(rs.getString("size")));
                }
                productQuanSize.put(i, a);
            }

        } catch (SQLException e) {
            //   e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            ConnectionActions.closeConnection(connection);
        }
    }

    public static String writeName(int countNames) {
        return productNames.get(countNames);
    }

    public static String writePrice(int countPrices) {
        return productPrices.get(countPrices);
    }


    public static String writeQuantitySize(int countSize) {
        String s1 = "";
        List q = productQuanSize.get(countSize);

        for (int i = 0; i < q.size(); i++) {
            s1 +=" "+ q.get(i);
        }
        System.out.println(s1);
        return s1;
    }


    public static String getProductidInDB(int num) {
        return productId.get(num);
    }


}
