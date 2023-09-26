import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) {
    // Write your code here
		Collections.sort(A,(a,b)->{
			return a.get(0) - b.get(0);
		});

		int count = 0;
		int prevEnd = -1;

		for(List<Integer> interval: A){
			int  currStart = interval.get(0);
			int  currEnd = interval.get(1);

			//Now i have to check if the
			//current interval is overlapping with the
			//previous interval
			if(prevEnd < currStart){//Non-overlapping
				count++;
				prevEnd = currEnd;
			}else{//Overlapping
				//I have to choose between both of them
				//the interval having smaller EP is better
				if(prevEnd > currEnd){
					prevEnd = currEnd;
				}
			}
		}
		return count;
	}
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
