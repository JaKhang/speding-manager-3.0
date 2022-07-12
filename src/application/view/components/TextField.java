/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.view.components;

import application.view.color.SystemColor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author PC
 */
public class TextField extends JTextField {
       private int radius = 4;
       private Color borderColor ;

    public TextField() {
        this.borderColor = SystemColor.COLOR_3;
        setBorder(new EmptyBorder(4, 4, 4, 4));
        setPadding(8, 8, 8, 8);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    
    
    
    public void setPadding(int top, int bottom, int left, int right){
        setBorder(new EmptyBorder(top, left, bottom, right));
    }
    
    
    
       
       
       
       
}
