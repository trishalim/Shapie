package shapiecompiler;
import shapiecompiler.Object;
import shapiecompiler.Output;
import shapiecompiler.Screen;


public class NColor {
	public void NColor (String var, String color) {
		for (Object o : Output.ObjectList) {
			if(o.variable.equals(var)){
				o.color = color;
				Screen.output.refresh();
			}
		}
	}
}
