import java.util.*;

class Solution {
 
    @SuppressWarnings("unchecked")
    public int[] canFinish(int n, int[][] edges) {
		//Write your code here
		ArrayList<ArrayList<Integer>> graph = new  ArrayList<>();
		for(int  i = 0;i<n;i++) graph.add(new ArrayList<>());

		ArrayList<Integer> topo = new ArrayList<>();
		
		//Step 1: Calculate indegrees,  we are calculating while  adding edges
		int[] indegree = new  int[n];//indegree[i] = number of incoming edges for ith node
		
		for(int[] edge: edges){
			int ai = edge[0];
			int bi = edge[1];
			graph.get(bi).add(ai);//adding directed edge from bi -> ai
			indegree[ai]++;//ai is having another incoming  edge, so indegree[ai]++;
		}

		//Step 2: Add all the nodes to queue who are having indegree == 0
		Queue<Integer> q = new LinkedList<>();//this queue will maintain all the doable courses

		for(int i = 0;i<n;i++) if(indegree[i] == 0) q.add(i);
		
		//Step 3: Perform bfs and recuce indegree of nbrs along the way
		while(q.size()>0){
			int curr = q.remove();
			topo.add(curr);
			//I will reduce the dependency count of all my nbrs
			for(int nbr: graph.get(curr)){
				indegree[nbr]--;
				if(indegree[nbr] == 0){//this nbrs is having no more dependencies
					q.add(nbr);
				}
			}
		}
		if(topo.size() < n){
			//the topological sorting is not possible
			//the directed graph is having a cycle
			return new int[0];
		}

		int[] res= new int[n];
		for(int i = 0;i<n;i++) res[i] = topo.get(i);
		return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}