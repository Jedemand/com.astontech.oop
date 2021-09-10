package Common.helpers;

public class MathHelper {
    public static final double E = 2.71;
    public static final double PI = 3.14;

    public  static int square(int val){
        return val * val;
    }
    
    public static String compareValue(int Value1, int Value2){
        if (Value1 > Value2)
            return "Greater than";
        else if (Value2 > Value1)
            return "Less than";
        else 
            return "Equal to";
    }
    
    public static int calculator(int value1, int value2, char operator){
        int product = 0;
        switch (operator){
            case '+':
                product = value1 + value2;
                break;
            case '-':
                product = value1 - value2;
                break;
            case '*':
                product = value1 * value2;
                break;
            case '/':
                product = value1 / value2;
                break;
            default:
                System.out.println("Invalid input. Please try again");
        }
        return product;
    }

    public static int moduloConversion(int value, int modulo){
        return value % modulo;
    }


}
