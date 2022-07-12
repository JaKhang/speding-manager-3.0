package application.view.components.card;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ModelCard {

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ModelCard(ImageIcon icon, Color color1, Color color2, String values, String description) {
        this.icon = icon;
        this.color1 = color1;
        this.color2 = color2;
        this.values = values;
        this.description = description;
    }

    public ModelCard() {
    }

    private ImageIcon icon;
    private Color color1;
    private Color color2;
    private String values;
    private String description;
}
