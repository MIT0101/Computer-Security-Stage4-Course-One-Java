package Test;

import Transpostion.TransportEncriptionMethods;

import java.util.Scanner;

public class TransmistionTest {
    static String plainText;
    static String key;
    static Scanner scanner;
    public static void main(String[] args) {
//        plainText="COMPUTER AND DATA SECURITY";
//        key="41532";

        plainText="Ali is good";
        key="41532";

        scanner=new Scanner(System.in);
//        System.out.println("Enter Text");
//        plainText=scanner.nextLine();

//        System.out.println("Enter Key");
//
//        key=scanner.nextLine();


        TransportEncriptionMethods transportEncriptionMethods =new TransportEncriptionMethods();

        long startOldColumnTime=System.nanoTime();
        String cipherText_byOldColumn= transportEncriptionMethods.TranspotBYColumn(plainText,key);
        System.out.println("Old Column : "+cipherText_byOldColumn+" Time: "+(System.nanoTime()-startOldColumnTime)/100);

        long  startNewColumnTime=System.nanoTime();
        String cipherText_byNewColumn= transportEncriptionMethods.TranspotBYColumn_New(plainText,key);
        System.out.println("New Column : "+cipherText_byNewColumn+" Time: "+(System.nanoTime()-startNewColumnTime)/100);

        long startOldRowTime=System.nanoTime();
        String cipherText_byOldRow= transportEncriptionMethods.TranspotBYRow(plainText,key);
        System.out.println("Old Row    : "+cipherText_byOldRow +" Time: "+(System.nanoTime()-startOldRowTime)/100);

        long startNewRowTime=System.nanoTime();
        String cipherText_byNewRow= transportEncriptionMethods.TranspotBYRow_New(plainText,key);
        System.out.println("New Row    : "+cipherText_byNewRow+" Time: "+(System.nanoTime()-startNewRowTime)/100);


//        System.out.println("Now Using Row Transport ...");

        System.out.println("Old Type Column : "+ transportEncriptionMethods.TranspotEn(plainText,key, TransportEncriptionMethods.TransportDirection.COLUMN));
        System.out.println("Old Type Row    : "+ transportEncriptionMethods.TranspotEn(plainText,key, TransportEncriptionMethods.TransportDirection.ROW));

        System.out.println("Zigzag         : "+ transportEncriptionMethods.TranspotZigzag(plainText));

        System.out.println("Zigzag Revers   : "+ transportEncriptionMethods.TranspotZigzag_Revers(plainText));


        System.out.println("Zigzag decripte   : "+ transportEncriptionMethods.TranspotZigzag_Revers(scanner.nextLine()));



    }
}
