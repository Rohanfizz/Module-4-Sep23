import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

	void dfs(List<List<Integer>> graph,boolean[] path,int node,List<Integer> psf){
		int N = graph.size()-1;
		path[node] = true;
		psf.add(node);
		//after adding node to psf
		if(psf.size() == N){
			System.out.print(psf);

			boolean isCycle = false;
			int originalSrc = psf.get(0);
			for(int nbr: graph.get(node)){
				if(nbr == originalSrc) isCycle = true;
			}

			if(isCycle) System.out.print(" (Cycle)");
			System.out.println();
		}
		
		for(int nbr: graph.get(node)){
			if(!path[nbr]) dfs(graph,path,nbr,psf);
		}

		path[node] = false;
		psf.remove(psf.size()-1);
	}
	
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // your code here
	    List<List<Integer>> graph = new ArrayList<>();
		for(int i = 1 ;i<=N+1;i++){
			graph.add(new ArrayList<>());
		}
		for(ArrayList<Integer> edge: Edges){
			int u = edge.get(0);
			int v = edge.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		
		boolean[] path = new boolean[N+1];
		for(int i = 1;i<=N;i++){
			List<Integer> psf = new ArrayList<>();
			dfs(graph,path,i,psf);
		}
		return true;//dummy;
		
    }
}











