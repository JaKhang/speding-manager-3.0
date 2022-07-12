package application.view.components;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import application.view.color.SystemColor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author PC
 */
public class CustomComboBox<T> extends JComboBox<Object> implements MouseListener {


    private boolean isHover = false;
    private int radius = 0;

    public CustomComboBox() {

        setBorder(new EmptyBorder(5, 3, 5, 3));
        setUI(new ComboUI(this));
        setFocusable(false);
        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
                Component com = super.getListCellRendererComponent(jlist, o, i, bln, bln1);
                setBorder(new EmptyBorder(5, 5, 5, 5));
                if (bln) {
                    com.setBackground(SystemColor.COLOR_2);
                }
                return com;
            }
        });
    }

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
    
    
    

    private class ComboUI extends BasicComboBoxUI {

        private CustomComboBox<T> comboBox;

        public ComboUI(CustomComboBox<T> comboBox) {
            this.comboBox = comboBox;
            addMouseListener(comboBox);
        }
        
        

        @Override
        protected JButton createArrowButton() {
            return new ArrowButton(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            super.paint(g, c);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            if (isHover) {
                g2.setColor(SystemColor.COLOR_2);
            } else {
                g2.setColor(SystemColor.COLOR_4);
            }
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
            g2.dispose();
        }

        private class ArrowButton extends JButton {

            public ArrowButton() {
                setContentAreaFilled(false);
                setBorder(new EmptyBorder(5, 5, 5, 5));
                setBackground(new Color(150, 150, 150));
                addMouseListener(comboBox);
            }

            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int width = getWidth();
                int height = getHeight();
                int size = 5;
                int y = (height - size) / 2;
                int x = (width - size) / 2 + 2;
                int[] px = {x, x + size, x + size / 2};
                int[] py = {y, y, y + size};
                if (isHover) {
                    g2.setColor(SystemColor.COLOR_3);
                } else {
                    g2.setColor(SystemColor.COLOR_2);
                }
                g2.fillPolygon(px, py, px.length);

            }
        }
    }

}
