package view.materialdesign;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;


public class MaterialButton extends JButton {
	private static final long serialVersionUID = 1L;
	private Color original;
	private Color hovered;
	
	public MaterialButton (String message, Color original, Color hover, Color fontColor, Font font) {
		super(message);
		this.original = original;
		this.hovered = hover;
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setFocusable(false);
		setBorder(null);
		setContentAreaFilled(false);
		setForeground(fontColor);
		setBackground(original);
		setFont(font);
		
	}
	
	public void select () {
		setBackground(original.brighter());
	}
	
	public void deselect () {
		setBackground(original);
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(original);
        } else if (getModel().isRollover()) {
            g.setColor(hovered);
        } else {
            g.setColor(getBackground());
        }
        
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}