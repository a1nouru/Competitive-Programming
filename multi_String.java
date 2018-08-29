
public class Main {

    public static String multString(String num1, String num2){
        if(num1.length() == 0 || num2.length() == 0) return "";
        else if(num1 == "0" || num2 == "0") return "0";
        
        //reverse string, so to calculate from 0 base. easier to calculate
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();
        
        //product array. extra leading space for carriers
        //normally just need num1.length() + num2.length() -1
        int [] product = new int[num1.length() + num2.length()];

        for (int i = 0; i<num1.length(); i++){
            int chr1 = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++){
                int chr2 = num2.charAt(j) - '0';
                product[i+j] += chr1*chr2;
            }
        }

        //calcualte and output
        //remember, now the string is reversed calculated. 
        //so every time, add to index 0. so it will all reverse back; OR, append, and reverse later.
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < product.length; i++){
            int number = product[i] % 10;
            int carrie = product[i] / 10;

            sb.append(number);
            if(i < product.length - 1)
                product[i + 1] += carrie;
        }
        sb.reverse();

        //trim leading 0's
        while(sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.reverse().toString();
    }

    public static void main(String [] args){
        String num1 ="13";
        String num2 = "2";
        num1 = new StringBuffer(num1).reverse().toString();

        int [] product = new int[num1.length()];
        System.out.println(multString(num1,num2));
    }
}
