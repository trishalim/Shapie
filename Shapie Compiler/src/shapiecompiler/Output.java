package shapiecompiler;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Output extends JPanel{
	
	private static final long serialVersionUID = 1L;
	Graphics2D g2d;
	int bigS = 200;
	int smallS = 100;
	int bigT = 72;
	int smallT = 36;
	static ArrayList<Object> ObjectList = new ArrayList<Object>();

	public void redraw() {
		this.repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        g2d = (Graphics2D) g;
        for(int i=0; i < ObjectList.size(); i++){
        	if(ObjectList.get(i).type=='s'){
				if (ObjectList.get(i).value.matches("square")) {
					drawSquare(ObjectList.get(i));
				} else if (ObjectList.get(i).value.matches("circle")) {
					drawCircle(ObjectList.get(i));
				} else if (ObjectList.get(i).value.matches("triangle")) {
	        		drawTriangle(ObjectList.get(i));					
				}
        	}else if(ObjectList.get(i).type == 't'){        		
        		displayText(ObjectList.get(i));
        	}

        }
        //draw all elements stored in objectlist
	}
	
	public void drawCircle(Object obj){
		g2d.setColor(getColor(obj.color));
		if(obj.size.matches("big")){
			g2d.fillOval(obj.x - (bigS/2), obj.y - (bigS/2), bigS, bigS);

		}
		else if(obj.size.matches("small"))
			g2d.fillOval(obj.x - (smallS/2), obj.y - (smallS/2), smallS, smallS);
	}
	
	public void drawSquare(Object obj){
		g2d.setColor(getColor(obj.color));
		if(obj.size.matches("big"))
			g2d.fillRect(obj.x - (bigS/2), obj.y - (bigS/2), bigS, bigS);
		else if(obj.size.matches("small"))
			g2d.fillRect(obj.x - (smallS/2), obj.y - (smallS/2), smallS, smallS);
	}
	
	public void drawTriangle(Object obj){
		g2d.setColor(getColor(obj.color));		
		if(obj.size.matches("big"))
			g2d.fillPolygon(new int[]{obj.x - (bigS/2), obj.x, obj.x + (bigS/2)}, new int[]{obj.y + (bigS/2), obj.y - (bigS/2), obj.y + (bigS/2)}, 3);
		else if(obj.size.matches("small"))
			g2d.fillPolygon(new int[]{obj.x - (smallS/2), obj.x, obj.x + (smallS/2)}, new int[]{obj.y + (smallS/2), obj.y - (smallS/2), obj.y + (smallS/2)}, 3);
	}
	
	public void displayText(Object obj){
		g2d.setColor(getColor(obj.color));
		String text = obj.value;
		int size = (obj.size.matches("big")) ? 48 : 36;
		Font font = (new Font("Arial", Font.BOLD, size));
	    FontMetrics metrics = g2d.getFontMetrics(font);
	    int x = obj.x - (metrics.stringWidth(text) / 2);
	    int y = (obj.y - (metrics.getHeight() / 2)) + metrics.getAscent();
	    g2d.setFont(font);
	    g2d.drawString(text, x, y);
	}
	
	public Color getColor(String c){
		Color col;
		switch (c){
			case "": col = Color.black; break;
			case "black": col = Color.black; break; 
			case "red": col = Color.red; break;
			case "blue": col = Color.blue; break;
			case "pink": col = Color.PINK; break;
			case "yellow": col = Color.YELLOW; break;
			case "green": col = Color.green; break;
			default : col = Color.WHITE; break;
		}
		return col;
	}
	public void changeBG(String col){
		Color colorbg = getColor(col);
		this.setBackground(colorbg);
		this.redraw();
	}
	
	public void refresh(){
		this.redraw();
	}
}
