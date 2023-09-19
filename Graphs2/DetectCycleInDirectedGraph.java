import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

	public boolean dfs(ArrayList<Integer>[] graph,boolean[] vis,boolean[] path,int curr){
		//Mark
		path[curr] = true;
		vis[curr] = true;

		//Work - nothing
		//Try to visit any unvisited nbrs
		for(int nbr:graph[curr]){
			if(path[nbr]) return true;
			else if(!vis[nbr]){
				boolean isCyclic = dfs(graph,vis,path,nbr);
				if(isCyclic) return true;
			}
		}
		//Unmark the path array
		path[curr] = false; //the snake is backtracking
		return false;
	}
	
public boolean isCyclic(int V, ArrayList<Integer>[] graph) {
		// Your code here
		boolean[] vis = new boolean[V];
		boolean[] path = new boolean[V];
		//The graph can have multiple components
		//This meeans, Ill apply dfs on all unvisited nodes
		for(int src = 0;src<V;src++){
			if(!vis[src]){
				//Try to find a cycle in the component where src is treated as the src
				boolean isCyclic = dfs(graph,vis,path,src);
				if(isCyclic) return true;
			}
		}
		return false;
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}