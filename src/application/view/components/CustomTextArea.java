package application.view.components;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import application.view.color.SystemColor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextArea;

/**
 *
 * @author PC
 */
public class CustomTextArea extends JTextArea implements MouseListener{
    private int radius;
    
    public CustomTextArea() {
        addMouseListener(this);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
    
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int height = getHeight() - 1;
        int width = getWidth() - 1;
        if(isHover)
            g2.setColor(SystemColor.COLOR_3);
        else
            g2.setColor(SystemColor.COLOR_4);
        g2.drawRoundRect(0, 0, width, height, radius, radius);
        
    }
    
    private boolean isHover = false;

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        isHover = true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isHover = false;
        repaint();
    }


}
