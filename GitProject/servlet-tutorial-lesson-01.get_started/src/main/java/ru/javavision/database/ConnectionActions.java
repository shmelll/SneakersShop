package ru.javavision.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionActions {
    private static final String URL="jdbc:mysql://localhost:3306/sneakersshop?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static Connection connection;
    private static Driver driver;

    public static Connection openConnection()
    {
        try {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if(!connection.isClosed()){
                System.out.println("Connection successful");
            }
        } catch (SQLException e) {
            System.err.println(e);

        }
        return connection;
    }

    public static void closeConnection(Connection c)
    {
        try {
            c.close();
            if(c.isClosed())
            {
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
