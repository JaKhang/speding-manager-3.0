package application.view.components.datepicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SelectedDate {

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public SelectedDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public SelectedDate() {
    }

    public SelectedDate getNextDate() {
        var calendar = new GregorianCalendar(day, month - 1, year);
        int day = this.day + 1;
        int month = this.month;
        int year = this.year;

        if (day > calendar.getMaximum(Calendar.DATE)) {
            day = 1;
            month++;
        }
        if (month > 12) {
            month = 1;
            year++;
        }
        return new SelectedDate(day, month, year);
    }

    public SelectedDate getPreviousDate() {
        int day = this.day - 1;
        int month = this.month;
        int year = this.year;

        if (day < 1) {
            var calendar = new GregorianCalendar(this.day, this.month - 2, this.year);
            day = calendar.getMaximum(Calendar.DATE);
            month--;
        }
        if (month < 1) {
            month = 12;
            year--;
        }
        return new SelectedDate(day, month, year);

    }

    public SelectedDate getNextMonth() {
        int day = this.day;
        int month = this.month + 1;
        int year = this.year;
        if (month > 12) {
            month = 1;
            year++;
        }
        return new SelectedDate(day, month, year);
    }

    public SelectedDate getPreviousMonth() {
        int day = this.day;
        int month = this.month - 1;
        int year = this.year;
        if (month < 1) {
            month = 12;
            year--;
        }
        return new SelectedDate(day, month, year);
    }

    private int day;
    private int month;
    private int year;
}
