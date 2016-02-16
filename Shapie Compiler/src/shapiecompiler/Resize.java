package shapiecompiler;

public class Resize {
	public void Resize (String var, String size) {
		for (Object o : Output.ObjectList) {
			if(o.variable.equals(var)){
				o.size = size;
				Screen.output.refresh();
			}
		}
	}
}
