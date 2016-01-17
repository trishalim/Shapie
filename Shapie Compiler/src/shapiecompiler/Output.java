package shapiecompiler;

import java.awt.Color;
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
        System.out.println("boom");
        for(int i=0; i < ObjectList.size(); i++){
        	if(ObjectList.get(i).type == 's'){        		
        		drawSquare(ObjectList.get(i));
        	}
        	else if(ObjectList.get(i).type == 'c'){        		
        		drawCircle(ObjectList.get(i));
        	}
        	else if(ObjectList.get(i).type == 't'){        		
        		drawTriangle(ObjectList.get(i));
        	}
        }
        //draw all elements stored in objectlist
	}
	
	public void drawCircle(Object obj){
		g2d.setColor(getColor(obj.color));
		if(obj.size == "big")
			g2d.fillOval(obj.x, obj.y, bigS, bigS);
		else if(obj.size == "small")
			g2d.fillOval(obj.x, obj.y, smallS, smallS);
	}
	
	public void drawSquare(Object obj){
		g2d.setColor(getColor(obj.color));
		if(obj.size == "big")
			g2d.fillRect(obj.x, obj.y, bigS, bigS);
		else if(obj.size == "small")
			g2d.fillRect(obj.x, obj.y, smallS, smallS);
	}
	
	public void drawTriangle(Object obj){
		g2d.setColor(getColor(obj.color));
		g2d.fillPolygon(new int[]{this.getWidth()/2 - 50, this.getWidth()/2, this.getWidth()/2 + 50}, new int[]{this.getHeight()/2 + 50, this.getHeight()/2 - 50, this.getHeight()/2 + 50}, 3);
	}
	
	public Color getColor(String c){
		Color col;
		switch (c){
			case "": col = Color.black; break;
			case "red": col = Color.red; break;
			case "blue": col = Color.blue; break;
			case "pink": col = Color.PINK; break;
			case "yellow": col = Color.YELLOW; break;
			case "green": col = Color.green; break;
			default : col = Color.WHITE; break;
		}
		return col;
	}
}
