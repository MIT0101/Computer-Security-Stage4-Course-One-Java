package Transpostion;

public class TransportEncriptionMethods {
    static String SPACE_SPLITER=" ";
    static char SPACE_REPLACE='$';
    private String plainText;
    private String key;

    /****************************------------Geomatric  Methods-----------***********************************/

    /****************************------------zigzag revers-----------***********************************/
    public String TranspotZigzag_Revers(String plainText) {

        StringBuilder reversBulider=new StringBuilder();
        reversBulider.append(plainText);

        return this.TranspotZigzag(reversBulider.reverse().toString());

    }

    /****************************------------zigzag Decripte (Not Working)-----------***********************************/
    public String TranspotZigzag_Decripte(String cipherText) {
        StringBuilder result=new StringBuilder();
        cipherText=cipherText.replaceAll(SPACE_SPLITER,"");


        for (int i = 0; i < cipherText.length(); i+=2) {
            result.append(cipherText.charAt(i));
        }

        for (int i = 1; i < cipherText.length(); i+=2) {
            result.append(cipherText.charAt(i));
        }

        return result.toString();

    }

    /****************************------------zigzag Strate-----------***********************************/
    public String TranspotZigzag(String plainText) {
        StringBuilder result=new StringBuilder();
        plainText=plainText.replaceAll(SPACE_SPLITER,"");

        for (int i = 0; i < plainText.length(); i+=2) {
            result.append(plainText.charAt(i));
        }

        for (int i = 1; i < plainText.length(); i+=2) {
            result.append(plainText.charAt(i));
        }

        return result.toString();

    }

    /****************************------------NEW Row-----------***********************************/

    public String TranspotBYRow_New(String plainText,String key) {
        StringBuilder result = new StringBuilder();

        plainText = plainText.replaceAll(SPACE_SPLITER, "");
        char[] keyArr = key.toCharArray();
        int rowCount = key.length();
        int columCount = plainText.length() / rowCount;

        if (columCount * rowCount < plainText.length()) {
            columCount += 1;
        }

            for (char singleKey:keyArr) {
                int start = (Integer.parseInt(singleKey + "") - 1) *columCount;
                for (int i = 0; i < columCount; i++) {
                    char charTodAdd;
                    if(start>=plainText.length()){
                        charTodAdd=SPACE_REPLACE;
                    }else{
                        charTodAdd=plainText.charAt(start);
                    }
                    start+=1;
                    result.append(charTodAdd);

                }
            }


        return result.toString();

    }
    /****************************------------NEW Column-----------***********************************/

    public String TranspotBYColumn_New(String plainText,String key) {
        StringBuilder result = new StringBuilder();

        plainText = plainText.replaceAll(SPACE_SPLITER, "");
        char[] keyArr = key.toCharArray();
        int columCount = key.length();
        int rowCount = plainText.length() / columCount;

        if (columCount * rowCount < plainText.length()) {
            rowCount += 1;
        }

//        char[][] cipherTextArr = new char[rowCount][columCount];

        int rowLeft=0;

        for (int currentRow = 0; currentRow < rowCount; currentRow++) {
            //now i am in single row
            //now single row process
            for (char singleKey:keyArr) {
                int start = Integer.parseInt(singleKey + "") - 1 + rowLeft;

                char charTodAdd;
                if(start>=plainText.length()){
                    charTodAdd=SPACE_REPLACE;
                }else{
                    charTodAdd=plainText.charAt(start);
                }

                result.append(charTodAdd);
            }
            rowLeft+=columCount;

        }


        //below we will get cipher array
//        int mainColIndex=0;
//        for (char singleKey:keyArr) {
//            int start=Integer.parseInt(singleKey+"")-1;
//            for (int i = 0; i <rowCount ; i++) {
//                char charTodAdd;
//                if(start>=plainText.length()){
//                    charTodAdd=SPACE_REPLACE;
//                }else{
//                    charTodAdd=plainText.charAt(start);
//                }
//                cipherTextArr[i][mainColIndex]=charTodAdd;
//                start+=columCount;
//            }
//            mainColIndex++;
//        }


        return result.toString();

    }
    /****************************------------old row-----------***********************************/
    //by row
    public String TranspotBYRow(String plainText,String key){
        StringBuilder result=new StringBuilder();

        plainText=plainText.replaceAll(SPACE_SPLITER,"");
        char[] keyArr=key.toCharArray();
        int columCount=key.length();
        int rowCount=plainText.length()/columCount;

        if(columCount*rowCount< plainText.length()){
            rowCount+=1;
        }

        //here swap
        rowCount=rowCount+columCount;
        columCount=rowCount-columCount;
        rowCount=rowCount-columCount;

        char[][] plainTextArr =new char[rowCount][columCount];
        //move data to arr
        int textIndex=0;
        char currentChar;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columCount; j++) {
                if(textIndex==plainText.length()){
                    currentChar=SPACE_REPLACE;
                }
                else {
                    currentChar=plainText.charAt(textIndex);
                    textIndex++;
                }
                plainTextArr[i][j]=currentChar;
            }
        }

        char[][] cipherTextArr =new char[rowCount][columCount];


        int cipherRowIndex=0;
        for (char ch:keyArr) {
            int toGetRow=Integer.parseInt(ch+"")-1;
            for (int i = 0; i < columCount; i++) {
                cipherTextArr[cipherRowIndex][i]=plainTextArr[toGetRow][i];
            }
            cipherRowIndex++;
        }
        for (char[] row:cipherTextArr) {
            for (char charInCol:row) {
                result.append(charInCol);
            }
        }



        return result.toString();
    }

    /****************************------------old Column-----------***********************************/
    //by colum
    public String TranspotBYColumn(String plainText,String key){
        StringBuilder result=new StringBuilder();

       plainText=plainText.replaceAll(SPACE_SPLITER,"");
       char[] keyArr=key.toCharArray();
        int columCount=key.length();
        int rowCount=plainText.length()/columCount;

        if(columCount*rowCount< plainText.length()){
            rowCount+=1;
        }

        char[][] plainTextArr =new char[rowCount][columCount];
        //move data to arr
        int textIndex=0;
        char currentChar;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columCount; j++) {
                if(textIndex==plainText.length()){
                    currentChar=SPACE_REPLACE;
                }
                else {
                    currentChar=plainText.charAt(textIndex);
                    textIndex++;
                }
                plainTextArr[i][j]=currentChar;
            }
        }

        char[][] cipherTextArr =new char[rowCount][columCount];


        int cipherColIndex=0;
        for (char ch:keyArr) {
            int toGetColum=Integer.parseInt(ch+"")-1;
            for (int i = 0; i < rowCount; i++) {
                cipherTextArr[i][cipherColIndex]=plainTextArr[i][toGetColum];
            }
            cipherColIndex++;
        }
        for (char[] row:cipherTextArr) {
            for (char charInCol:row) {
                result.append(charInCol);
            }
        }
        
        return result.toString();
    }

    /****************************------------old Type-----------***********************************/
    //by row
    public String TranspotEn(String plainText,String key,TransportDirection transportDirection){
        StringBuilder result=new StringBuilder();

        plainText=plainText.replaceAll(SPACE_SPLITER,"");
        char[] keyArr=key.toCharArray();
        int columCount=key.length();

        int rowCount=plainText.length()/columCount;

        if(columCount*rowCount< plainText.length()){
            rowCount+=1;
        }
        if(transportDirection==TransportDirection.ROW){
            //here swap
            rowCount=rowCount+columCount;
            columCount=rowCount-columCount;
            rowCount=rowCount-columCount;
        }

        char[][] plainTextArr =new char[rowCount][columCount];
        //move data to arr
        int textIndex=0;
        char currentChar;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columCount; j++) {
                if(textIndex==plainText.length()){
                    currentChar=SPACE_REPLACE;
                }
                else {
                    currentChar=plainText.charAt(textIndex);
                    textIndex++;
                }
                plainTextArr[i][j]=currentChar;
            }
        }

        char[][] cipherTextArr =new char[rowCount][columCount];

        int cipherdimantionIndex=0;
        int dimationStoper=rowCount;
        if(transportDirection==TransportDirection.ROW){
            dimationStoper=columCount;
        }
        DirectionAction directionAction;
        if(transportDirection==TransportDirection.COLUMN){
          directionAction=new DirectionAction() {
              @Override
              public void addToCipher(int i, int cipherdimantionIndex, int toGetDimantion, char[][] plainTextArr, char[][] cipherTextArr) {
                  cipherTextArr[i][cipherdimantionIndex]=plainTextArr[i][toGetDimantion];

              }
          };

        }else{
        directionAction=new DirectionAction() {
            @Override
            public void addToCipher(int i, int cipherdimantionIndex, int toGetDimantion, char[][] plainTextArr, char[][] cipherTextArr) {
                cipherTextArr[cipherdimantionIndex][i]=plainTextArr[toGetDimantion][i];

            }
        };
        }

        for (char ch:keyArr) {
            int toGetDimantion=Integer.parseInt(ch+"")-1;
            for (int i = 0; i < dimationStoper; i++) {

//                //colum
//                cipherTextArr[i][cipherdimantionIndex]=plainTextArr[i][toGetDimantion];
//                //row
//                cipherTextArr[cipherdimantionIndex][i]=plainTextArr[toGetDimantion][i];
                directionAction.addToCipher(i,cipherdimantionIndex,toGetDimantion,plainTextArr,cipherTextArr);

            }
            cipherdimantionIndex++;
        }
        for (char[] row:cipherTextArr) {
            for (char charInCol:row) {
                result.append(charInCol);
            }
        }

        return result.toString();
    }


public static enum TransportDirection{
        COLUMN,
        ROW
}
private interface DirectionAction{
   void addToCipher(int i,int cipherdimantionIndex,int toGetDimantion,char[][] plainTextArr,char[][] cipherTextArr);
}
}
