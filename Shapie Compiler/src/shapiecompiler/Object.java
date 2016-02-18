package shapiecompiler;

public class Object {
	String size;
	String color;
	String var;
	String value; //if text, value of text ("hello world"). if shape, kind of shape ("circle")
	char type; //Shape or Text
	int x;
	int y;
	
	public Object(String size, String color, String vars, String value,
			char type, int x, int y) {
		super();
		this.size = size;
		this.color = color;
		this.var = vars;
		this.value = value;
		this.type = type;
		this.x = x;
		this.y = y;
	}
	
	
}
