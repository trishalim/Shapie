package shapiecompiler;

public class Shapie {
	
	public static void main(String[] args) {
		new Screen();
	}
	
	public static boolean checkCode(String code) {
        //code = code.replace("\n", "");
        String[] s = code.split("\n"); //statements
        for (int i=0; i<s.length; i++) {
        	try{
        		System.out.println("a: "+s[i]);
                StatementChecker.check(s[i]);		
        		Screen.setError(" ");
        	} catch (Exception e) {
        		Screen.setError("Error on line "+(i+1));
        		break;
        	}
         
        }
        return true;
    }
}
