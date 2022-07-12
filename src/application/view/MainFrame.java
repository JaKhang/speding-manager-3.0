/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package application.view;

import application.controller.Controller;
import application.model.dao.DBConnection;
import application.view.color.SystemColor;
import application.view.components.navigation.NavigationBar;
import application.view.components.transitionpane.PanelTransitions;
import application.view.font.SystemFont;
import application.view.pane.WellcomePane;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author PC
 */
public class MainFrame extends javax.swing.JFrame {
    
    private Controller controller;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        config();
        this.controller = new Controller();
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/application/view/icon/icons8_payment_history_32px_1.png")).getImage());
        titleBar.init(this);
        navigationBar.addItem(new ImageIcon(getClass().getResource("/application/view/icon/icons8_time_machine_40px.png")));
        navigationBar.addItem(new ImageIcon(getClass().getResource("/application/view/icon/icons8_chart_40px_1.png")));
        navigationBar.addEvent(controller);
        controller.setUpController(this);
        this.panelTransitions.display(new WellcomePane(), navigationBar.getAnimator());
        getContentPane().setBackground(SystemColor.COLOR_1);
        setLocationRelativeTo(null);
    }
    
    private void config(){
                try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        SystemFont.getFont();   
        UIManager.put("Button.font", new FontUIResource(new Font("Oswald", Font.PLAIN, 16)));
        UIManager.put("Tabel.font", new FontUIResource(new Font("Oswald", Font.PLAIN, 16)));
        UIManager.put("Label.font", new FontUIResource(new Font("Oswald", Font.PLAIN, 16)));
        UIManager.put("TextField.font", new FontUIResource(new Font("Oswald", Font.PLAIN, 16)));
        UIManager.put("TextArea.font", new FontUIResource(new Font("Oswald", Font.PLAIN, 16)));
        UIManager.put("TextField.inactiveBackground", new ColorUIResource(Color.white));
        //</editor-fold>
        try {
            /* Create and display the form */
            DBConnection.connect().close();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleBar = new application.view.components.titlebar.SimpleTitleBar();
        navigationBar = new application.view.components.navigation.NavigationBar();
        panelTransitions = new application.view.components.transitionpane.PanelTransitions();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(SystemColor.COLOR_1);
        setFocusable(false);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1240, 720));

        titleBar.setBackground(SystemColor.COLOR_5);
        titleBar.setPreferredSize(new java.awt.Dimension(943, 28));
        getContentPane().add(titleBar, java.awt.BorderLayout.PAGE_START);

        navigationBar.setBackground(SystemColor.COLOR_5);
        navigationBar.setForeground(SystemColor.COLOR_3);
        navigationBar.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(navigationBar, java.awt.BorderLayout.PAGE_END);

        panelTransitions.setBackground(SystemColor.COLOR_1);
        panelTransitions.setOpaque(true);
        getContentPane().add(panelTransitions, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public PanelTransitions getPanelTransitions() {
        return panelTransitions;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private application.view.components.navigation.NavigationBar navigationBar;
    private application.view.components.transitionpane.PanelTransitions panelTransitions;
    private application.view.components.titlebar.SimpleTitleBar titleBar;
    // End of variables declaration//GEN-END:variables
}
