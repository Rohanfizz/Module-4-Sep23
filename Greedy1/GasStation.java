import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //Write code here
		int n = gas.length;
		
		int totalGas = 0;
		int totalCost = 0;

		for(int i = 0;i<n;i++){
			totalGas += gas[i];
			totalCost+= cost[i];
		}

		if(totalGas < totalCost) return -1;
		//If i am on this line of code
		//answer is possible
		int ansStartingPoint = -1;
		int tank = 0;
		for(int  i = 0;i<n;i++){
			tank = tank + gas[i] - cost[i];
			if(tank >=0 && ansStartingPoint==-1){
				ansStartingPoint = i;
			}else if(tank <0){//sp im having is wrong
				tank = 0;//reset the tank
				ansStartingPoint = -1;//I have not found any answer
			}
		}
		return ansStartingPoint;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = input.nextInt();
        for (int i = 0; i < n; i++)
            B[i] = input.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.canCompleteCircuit(A, B));
        input.close();
    }
}