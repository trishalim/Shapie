package shapiecompiler;
import shapiecompiler.Object;
import shapiecompiler.Output;
import shapiecompiler.Screen;


public class NColor {
	public void coloring (String var, String color) {
		for (Object o : Output.ObjectList) {
			if(o.var!=null && o.var.equals(var)){
				o.color = color;
				Screen.output.refresh();
			}

		}
	}
}
