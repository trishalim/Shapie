package shapiecompiler;

public class Place {
	public void Placepos (String var, String position) {
		int z =0;
		for (Object o : Output.ObjectList) {
			if(o.var!=null && o.var.equals(var)){
				int x, y;
				x = Screen.output.getWidth()/2;
				y = Screen.output.getHeight()/2;
				o.x = x+Put.getX(position);
				o.y = x-Put.getY(position);
				Screen.output.refresh();
				break;
			}
		}
	}
}
