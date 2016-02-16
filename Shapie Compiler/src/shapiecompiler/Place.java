package shapiecompiler;

public class Place {
	public void Place (String var, String position) {
		for (Object o : Output.ObjectList) {
			if(o.variable.equals(var)){
				o.x = Put.getX(position);
				o.y = Put.getY(position);
				Screen.output.refresh();
			}
		}
	}
}
