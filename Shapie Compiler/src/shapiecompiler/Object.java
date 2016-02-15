package shapiecompiler;

public class Object {
	String size;
	String color;
	String variable;
	String value; //if text, value of text ("hello world"). if shape, kind of shape ("circle")
	char type; //Shape or Text
	int x;
	int y;
	
	public Object(String size, String color, String variable, String value,
			char type, int x, int y) {
		super();
		this.size = size;
		this.color = color;
		this.variable = variable;
		this.value = value;
		this.type = type;
		this.x = x;
		this.y = y;
		System.out.println(x);
	}
	
	
}
