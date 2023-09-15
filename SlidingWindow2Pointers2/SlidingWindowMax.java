import java.util.*;
//https://course.acciojob.com/idle?question=2da7ad22-cccc-497d-864c-a3ea784e1263
class Solution{
    static int[] SlidingWindowMaximum(int N, int k, int[] arr){
        // write code here
		ArrayList<Integer> ans = new ArrayList<>();

		Deque<Integer> dq = new ArrayDeque<>();
		//for the 0th window, i will have to manually calculate the answer
		//why? because the window size is fixed in this question
		//Consider the first k elements
		for(int i = 0;i<k;i++){
			while(dq.size() > 0 && arr[dq.getLast()] < arr[i]) dq.removeLast();
			dq.addLast(i);
		}
		ans.add(arr[dq.getFirst()]);

		//lets start calculating answer for the rest of the people
		int sp = 1;
		int ep = k;

		while(ep<N){
			while(dq.size() >0 && arr[dq.getLast()] < arr[ep]) dq.removeLast();
			dq.addLast(ep);

			//we will try to remove the front people if they are not inside the curr window
			while(dq.getFirst() < sp) dq.removeFirst();
			
			ans.add(arr[dq.getFirst()]);

			sp++;
			ep++;
		}

		int[] res = new  int[ans.size()];
		for(int i =0;i<ans.size();i++){
			res[i] = ans.get(i);
		}
		return res;
		
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
