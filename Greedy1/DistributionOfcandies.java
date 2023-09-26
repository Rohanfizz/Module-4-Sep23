import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	   
        int n=sc.nextInt(); 
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            arr.add(x);
        }
        
        Solution ob=new Solution();
        System.out.println(ob.candies(arr,n));
        
	}
}


class Solution {
    public int candies(ArrayList<Integer> A,int n) {
        //Write code here
		int[] left = new int[n];
		left[0]= 1;//0 is not having anyone in its left side
		for(int i = 1;i<n;i++){
			if(A.get(i-1) < A.get(i)) left[i] = left[i-1] + 1;
			else left[i] = 1;
		}

		int[] right = new  int[n];
		right[n-1] = 1;//n-1th idx will have any right nbr
		for(int i = n-2;i>=0;i--){
			if(A.get(i+1) < A.get(i)) right[i] = right[i+1] + 1;
			else right[i] = 1;
		}
		int total = 0;
		for(int i = 0;i<n;i++){
			total += Math.max(left[i],right[i]);
		}
		return total;
    }
}








