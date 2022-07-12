/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.model.dao;

import application.model.DateSpending;
import application.model.Spending;
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
public class DateSpendingDAO {
        public List<DateSpending> getByMonth(Date month) {
        Connection connection = DBConnection.connect();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String sql = "SELECT date, SUM(spending_money) AS total FROM Spending WHERE MONTH(date) = MONTH(#" + simpleDateFormat.format(month)
                + "#) AND YEAR(date) = YEAR(#" + simpleDateFormat.format(month) + "#) GROUP BY date ORDER BY date ASC";
        PreparedStatement statement = null;
        List<DateSpending> spendings = new LinkedList<>();
        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int money = result.getInt("total");
                Date date = new Date(result.getDate("date").getTime());
                spendings.add(new DateSpending(date, money));
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

        return spendings;
    }
}
