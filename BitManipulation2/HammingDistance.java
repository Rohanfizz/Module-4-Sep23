import java.util.*;

class Accio{
	static  int countSetBits(int n) {
        // write code here
		int count = 0;
		while(n > 0){
			if( (n & 1) == 1) count++;
			n = n>>1;
		}
		return count;
    }
    static int HammingDistance(int a,int b){
        //write code here
		int xor = a^b;
		return acc.countSetBits(xor);
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Accio obj = new Accio();
        int ans=obj.HammingDistance(a,b);
        System.out.println(ans);
    }
}
