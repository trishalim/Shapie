package shapiecompiler;

public class Place {
	public void Place (String var, String position) {
		for (Object o : Output.ObjectList) {
			if(o.variable.equals(var)){
				int x, y;
				x = Screen.output.getWidth()/2;
				y = Screen.output.getHeight()/2;
				o.x = x+Put.getX(position);
				o.y = x-Put.getY(position);
				Screen.output.refresh();
			}
		}
	}
}
