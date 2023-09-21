import java.io.*;
import java.util.*;

class Solution {
	
	//This function checks if a component is cyclic or not using BFS
	public static boolean bfs(ArrayList<ArrayList<Integer>> graph,int src,boolean[] vis){
		Queue<Integer>  q = new LinkedList<>();
		q.add(src);
		while(q.size() > 0){
			//Remove
			int curr = q.remove();
			//Mark*
			if(vis[curr]) return true;//this is getting visited the 2nd time
			//We are return a true as we have detected a cycle
			vis[curr] = true;
			//Work - nothing
			//Add unvisited nbrs
			for(int nbr: graph.get(curr)){
				if(!vis[nbr]) q.add(nbr);
			}
		}
		return false;
	}
	
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
       // Your code 
		boolean[] vis = new boolean[V];
		
		for(int i= 0;i<V;i++){
			if(!vis[i]){
				//try to find cycle in this component
				//every unvisited node will be  treated as the source of its component
				boolean isCyclic = bfs(graph,i,vis)
				if(isCyclic) return true;//Cycle found
			}
		}
		
		return false;//Cycle not found
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}