public class StringBuilderC {

    public static void compressString(StringBuilder strB) {

        StringBuilder strE = new StringBuilder("");

        for (int i = 0; i<strB.length() ; i++) {
            strE.append(strB.charAt(i));
            Integer count = 1;


            //counting count
            while (i<strB.length() - 1 && strB.charAt(i) == strB.charAt(i+1)) {
                count++;
                i++;
            }

            if (count > 1) {
                strE.append(count.toString());
            }
        } System.out.println(strE);
    }

    public static void toUpperC(StringBuilder strB) {

        StringBuilder strE = new StringBuilder("");
        char currStr = Character.toUpperCase(strB.charAt(0));

        strE.append(currStr);

        for (int i = 1 ; i<strB.length() ; i++) {
            
            // currStr = strB.charAt(i);

            // // if (currStr == ' ') {
            // //     strE.append(currStr);
            // //     currStr = Character.toUpperCase(strB.charAt(i+1));
            // //     strE.append(currStr);
            // //     i = i + 2;
            // // } else {
            // //     strE.append(currStr);
            // //     i++;
            // // }          

            if (strB.charAt(i) == ' ' && i<strB.length() - 1 ) {
                strE.append(strB.charAt(i));
                i++;
                strE.append(Character.toUpperCase(strB.charAt(i)));
            } else {
                strE.append(strB.charAt(i));
            }
        }
        System.out.println(strE);
    }

    public static void appendString(StringBuilder strB) {
        for (char ch = 'A' ; ch <= 'Z' ; ch++) {
            strB.append(ch);
        } System.out.println(strB);
    }
    public static void main(String args[]) {
        StringBuilder name = new StringBuilder("");
        StringBuilder sent = new StringBuilder("aaaabbbcddddeefff");

        // compressString(sent);
        toUpperC(sent);
        appendString(name);
    }
}