package application.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class DBConnection {

    /**
     * @return
     */
    public static Connection connect() {
        String url = "jdbc:ucanaccess://datasrc/data.accdb";
        try {
            Connection connection = DriverManager.getConnection(url);

            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
