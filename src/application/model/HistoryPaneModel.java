/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.model;

import application.model.dao.SpendingDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class HistoryPaneModel {
       private SpendingDAO spendingDAO;

    public HistoryPaneModel() {
        this.spendingDAO = new SpendingDAO();
    }

    public List<Spending> getALl(){
        return spendingDAO.getAll();
    }
    
    public List<Spending> getByDate(Date date){
        return spendingDAO.getByDate(date);
    }
    
    public List<Spending> getByMonth(Date month){
        return spendingDAO.getByMonth(month);
    }
    
    public boolean addSpending(Spending spending){
        return spendingDAO.addSpending(spending);
    }

    public boolean removeSpending(int id){
        return spendingDAO.removeSpending(id);
    }
    
    public Spending getById(int id){
        return spendingDAO.getById(id);
    }
    
    public boolean updateSpending(Spending spending){
        return spendingDAO.updateSpending(spending);
    }
   
    public List<String> getPurposes(){
        return spendingDAO.getAllPurpose();
    }
}
