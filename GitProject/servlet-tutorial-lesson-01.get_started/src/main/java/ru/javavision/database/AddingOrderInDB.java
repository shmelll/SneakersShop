package ru.javavision.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AddingOrderInDB {
    private static Statement stmt = null;
    private static Connection connection;

    public static void addOrder(int productId, int userId, int productSize){
        connection = ConnectionActions.openConnection();
        try {
            connection = ConnectionActions.openConnection();
            Statement stmt = connection.createStatement();
            String k = "insert into order (productid, userid, shoesize) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(k);
            ps.setInt(1,productId);
            ps.setInt(2, userId);
            ps.setInt(3, productSize);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionActions.closeConnection(connection);
        }

    }
}
