package shapiecompiler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Output extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	static ArrayList<Object> ObjectList;

	public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.magenta);
        g2d.fillPolygon(new int[] {120, 150, 180}, new int[] {150, 100, 150}, 3);
        g2d.fillRect(0, 0, 100, 200);
        
        //Screen.output.repaint();
	}	
}
