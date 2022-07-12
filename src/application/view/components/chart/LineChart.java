/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.view.components.chart;

import application.view.color.SystemColor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class LineChart extends JPanel {

    private ChartModel model;
    private int hMinDividation = 1;
    private int vMinDividation = 1;
    private int hPadding = 60;
    private int vPadding = 30;
    private int limit = 0;

    public LineChart() {
        setPreferredSize(new Dimension(300, 300));
        setOpaque(true);
        setBackground(Color.white);
        this.limit = 25000;
        this.model = new ChartModel();
        this.vMinDividation = 50000;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int hLine = getChartWidth() + 50;
        int vLine = getChartHeight();
        int hCount = model.count();
        if (hCount == 0) {
            return;
        }

        int hUnit = hLine / hCount;
        int moneyUnit = model.getMaxValue() >= 250000 ? vMinDividation : vMinDividation / 2;
        int vCount = model.getMaxValue() / moneyUnit + 1;
        int vUnit = vLine / vCount;
//        g2.setColor(SystemColor.COLOR_3);
        for (int i = 1; i <= hCount; i++) {
            g2.fillRect(60 + i * hUnit, getHeight() - 33, 2, 8);

        }
        g2.setColor(SystemColor.COLOR_2);
        for (int i = 1; i <= vCount; i++) {
            int y = getHeight() - 30 - i * vUnit;
            g2.drawLine(60, y, 60 + hLine, y);

        }
        g2.setColor(SystemColor.COLOR_5);

//      draw h main line
        g2.fillRect(hPadding, vPadding, 2, vLine);
//      draw v main line
        g2.fillRect(hPadding, getO().y, hLine, 2);

        g2.setColor(SystemColor.COLOR_4);
        for (int i = 0; i < model.getData().size() - 1; i++) {
            int x = (i + 1) * hUnit + 60;
            double y = getHeight() - (model.getData().get(i) / (double) moneyUnit * vUnit) - 30;

            int x2 = (i + 2) * hUnit + 60;
            double y2 = getHeight() - (model.getData().get(i + 1) / (double) moneyUnit * vUnit) - 30;
            g2.drawLine(x, (int) y, x2, (int) y2);
            if (y != getO().y) {
                g2.fillOval(x - 3, (int) y - 3, 6, 6);
            }
            
            if (i == model.count() - 2 && y2 != getO().y) {
                g2.fillOval(x2 - 3, (int) y2 - 3, 6, 6);
            }

        }
        
        g2.setColor(SystemColor.COLOR_5);
        g2.setFont(new Font("Oswald", 0, 14));
        NumberFormat formater = NumberFormat.getCurrencyInstance();
        for (int i = 0; i <= vCount; i = i + 2) {
            g2.drawString(formater.format(i * moneyUnit), 2, getHeight() - 30 - i * vUnit);

        }
    }

    private Point getO() {
        return new Point(hPadding, getHeight() - vPadding);
    }

    private int getChartWidth() {
        return getWidth() - hPadding * 2;
    }

    private int getChartHeight() {
        return getHeight() - vPadding * 2;
    }

    public void setData(List<Integer> data) {
        model.setData(data);
        repaint();
    }

    public int hCount() {
        return model.count();
    }

}
