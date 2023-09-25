import java.util.*;
class Solution
{
       static int xorSubarrayXors(int arr[], int n) {
        //Write code here
		   int ans = 0;
		   for(int i = 0;i<n;i++){
			   int validSP = (i+1);
			   int validEP = (n-i);
			   int contrib = validSP * validEP;//ith element comes in these many subarrays
			   if(contrib % 2 != 0) ans ^= arr[i];
		   }
		   return ans;
    }
}
public class Main {

    

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int ans = Solution.xorSubarrayXors(arr, n);
        System.out.print(ans);
        input.close();
    }
}