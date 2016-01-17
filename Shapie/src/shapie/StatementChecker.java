package shapie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatementChecker {
    
    static Pattern actionReg = Pattern.compile("(Put|Color|Place|Resize)");
    static Pattern numReg = Pattern.compile("(a|\\d)");
    static Pattern shapeReg = Pattern.compile("(circle|square|triangle)");
    static Pattern pluralReg = Pattern.compile("(circles|squares|triangles)");
    static Pattern colorReg = Pattern.compile("(red|blue|yellow)");
    static Pattern sizeReg = Pattern.compile("(small|big)");
    static Pattern posReg = Pattern.compile("(everywhere|\\(\\d,\\d\\))");
    static Pattern variableReg = Pattern.compile("([\"][a-zA-Z_$][a-zA-Z_$0-9][\"]*$)");
    static Pattern textReg = Pattern.compile("\\((.)\\)");
    static Pattern[] cases;
    
    public static void check(String s) {
    //System.out.println("Put a big red \"hi\" named \"haha\"");
        cases = new Pattern[10];
        cases[0] = Pattern.compile ("Put a " + sizeReg + " " + colorReg + " " + shapeReg); //ok
        cases[1] = Pattern.compile ("Put " + numReg + " " + sizeReg + " " + colorReg + " " + pluralReg + " everywhere"); //ok
        cases[2] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " " + shapeReg + " in " + posReg); //ok
        cases[3] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " " + shapeReg + " in " + posReg + " named " + variableReg);  //ok
        cases[4] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " " + textReg + " named " + variableReg);
        cases[5] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " " + textReg + " named " + variableReg + " in " + posReg);
        cases[6] = Pattern.compile ("Put a " + sizeReg + " " + colorReg + " " + shapeReg + " named " + variableReg);//ok
        
        System.out.println("b: "+matches(s));
        
        String num = "", size= "", color="", shape="", pos="", plural="", variable="", text="";
        
        int matched = matches(s);
        Matcher m = numReg.matcher(s);
        if(m.find())
            num = m.group(0);
        
        m = sizeReg.matcher(s);
        if(m.find())
            size = m.group(0);
        
        m = colorReg.matcher(s);
        if(m.find())
            color = m.group(0);
        
        m = shapeReg.matcher(s);
        if(m.find())
            shape = m.group(0);
        
        m = pluralReg.matcher(s);
        if(m.find())
            plural = m.group(0);
        
        m = textReg.matcher(s);
        if(m.find())
            text = m.group(0);
        
        m = posReg.matcher(s);
        if(m.find())
            pos = m.group(0);
        
        m = variableReg.matcher(s);
        if(m.find())
            variable = m.group(0);
        
        Put p = new Put();
        
        if(matched==0||matched==1||matched==2||matched==3||matched==6) {
            p.putShape(num, size, color, shape, plural, pos, variable);
        } else if (matched==4||matched==5) {
            //putText
        }
        
//        if(matches(s)==0){
//            p.put(size, color, shape);
//        } else if (matches(s)==1){
//            p.put(num, size, color, plural);
//        } else if (matches(s)==2){
//            p.put(num, size, color, shape, pos);
//        } else if (matches(s)==3){
//            p.put(num, size, color, shape, pos, variable);
//        } else if (matches(s)==4){
//            p.put4(size, color, text, variable);
//        } else if (matches(s)==5){
//            p.put(size, color, text, variable, pos);
//        } else if (matches(s)==6){
//            p.put(size, color, variable);
//        } 
    }
    
    public static int matches(String s) {
        boolean match = false;
        for (int i=0; i<7; i++) {
            if(cases[i].matcher(s).matches()){
                match =true;
                return i;
            }
        }
        return -1;
    }
}
