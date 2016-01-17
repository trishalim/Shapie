package shapiecompiler;

import java.util.regex.Pattern;

public class StatementChecker {
	
	static Pattern actionReg = Pattern.compile("(Put|Color|Place|Resize)");
    static Pattern numReg = Pattern.compile("(a|\\d)");
    static Pattern shapeReg = Pattern.compile("(circle|square|triangle)");
    static Pattern pluralReg = Pattern.compile("(circles|squares|triangles)");
    static Pattern colorReg = Pattern.compile("(red|blue|yellow|pink|green)");
    static Pattern sizeReg = Pattern.compile("(small|big)");
    static Pattern posReg = Pattern.compile("(everywhere|\\(\\d,\\d\\))");
    static Pattern variableReg = Pattern.compile("([\"][a-zA-Z_$][a-zA-Z_$0-9][\"]*$)");
    static Pattern textReg = Pattern.compile("\\((.)\\)");
    static Pattern[] cases;
    
    public static void check(String s) {
    	cases = new Pattern[10];
        cases[0] = Pattern.compile ("Put a " + sizeReg + " " + colorReg + " " + shapeReg); //ok
        cases[1] = Pattern.compile ("Put " + numReg + " " + sizeReg + " " + colorReg + " " + pluralReg + " everywhere"); //ok
        cases[2] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " " + shapeReg + " in " + posReg); //ok
        cases[3] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " " + shapeReg + " in " + posReg + " named " + variableReg);  //ok
        cases[4] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " " + textReg + " named " + variableReg);
        cases[5] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " " + textReg + " named " + variableReg + " in " + posReg);
        cases[6] = Pattern.compile ("Put a " + sizeReg + " " + colorReg + " " + shapeReg + " named " + variableReg);//ok
        
        int matched = matches(s);
        
        //Put p = new Put();
        
        //String num, size, color, shape, position, variable, plural, text;
        
        //INITIALIZE VARIABLES ABOVE
        
        if(matched==0||matched==2||matched==3||matched==6) {
            //p.putShape("small", "pink", "circle", "center", "");
        } else if (matched==1) {
        	//p.putShapes(num, size, color, shape, position, variable);
        } else if (matched==4||matched==5) {
            //p.putText(size, color, text, variable);
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
