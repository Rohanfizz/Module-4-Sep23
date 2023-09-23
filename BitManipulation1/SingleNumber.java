

import java.util.*;

class Solution {
    public void singleElement(int[]A,int n) {
        //Write code here and print output
         int xorAll = 0;
		for(int i = 0;i<n;i++) xorAll ^= A[i];
		System.out.println(xorAll);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
                A[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.singleElement(A,n);
        sc.close();
    }
}

