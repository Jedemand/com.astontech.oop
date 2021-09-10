package Common.helpers;

public class StringHelper {

    public static boolean isNullOrEmpty(String s){

        return s == null || s.length() == 0;
    }

    public static String createInitials(String a, String b){
       char[] firstArray = a.toCharArray();
       char firstInitial = firstArray[0];
       char[] secondArray = b.toCharArray();
       char secondInitial = secondArray[0];
       return String.valueOf(firstInitial + secondInitial);
    }

    public static int getCount(String s){
        return s.length();
    }

    public static boolean checkWord(String firstWord, String input){
        return firstWord.equals(input);
    }

}
