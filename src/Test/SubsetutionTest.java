package Test;

import Subsetution.SubsetutionMethods;

import java.util.Scanner;

public class SubsetutionTest {

    static String plainText;
    static int key;
    static Scanner scanner;
    public static void main(String[] args) {
        plainText="Ali is good";
        key=2;
        scanner=new Scanner(System.in);
        SubsetutionMethods sb=new SubsetutionMethods(plainText,key);

        String cipher=sb.cezer(plainText,key, SubsetutionMethods.SecurtyType.Encripte);

        System.out.println("Add Method "+cipher);

        System.out.println("Add Method "+sb.cezer(cipher,key, SubsetutionMethods.SecurtyType.Decripte));



    }
}
