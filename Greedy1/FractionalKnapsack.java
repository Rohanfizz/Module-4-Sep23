import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
		// Write your code here
		//Sorting in desc order on the basis of 1 unit value
		Arrays.sort(arr,(a,b)->{
			double pwa = (1.0*a.value / (1.0*a.weight));
			double pwb = (1.0*b.value / (1.0*b.weight));
			return pwb<=pwa?-1:1;
		});
// A < B => +VE
// A > B => -VE
		double totalProfit = 0.0;
		int remCap = W;

		for(Item item: arr){
			if(item.weight < remCap){//fully accomodate this item
				totalProfit += item.value;
				remCap-=item.weight;
			}else{
				//i have to break the item
				double priceOf1Unit = 1.0*item.value / (1.0*item.weight);
				double profitAfterBreaking = priceOf1Unit * remCap;
				totalProfit +=profitAfterBreaking;
				remCap = 0; 
				break;
			}
		}
		return totalProfit;
		
    }
}











