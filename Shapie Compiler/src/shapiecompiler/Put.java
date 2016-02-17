package shapiecompiler;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Put {
	
	//default values here
	int big  = 100;
	int small = 50;
	int x;
	int y;
	public void putShape(String size, String color, String shape, String position, String variable) {
		//create new object and add to Output.ObjectList
		System.out.println("inside");
		System.out.println(position);
		x = Screen.output.getWidth()/2;
		y = Screen.output.getHeight()/2;
		if(position==null){
			System.out.println("position settings");						
		}else if(position!=null && position!="everywhere"){
			x+=getX(position);
			y-=getY(position);
			System.out.println("x: "+ x);
			System.out.println("y: "+ y);
		}else{

		}
		System.out.println(x);
		System.out.println(y);
		Object o = new Object(size, color, variable, shape, 's', x, y);
		Output.ObjectList.add(o);
	}
	
	public void putShapes(String num, String size, String color, String shape, String position, String variable) {
		//putShape loop
		int max = 100; //pls change
		int min = -100;
		String newpos;
		if(num==null){
			Random rand = new Random();
			int z = rand.nextInt(5 - 2 + 1) + 2;
			num = ""+z;
		}
		switch(shape){
			case "squares" : shape="square"; break;
			case "circles" : shape="circle"; break;
			case "triangles" : shape="triangle"; break;
		}
		for(int i = 0; i < Integer.parseInt(num); i++){
			if(position.equals("everywhere")){
				Random random = new Random();
				int x = random.nextInt(max - min + 1) + min;;
				int y = random.nextInt(max - min + 1) + min;;
				newpos = "(" + x +"," + y + ")"; 
			}else{
				newpos=position;
			}
			putShape(size, color, shape, newpos, variable);
		}
	}
	
	public void putText(String size, String color, String text, String variable, String position) {
		//create new object and add to Output.ObjectList
		if(position == "center"){
			x = Screen.output.getWidth()/2;
			y = Screen.output.getHeight()/2;
		}
		Object o = new Object(size, color, variable, text, 't', x, y);
		Output.ObjectList.add(o);
	}
	
	public static int getX(String position){
		int x=0;
		boolean emp = true;
		Pattern pos = Pattern.compile("-?\\d{1,10}");
		Matcher m=pos.matcher(position);
		while(m.find()){
			if(emp==true){
				x=Integer.parseInt(m.group());
				emp=false;
			}
		}
		
		return x;
	}	
	
	public static int getY(String position){
		int y=0;
		boolean emp = true;
		Pattern pos = Pattern.compile("-?\\d{1,10}");
		Matcher m=pos.matcher(position);
		while(m.find()){
			if(emp==true){
				m.find();
				y=Integer.parseInt(m.group());
				emp=false;
			}
		}
		
		return y;
	}
}
