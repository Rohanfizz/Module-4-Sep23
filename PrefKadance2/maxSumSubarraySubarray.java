import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{
    public long maxSubarraySum(int a[],int n){
        //Write code here
		long maxi = Integer.MIN_VALUE;
		int  asp = -1;
		int  aep = -1;

		long train = 0;
		int csp = 0;
		int cep = 0;

		for(int i = 0;i<n;i++){
			long startNew = a[i];
			long prevTrain = train + a[i];

			if(startNew > prevTrain){
				csp = i;
				train = startNew;
			}else{
				train = prevTrain;
			}

			if(train > maxi){
				maxi = train;
				asp = csp;
				aep = cep;
			}
			cep++;
		}
		System.out.println(asp +" "+aep);
		return maxi;
		
		
    }
}






