import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    
	}
}

class Solution {
	public class  Node{
		char data;
		int freq;
		Node left;
		Node right;
		Node(char data,int freq){
			this.data = data;
			this.freq = freq;
			this.left = null;
			this.right = null;
		}
	}
    public ArrayList<String> huffmanCodes(String S, int f[], int N){
        // Code here
		//Create a pq of type node
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
			return a.freq < b.freq ? -1 : 1;
		});

		//Add everyone to the priority queue
		for(int i = 0;i<N;i++){
			pq.add(new Node(S.charAt(i),f[i]));
		}

		
		while(pq.size() > 1){
			//Remove top 2 least frequent nodes
			Node first = pq.remove();
			Node second = pq.remove();
			//Create a parent for these nodes
			Node nn = new Node('*',first.freq + second.freq);
			nn.left =first;//left-> smaller freq
			nn.right = second;//right-> larger freq

			pq.add(nn);
		}
		Node huffmanRoot = pq.remove();
		ArrayList<String> ans = new ArrayList<>();
		dfs(huffmanRoot,ans,"");
		return ans;
    }
	void dfs(Node node,ArrayList<String> ans,String psf){
		//null ptr
		if(node.data != '*'){
			ans.add(psf);
			return;
		}
		dfs(node.left,ans,psf+"0");
		dfs(node.right,ans,psf+"1");
		
		
	}
}




