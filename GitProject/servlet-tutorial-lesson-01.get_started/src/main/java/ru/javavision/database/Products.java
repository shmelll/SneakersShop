package ru.javavision.database;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Products {
    private static Connection connection;
    private static Statement stmt = null;
    private static int countNames = -1;
    private static int countPrices = -1;
    static List<String> productNames = new ArrayList<>();
    static List<String> productPrices = new ArrayList<>();
    static List<String> picturesId = new ArrayList<>();

    public static void fillLists() {
        try {
            connection = ConnectionActions.openConnection();
            stmt = connection.createStatement();

            String sqlFindNames = "SELECT productname FROM product";
            ResultSet rs = stmt.executeQuery(sqlFindNames);
            while (rs.next()) {
                productNames.add(rs.getString("productname"));
            }
            rs.close();

            String sqlFindPrices = "SELECT productprice FROM product";
            rs = stmt.executeQuery(sqlFindPrices);
            while (rs.next()) {
                productPrices.add(rs.getString("productprice"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionActions.closeConnection(connection);
        }
    }

    public static String writeName()
    {
        countNames++;
        return productNames.get(countNames);
    }
    public static String writePrice(){
        countPrices++;
        return productPrices.get(countPrices);
    }


}
