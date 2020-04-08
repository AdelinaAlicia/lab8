package lab8;

import java.sql.*;
//inca un pachet DAO cu celelalte controllere
//si in main test ca functioneaza conexiunea
public class Database {
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConn (String username, String password){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:1521/MusicAlbums",
                    username,
                    password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
