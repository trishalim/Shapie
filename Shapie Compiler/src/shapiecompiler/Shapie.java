package shapiecompiler;

public class Shapie {
	
	public static void main(String[] args) {
		new Screen();
	}
	
	public static boolean checkCode(String code) {
        code = code.replace("\n", "");
        String[] s = code.split("\\."); //statements
        for (int i=0; i<s.length; i++) {
            System.out.println("a: "+s[i]);
            StatementChecker.check(s[i]);
        }
        return true;
    }
}
