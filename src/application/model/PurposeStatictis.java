/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.model;

/**
 *
 * @author PC
 */
public class PurposeStatictis {

    private int total;
    private String purpose;
    private int time;
    private double percent;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PurposeStatictis{");
        sb.append("total=").append(total);
        sb.append(", purpose=").append(purpose);
        sb.append(", time=").append(time);
        sb.append(", percent=").append(percent);
        sb.append('}');
        return sb.toString();
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public PurposeStatictis(int total, String purpose, int time) {
        this.total = total;
        this.purpose = purpose;
        this.time = time;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
