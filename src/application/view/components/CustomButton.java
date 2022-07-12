package application.view.components;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import application.view.color.SystemColor;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author PC
 */
public class CustomButton extends JButton implements MouseListener{
    private Color hoverColor;
    private int radius;
    private Color currentBackground = getBackground();
    private Color notEnabledColor;
    
    public CustomButton() {
        this.notEnabledColor = SystemColor.COLOR_2;
        this.hoverColor = SystemColor.COLOR_2;
        addMouseListener(this);
        setFocusable(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setContentAreaFilled(false);
    }
    

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        currentBackground = bg;
    }

    public void setNotEnabledColor(Color notEnabledColor) {
        this.notEnabledColor = notEnabledColor;
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }

    
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(isEnabled())
            g2.setColor(currentBackground);
        else
            g2.setColor(notEnabledColor);
	g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
	super.paintComponent(g);
    }
    
    

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setCurrentBackground(Color currentBackground) {
        this.currentBackground = currentBackground;
    }
    
    
    
    private boolean isHover = false;

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!isEnabled())
            return;
        currentBackground = getBackground();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(!isEnabled())
            return;
        if(isHover)
            currentBackground = hoverColor;

	else 
            currentBackground = getBackground();

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!isEnabled())
            return;
        currentBackground = hoverColor;
        isHover = true;
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!isEnabled())
            return;
        currentBackground = getBackground();
        isHover = false;
    }


   
    
    
    
    
    

    
    
}
