import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{

	public static boolean checkIthBitIsSet(int n,int k){
		int mask = (1<<k);
		return (n & mask) != 0;
	}
	
    public static int singleNumber(int[] nums) {
    // Your code here
		int[] bitFreq = new int[32];
		for(int i = 0;i<32;i++){
			for(int x: nums){
				if(checkIthBitIsSet(x,i)) bitFreq[i]++;
			}
		}

		int pow = 1;
		int ans = 0;
		for(int i = 0;i<32;i++){
			if(bitFreq[i]%3 != 0) ans+=pow;
			pow*=2;
		}
		return ans;
}
}
public class Main {
  public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Solution.singleNumber(nums));
	}
}