/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.controller;

import application.model.StatictisModel;
import application.view.pane.StatictisPane;
import java.util.List;

/**
 *
 * @author PC
 */
public class StatictisController {

    private StatictisPane statictisPane;
    private StatictisModel model;

    public StatictisController() {
        this.model = new StatictisModel();
    }

    private void renderLineChart() {
        List<Integer> data = model.getLineChartData(statictisPane.getSelectedMoth());
        statictisPane.setChartData(data);
    }

    private void renderMax() {
        statictisPane.showMaxDate(model.getMaxDateSpendingOfMonth(statictisPane.getSelectedMoth()));
    }

    private void renderMin() {
        statictisPane.showMinDate(model.getMinDateSpendingOfMonth(statictisPane.getSelectedMoth()));
    }

    private void renderTotal() {
        statictisPane.showTotal(model.getTotal(statictisPane.getSelectedMoth()));
    }

    private void renderAverage() {
        statictisPane.showAverage(model.getAverage(statictisPane.getSelectedMoth()));
    }

    public void render() {
        renderLineChart();
        renderMax();
        renderMin();
        renderTotal();
        renderAverage();
        renderTable();
    }

    public void setStatictisPane(StatictisPane statictisPane) {
        this.statictisPane = statictisPane;
    }
    
    public void renderTable(){
        statictisPane.showTableData(model.getPurposeSatictis(statictisPane.getSelectedMoth()));
    }

}
