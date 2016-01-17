package shapie;

public class Put {
    static String defSize = "big";
    static String defColor = "black";
    static String defPos = "something";
    static String defShape;
    
    public void putShape(String num, String size, String color, String shape, String plural, String pos, String variable) {
        int number;
        if(num.equals("")) number = 1;
        else number = Integer.parseInt(num);
        if(size.equals("")) size = defSize;
        if(color.equals("")) color = defColor;
        if(pos.equals("")) pos = defPos;
        
        if(shape.equals("")){
            
        } else if(plural.equals("")) {
            defShape = shape;
        }
        
    }
    
//    public void put(String size, String color, String shape){ //cases 0 
//        System.out.println("0");
//    }
//    
//    public void put(int num, String size, String color, String shape){ //cases 1 
//        System.out.println("1");
//    }
//    
//    public void put(int num, String size, String color, String shape, String pos){ //case 2
//        System.out.println("2");
//    }
//    
//    public void put(String num, String size, String color, String shape, String pos, String varname){ //case 3
//        System.out.println("3");
//    }
//    
//    public void put4(String size, String color, String text, String varname){ //case 4 
//        System.out.println("4");
//    }
//    
//    public void put(String size, String color, String text, String varname, String pos){ //case 5
//        System.out.println("5");
//    }    
//    
//    public void put(String size, String color, String shape, String variable){ //6
//        System.out.println("6");
//    }
}
