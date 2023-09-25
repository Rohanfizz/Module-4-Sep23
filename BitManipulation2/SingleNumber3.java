import java.util.*;

class Solution {
	public boolean checkKthBitSet(int n,int k){
		int mask = (1<<k);
		return (n & mask) != 0;
	}
    public int[] singleNumber3(int n, int[] nums) {
        // write code here

		int xorOfAll = 0;
		for(int x: nums) xorOfAll ^= x;
		//xorOfAll = a^b, where a and b are the unique elements of the array
		//we dont know what a and b are
		//but we do have their xor value, which can help us in identifying 
		//the kth bit where both a and b have different bits
		//lets calculate the value of position "k" where a and b are having diff bits
		int k = 0;
		while( (xorOfAll & 1) == 0){
			k++;
			xorOfAll >>= 1;
		}

		//now i know on which bit a and b act differently
		//Now  i want  to divide all the people into 2 groups
		int kthBitSet = 0;
		int kthBitNotSet =0;

		for(int x: nums){
			if(checkKthBitSet(x,k)) kthBitSet^= x;
			else kthBitNotSet^=x;
		}
		int[] res = new int[2];
		res[0] = kthBitSet;
		res[1] = kthBitNotSet;
		Arrays.sort(res);
		return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        int[] ans = Obj.singleNumber3(n, arr);
        System.out.print(ans[0] + " " + ans[1]);
    }
}