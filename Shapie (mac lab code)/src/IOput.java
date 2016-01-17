import java.util.regex.*;
import java.io.*;
import java.util.*;

public class IOput {
	
	public static void main(String args[]){
		String s;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter code: ");
		s = in.nextLine();
		Pattern words = Pattern.compile("\\w+");
		
		Matcher m = words.matcher(s);
		for(int count = 0; m.find(); count++) {
			String w = m.group();
			if(count==0 && isAction(w)){
				System.out.println(w);
				if(w.equals("Put")){
					put(m);
				} 
			} 
		}
	}
	
	public static boolean put(Matcher m) {
		m.group();
		for(int count = 0; m.find(); count++) {
			String w = m.group();
			if(count == 0){
				if(isNumber(w)){
					System.out.println(w);
					if(w.equals("a")){
						m.find();
						w = m.group();
						count++;
						if(isShape(w)){
							System.out.println(w);
						} else if(isSize(w)){
							System.out.println(w);
							m.find();
							w = m.group();
							count++;
							if(isColor(w)){
								System.out.println(w);
								if(isPluralShape(w)){
									System.out.println(w);
									m.find();
									w = m.group();
									count++;
									if (w.equals("everywhere")){
										System.out.println(w);
									}
								}
							}
						} else if(isColor(w)){
							System.out.println(w);
						} else {
							System.out.println("Error: " + w);
						} 
					} else{
						//plural, color, size
					}
				} else if(isPluralShape(w)){
					System.out.println(w);
					m.find();
					w = m.group();
					count++;
					if (w.equals("everywhere")){
						System.out.println(w);
					}
				} else if(isSize(w)){
					System.out.println(w);
					m.find();
					w = m.group();
					count++;
					if(isColor(w)){
						System.out.println(w);
						m.find();
						w = m.group();
						count++;
						if(isPluralShape(w)){
							System.out.println(w);
							m.find();
							w = m.group();
							count++;
							if (w.equals("everywhere")){
								System.out.println(w);
							}
						} 
					} else {
						System.out.println("Error: " + w);
					}
				} else if(isColor(w)){
					System.out.println(w);
					m.find();
					w = m.group();
					count++;
					if(isSize(w)){
						System.out.println(w);
					} else if(isPluralShape(w)){
						System.out.println(w);
					} else {
						System.out.println("Error: " + w);
					}
				} else {
					System.out.println("Error: " + w);
				}
			} else{
				return false;
			}	
		}
		return true;
	}
	
	public static boolean ifColor(Matcher m, String w){		
		return true;
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
	
	public static void putAction(String [] params){
		
	}
}
