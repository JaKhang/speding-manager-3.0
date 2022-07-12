package application.model.dao;

import application.model.Spending;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpendingDAO {

    public List<Spending> getAll() {
        Connection connection = DBConnection.connect();
        String sql = "SELECT * FROM Spending ORDER BY date DESC";
        List<Spending> spendings = new LinkedList<Spending>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                int money = result.getInt("spending_money");
                String purpose = result.getString("purpose");
                String comment = result.getString("comment");
                Date date = result.getDate("date");
                spendings.add(new Spending(id, date, money, purpose, comment));
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

    public List<Spending> getByDate(Date date) {
        Connection connection = DBConnection.connect();
        String sql = "SELECT * FROM Spending WHERE date = ?";
        List<Spending> spendings = new LinkedList<Spending>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(date.getTime()));
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                int money = result.getInt("spending_money");
                String purpose = result.getString("purpose");
                String comment = result.getString("comment");
                spendings.add(new Spending(id, date, money, purpose, comment));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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

    public List<Calendar> getAllDate() {
        Connection connection = DBConnection.connect();
        String sql = "SELECT date FROM Spending GROUP BY date";
        List<Calendar> dates = new LinkedList<Calendar>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Date date = new Date(result.getDate("date").getTime());
                Calendar date1 = Calendar.getInstance();
                date1.setTime(date);
                dates.add(date1);

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
        return dates;
    }

    public List<Spending> getByMonth(Date month) {
        Connection connection = DBConnection.connect();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String sql = "SELECT * FROM Spending WHERE MONTH(date) = MONTH(#" + simpleDateFormat.format(month)
                + "#) AND YEAR(date) = YEAR(#" + simpleDateFormat.format(month) + "#) ORDER BY date DESC";
        PreparedStatement statement = null;
        List<Spending> spendings = new LinkedList<>();
        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                int money = result.getInt("spending_money");
                String purpose = result.getString("purpose");
                String comment = result.getString("comment");
                Date date = new Date(result.getDate("date").getTime());
                spendings.add(new Spending(id, date, money, purpose, comment));
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

    public boolean addSpending(Spending spending) {
        Connection connection = DBConnection.connect();
        String sql = "INSERT INTO Spending(id, spending_money, purpose, comment, date) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        int result = 0;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, spending.getId());
            statement.setInt(2, spending.getMoney());
            statement.setString(3, spending.getPupose());
            statement.setString(4, spending.getComment());
            statement.setDate(5, new java.sql.Date(spending.getDate().getTime()));
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SpendingDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return result > 0;
    }

    public boolean removeSpending(int id) {
        Connection connection = DBConnection.connect();
        String sql = "DELETE FROM Spending WHERE id = ?";
        PreparedStatement statement = null;
        int result = 0;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SpendingDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return result > 0;
    }

    public Spending getById(int id) {
        Connection connection = DBConnection.connect();
        String sql = "SELECT * FROM Spending WHERE id = ?";
        PreparedStatement statement = null;
        Spending spending = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int money = result.getInt("spending_money");
                String purpose = result.getString("purpose");
                String comment = result.getString("comment");
                Date date = result.getDate("date");
                spending = new Spending(id, date, money, purpose, comment);
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
        return spending;
    }

    public boolean updateSpending(Spending spending) {
        Connection connection = DBConnection.connect();
        String sql = "UPDATE Spending SET spending_money = ?, purpose = ?, comment = ?, date = ? WHERE id = ?";
        PreparedStatement statement = null;
        int result = 0;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(5, spending.getId());
            statement.setInt(1, spending.getMoney());
            statement.setString(2, spending.getPupose());
            statement.setString(3, spending.getComment());
            statement.setDate(4, new java.sql.Date(spending.getDate().getTime()));
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SpendingDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return result > 0;
    }

    public List<String> getAllPurpose() {
        Connection connection = DBConnection.connect();
        String sql = "SELECT purpose FROM Purpose";
        List<String> purposes = new LinkedList<String>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                purposes.add(result.getString("purpose"));
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
        return purposes;
    }
}
