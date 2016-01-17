import java.util.regex.*;
import java.util.*;

public class Shapie {
	public static void main(String args[]){
		String s;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter code: ");
		s = in.nextLine();
		Pattern words = Pattern.compile("\\w+");
		
		Matcher m = words.matcher(s);
		if(m.find()){
			if(isAction(m.group())){
				System.out.println("YEEY");
			}
		}
	}
	
	public static void put(Matcher m){
		int count = m.groupCount();
		HashMap<String, String> hm = new HashMap<String, String>();
		if(count == 8){
			if(isNumber(m.group(1)))
				hm.put("N", m.group(1));
			if(isNumber(m.group(1)))
				hm.put("N", m.group(1));
			if(isShape(m.group(4))){
				
			} else if(isPluralShape(m.group(4))){
				
			}
		}
	}
	
	public static boolean isAction(String word) {
		Pattern actionReg= Pattern.compile("Put|Color|Place|Resize");
		return actionReg.matcher(word).matches();
	}
	
	public static boolean isNumber(String word) {
		Pattern numReg= Pattern.compile("a|\\d");
		return numReg.matcher(word).matches();
	}
	
	public static boolean isShape(String word) {
		Pattern shapesReg = Pattern.compile("circle|square|triangle");
		return shapesReg.matcher(word).matches();
	}
	
	public static boolean isPluralShape(String word) {
		Pattern pluralReg = Pattern.compile("circles|squares|triangles");
		return pluralReg.matcher(word).matches();
	}
	
	public static boolean isColor(String word) {
		Pattern colorReg = Pattern.compile("red|blue|yellow");
		return colorReg.matcher(word).matches();
	}
	
	public static boolean isSize(String word) {
		Pattern sizeReg = Pattern.compile("small|big");
		return sizeReg.matcher(word).matches();
	}
}
