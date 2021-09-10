package com.astontech.bo.interfaces;

public class drawkcab implements CharSequence {
    private String BackwardsWord;


    public drawkcab() {}

    public String getBackwardsWord() {
        return BackwardsWord;
    }

    public void setBackwardsWord(String backwardsWord) {
        BackwardsWord = backwardsWord;
    }
    
    public void returnBackward(CharSequence word, int end, int start){
        int size = word.length();
        for(int i = end; i >= start; i--){
            System.out.print(word.charAt(i));
        }

    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        CharSequence o = null;
        
        return o;
    }
}
