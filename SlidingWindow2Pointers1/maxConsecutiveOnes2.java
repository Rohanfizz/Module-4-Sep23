import java.util.*;

class Solution {
    static int maxOne(int arr[], int n,int k){
        //Write your code here
		int ans = 0;
		int sp = 0;
		int ep = 0;
		int  numZeroes = 0;

		while(ep<n){
			//introduce new person
			if(arr[ep] == 0) numZeroes++;

			//it is possible that, due to addition of new person 
			//in the window, the window might become invalid
			//Step2 shrink while invalid
			while(numZeroes > k){
				if(arr[sp] == 0) numZeroes--;
				sp++;
			}

			//After the above loop, the window will become valid
			//Step3 consider window for answer
			 ans = Math.max(ans,ep-sp+1);
			//Step4 expand window
			ep++;
		}
		return ans;
		
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}