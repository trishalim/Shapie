package shapiecompiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatementChecker {
	
	static Pattern actionReg = Pattern.compile("(Put|Color|Place|Resize)");
    static Pattern numReg = Pattern.compile("(a|\\d)");
    static Pattern shapeReg = Pattern.compile("(circle|square|triangle)");
    static Pattern pluralReg = Pattern.compile("(circles|squares|triangles)");
    static Pattern colorReg = Pattern.compile("(red|blue|yellow|pink|green|black)");
    static Pattern sizeReg = Pattern.compile("(small|big)");
    static Pattern posReg = Pattern.compile("(everywhere|\\(\\d{1,10},\\d{1,10})\\)");
    static Pattern variableReg = Pattern.compile("\"([^\"]*)\"");
    static Pattern textReg = Pattern.compile("(\"([^\"]*)\")");
    static Pattern[] cases;
    
    public static void check(String s) {
    	cases = new Pattern[10];
        cases[0] = Pattern.compile ("Put a " + sizeReg + " " + colorReg + " " + shapeReg); //ok
        cases[1] = Pattern.compile ("Put " + numReg + " " + sizeReg + " " + colorReg + " " + pluralReg + " everywhere"); //ok
        cases[2] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " " + shapeReg + " in " + posReg); //ok
        cases[3] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " " + shapeReg + " in " + posReg + " named " + variableReg);  //ok
        cases[4] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " " + textReg + " named " + variableReg);// ok
        cases[5] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " " + textReg + " named " + variableReg + " in " + posReg);
        cases[6] = Pattern.compile ("Put a " + sizeReg + " " + colorReg + " " + shapeReg + " named " + variableReg);//ok
        cases[7] = Pattern.compile ("Put a " + colorReg + " " + shapeReg);
        cases[8] = Pattern.compile ("Put a " + colorReg + " " + shapeReg + posReg);
        cases[9] = Pattern.compile ("Put a " + colorReg + " " + shapeReg + " named " + variableReg);
        
        int matched = matches(s);
        System.out.println(matched);
        
		Pattern words = Pattern.compile("\\w+");
		
		Matcher m = words.matcher(s);
		int named=0, t=0;
		String action=null, num=null, size="small", color="black", plural=null, shape=null, pos=null, text=null, var=null;
		if(matched>=0){
		while(m.find()){
			System.out.println(m.group());
			if(actionReg.matcher(m.group()).matches()){
				action=m.group();
			}else if(numReg.matcher(m.group()).matches()){
				if(num==null)
					num=m.group();
			}else if(sizeReg.matcher(m.group()).matches()){
				size=m.group();
			}else if(colorReg.matcher(m.group()).matches()){
				color=m.group();
			}else if(pluralReg.matcher(m.group()).matches()){
				plural=m.group();
			}else if(shapeReg.matcher(m.group()).matches()){
				shape=m.group();
			}			
		}
			m = textReg.matcher(s);
			while (m.find()) {
				if (t == 0) {
					text = m.group();
					t++;
				} else if (named == 0) {
					var = m.group();
					named++;
				}
			}
			m = posReg.matcher(s);
			while (m.find())
				pos = m.group();
		}
		System.out.println("action" + action);
		System.out.println("num" + num);
		System.out.println("size" +size);
		System.out.println("color" + color);
		System.out.println("plural" + plural);
		System.out.println("shape" + shape);
		System.out.println("text" + text);
		System.out.println("var" + var);
		System.out.println("pos" + pos);
        Put p = new Put();
        
        //String num, size, color, shape, position, variable, plural, text;
        
        //INITIALIZE VARIABLES ABOVE
        
        if(matched==0||matched==2||matched==3||matched==6) {
            p.putShape(size, color, shape, pos, var);
        } else if (matched==1) {
        	p.putShapes(num, size, color, shape, pos, var);
        } else if (matched==4||matched==5) {
            p.putText(size, color, text, var, pos);
        }
    }
    
    public static int matches(String s) {
        for (int i=0; i<7; i++) {
            if(cases[i].matcher(s).matches()){
                return i;
            }
        }
        return -1;
    }
    
}
