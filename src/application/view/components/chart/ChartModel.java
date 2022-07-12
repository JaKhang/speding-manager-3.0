/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.view.components.chart;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ChartModel {
    private List<Integer> data;

    public ChartModel() {
        this.data = new LinkedList<>();
    }
    
    public int count(){
        return data.size();
    }
    
    public int getMaxValue(){
        return data.stream().map((t) -> {
            return t;
        }).reduce(0, Integer::max);
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
    
    
    
    
    
    
    
    
    
}
