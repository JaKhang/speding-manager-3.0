/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.model;

import application.model.dao.DateSpendingDAO;
import application.model.dao.PurposeStatictisDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 *
 * @author PC
 */
public class StatictisModel {

    public DateSpendingDAO dateSpendingDAO;
    public PurposeStatictisDAO purposeStatictisDAO;

    public StatictisModel() {
        this.dateSpendingDAO = new DateSpendingDAO();
        this.purposeStatictisDAO = new PurposeStatictisDAO();
    }

    public DateSpending getMaxDateSpendingOfMonth(Date date) {
        List<DateSpending> dateSpendings = dateSpendingDAO.getByMonth(date);
        if (dateSpendings.isEmpty()) {
            return new DateSpending(null, 0);
        }
        DateSpending dateSpending = dateSpendings.stream().reduce((t, u) -> {
            return t.getTotal() > u.getTotal() ? t : u;
        }).get();
        return dateSpending;
    }

    public DateSpending getMinDateSpendingOfMonth(Date date) {
        List<DateSpending> dateSpendings = dateSpendingDAO.getByMonth(date);
        if (dateSpendings.isEmpty()) {
            return new DateSpending(null, 0);
        }
        DateSpending dateSpending = dateSpendings.stream().reduce((t, u) -> {
            return t.getTotal() < u.getTotal() ? t : u;
        }).get();
        return dateSpending;
    }

    public int getTotal(Date date) {
        List<DateSpending> dateSpendings = dateSpendingDAO.getByMonth(date);
        return dateSpendings.stream().map(dateSpending -> {
            return dateSpending.getTotal();
        }).reduce(0, Integer::sum);
    }

    public int getAverage(Date date) {
        var calendar = new GregorianCalendar();
        calendar.setTime(date);
        int days = calendar.getMaximum(Calendar.DATE);
        var calendar1 = new GregorianCalendar();
        if (calendar.get(Calendar.YEAR) == calendar1.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) == calendar1.get(Calendar.MONTH)) {
            days = calendar1.get(Calendar.DATE);
        }
        List<DateSpending> dateSpendings = dateSpendingDAO.getByMonth(date);
        if (dateSpendings.isEmpty()) {
            return 0;
        }
        return dateSpendings.stream().map(dateSpending -> {
            return dateSpending.getTotal();
        }).reduce(0, Integer::sum) / days;
    }

    public List<Integer> getLineChartData(Date month) {
        List<Integer> data = new LinkedList<>();
        Queue<DateSpending> dateSpendings = new ConcurrentLinkedDeque<>(dateSpendingDAO.getByMonth(month));
        if(dateSpendings.isEmpty())
            return data;
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(month);
        int amountDate = calendar.getMaximum(Calendar.DATE);
        calendar.setTime(month);
        var calendar1 = new GregorianCalendar();
        boolean isLimit = calendar.get(Calendar.YEAR) == calendar1.get(Calendar.YEAR) 
                && calendar.get(Calendar.MONTH) == calendar1.get(Calendar.MONTH);
        for (int i = 1; i <= amountDate; i++) {
            if (!dateSpendings.isEmpty()) {
                calendar.setTime(dateSpendings.peek().getDate());
                if (calendar.get(Calendar.DATE) == i) {
                    data.add(dateSpendings.poll().getTotal());
                } else {
                    data.add(0);
                }
            } else if(isLimit)
                return data;
            else 
                data.add(0);

        }
        return data;
    }

    public List<PurposeStatictis> getPurposeSatictis(Date month){
        int total = getTotal(month);
        if(total == 0)
            return new LinkedList<>();
        List<PurposeStatictis> purposeStatictis = purposeStatictisDAO.getByMonth(month);
        for (PurposeStatictis e : purposeStatictis) {
            e.setPercent(e.getTotal()/(double)total);
        }
        return purposeStatictis;
    }
}
