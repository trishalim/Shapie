package shapie;

import java.util.Scanner;

public class Shapie {
    public static Screen scr;
    public static void main(String[] args) {
        scr = new Screen();
        scr.setVisible(true);
        
    }
    
    public static boolean checkCode(String code) {
        StatementChecker checker = new StatementChecker();
        code = code.replace("\n", "");
        String[] s = code.split("\\."); //statements
        for (int i=0; i<s.length; i++) {
            System.out.println("a: "+s[i]);
            checker.check(s[i]);
        }
        return true;
    }
  
}

