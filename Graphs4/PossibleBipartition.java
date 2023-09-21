import java.util.*;

class Solution {

	public class Pair{
		int  node;
		int color;
		//color = 1 ,  blue
		//color = 0 ,  colorless
		//color = -1,  red
		Pair(int node,int color){
			this.node = node;
			this.color = color;
		}
		
	}
   
    public int possibleBipartition(int n, int[][] edges) {
        // Write your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i =  0;i<=n;i++){
			//i have inserted n+1 arraylists, because graph is 1 based indexing
			graph.add(new ArrayList<>()); 
		}
		for(int[] edge:edges){
			int u = edge[0];
			int v= edge[1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		int[] vis = new int[n+1];
		Queue<Pair> q = new LinkedList<>();

		for(int i = 1;i<=n;i++){
			if(vis[i] == 0){
				q.add(new Pair(i,1));

				while(q.size() > 0){
					Pair curr = q.remove();
					if(vis[curr.node] != 0) continue;
					vis[curr.node] = curr.color;
		
					int OpColor = curr.color == 1 ? -1 : 1;
		
					//Now will go to my nbrs and try to color them with the opColor
					for(int nbr: graph.get(curr.node)){
						if(vis[nbr] == 0){
							//If nbr is colorless
							q.add(new Pair(nbr,OpColor));
						}else  if(vis[nbr] != OpColor) return 0;
					}
				}
			}
		}
		return 1;
		
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}