package shapiecompiler;

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
		if(position==null){
			System.out.println("position settings");
			x = Screen.output.getWidth()/2;
			y = Screen.output.getHeight()/2;			
		}else if(position!=null && position!="everywhere"){
			x=getX(position);
			y=getY(position);

		}else{

		}
		System.out.println(x);
		System.out.println(y);
		Object o = new Object(size, color, variable, shape, 's', x, y);
		Output.ObjectList.add(o);
	}
	
	public void putShapes(String num, String size, String color, String shape, String position, String variable) {
		//putShape loop
		for(int i = 0; i < Integer.parseInt(num); i++){
			putShape(size, color, shape, position, variable);
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
	public int getX(String position){
		int x=0;
		boolean emp = true;
		Pattern pos = Pattern.compile("\\d{1,10}");
		Matcher m=pos.matcher(position);
		while(m.find()){
			if(emp==true){
				x=Integer.parseInt(m.group());
				emp=false;
			}
		}
		
		return x;
	}	
	public int getY(String position){
		int y=0;
		boolean emp = true;
		Pattern pos = Pattern.compile("\\d{1,10}");
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
