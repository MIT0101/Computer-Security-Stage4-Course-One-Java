package Subsetution;

import java.util.ArrayList;
import java.util.HashMap;

public class SubsetutionMethods {
    private ArrayList<Character> baseLetters;
    static String SPACE_SPLITER=" ";
    static char SPACE_REPLACE='$';
    private String plainText;
    private int key;

    public SubsetutionMethods(String plainText, int key) {
        baseLetters=new ArrayList<>();
        fillMap();
        this.plainText = plainText;
        this.key = key;
    }
    private void fillMap(){
        //capital letters
        for (char ch='A', i=0; ch <='Z' ; ch++,i++) {
            baseLetters.add(ch);

        }

        //smole letters
        for (char ch='a'; ch <='z' ; ch++) {
            baseLetters.add(ch);
        }

        //number letters
        for (char ch='0'; ch <='9' ; ch++) {
            baseLetters.add(ch);

        }

    }

    public String cezer(String plainText,int key,SecurtyType securtyType){
        cizerSecurtyAction cizerSecurtyAction;
        if(securtyType==SecurtyType.Encripte){

            cizerSecurtyAction=new cizerSecurtyAction() {
                @Override
                public int indexToGet(int indexOfPlainTex, int key) {
                    return indexOfPlainTex+key;
                }
            };

        }
        else{
            cizerSecurtyAction=new cizerSecurtyAction() {
                @Override
                public int indexToGet(int indexOfPlainTex, int key) {
                    return indexOfPlainTex-key;
                }
            };
        }
        plainText=plainText.replaceAll(" ","");
        StringBuilder result=new StringBuilder();


        for (int i = 0; i < plainText.length(); i++) {
            int plainIndex=baseLetters.indexOf(plainText.charAt(i));
            if(plainIndex==-1){
              throw new ArithmeticException("This Letter Not Found in base Letter");
            }
            result.append(baseLetters.get(cizerSecurtyAction.indexToGet(plainIndex,key)));
        }

        return result.toString();

    }

    public enum SecurtyType{
        Encripte,
        Decripte
    }

    private interface cizerSecurtyAction{
        int indexToGet(int indexOfPlainTex,int key );
    }
}
