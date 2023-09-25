import java.util.*;

class bitsPrinter{
    //This function prints all the 32 bits of an integer
    public static void printer(int n){
        String s = "";
        for(int i = 0;i<32;i++){
            if((n & 1) == 1) s = "1" + s;
            else s = "0" + s;
            n>>=1;
        }
        System.out.println(s);
    }

    public static void main(String[] args){
        printer(-1);
        // System.out.println(Integer.MIN_VALUE-1);
    }
}