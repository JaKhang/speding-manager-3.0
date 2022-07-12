/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.model.dao;

import application.model.DateSpending;
import application.model.PurposeStatictis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PC
 */
public class PurposeStatictisDAO {
            public List<PurposeStatictis> getByMonth(Date month) {
        Connection connection = DBConnection.connect();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String sql = "SELECT purpose, SUM(spending_money) AS total, COUNT(purpose) AS times FROM Spending WHERE MONTH(date) = MONTH(#" + simpleDateFormat.format(month)
                + "#) AND YEAR(date) = YEAR(#" + simpleDateFormat.format(month) + "#) GROUP BY purpose ORDER BY total DESC";
        PreparedStatement statement = null;
        List<PurposeStatictis> purposeStatictis = new LinkedList<>();
        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int money = result.getInt("total");
                int time = result.getInt("times");
                String purpose = result.getString("purpose");
                purposeStatictis.add(new PurposeStatictis(money, purpose, time));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return purposeStatictis;
    }
}
