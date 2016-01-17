package shapiecompiler;

public class Put {
	static Object obj = new Object();
	
	//default values here
	String defNum = "1";
	String defColor = "black";
	String defPos = "center";
	String defSize = "small";
	
	public void putShape(String size, String color, String shape, String position, String variable) {
		//create new object and add to Output.ObjectList
		obj.color = (color == "") ? defColor : color;
		obj.size = (size == "") ? defSize : size;
		obj.type = 's';
		obj.x = 0;
		obj.y = 0;
		obj.value = "BOGO!";
		Output.ObjectList.add(obj);
	}
	
	public void putShapes(String num, String size, String color, String shape, String position, String variable) {
		//putShape loop
	}
	
	public void putText(String size, String color, String text, String variable) {
		//create new object and add to Output.ObjectList
	}
	
}
