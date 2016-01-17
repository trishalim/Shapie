package shapiecompiler;

public class Put {
	
	//default values here
	int big  = 100;
	int small = 50;
	int x;
	int y;
	public void putShape(String size, String color, String shape, String position, String variable) {
		//create new object and add to Output.ObjectList
		
		if(position == "center"){
			x = Screen.output.getWidth()/2 - small;
			y = Screen.output.getHeight()/2 - small;
		}
		Object o = new Object(size, color, variable, "", 'c', x, y);
		Output.ObjectList.add(o);
	}
	
	public void putShapes(String num, String size, String color, String shape, String position, String variable) {
		//putShape loop
	}
	
	public void putText(String size, String color, String text, String variable) {
		//create new object and add to Output.ObjectList
	}
	
}
