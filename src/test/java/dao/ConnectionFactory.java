package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {



    public static Connection getConnection() throws SQLException {
        String server = "localhost";
        String port = "1521";
        String sid = "XE";
        String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
        String userName = "system";
        String password = "Kenzo03012018$";


        return DriverManager.getConnection(url,userName,password);

    }
}
