import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

	public static class Pair{
		TreeNode node;
		int state;
		Pair(TreeNode  node,int state){
			this.node = node;
			this.state = state;
		}
	}

	public static TreeNode getNextInorder(Stack<Pair> st){
		while(st.size() > 0){
			Pair top = st.peek();
			if(top.state == 1){
				//PRE	
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left,1));
			}else if(top.state == 2){
				//IN
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right,1));
				return top.node;
			}else{
				//POST
				st.pop();
			}
		}
		return null;
	}
	
    public static void recoverTree(TreeNode root) {
        //Write code here
		if(root == null) return;
		if(root.left == null && root.right == null) return;
		Stack<Pair> st = new Stack<>();
		//To start dfs, i need to push (root,1) into stack
		if(root != null) st.push(new Pair(root,1));
		// [3, 2, 4, 5]

		TreeNode curr = getNextInorder(st);//this returns 1st person in inorder
		TreeNode prev = curr;// prev is standing on the first  person
		curr = getNextInorder(st);//curr has moved on the 2nd person in in order
		//prev = 1st, curr = 2nd
		TreeNode a = null;
		TreeNode b = null;

		while(curr != null){
			if(prev.val > curr.val){
				if(a == null){//First bad pair
					a = prev;
					b = curr;
				}else{ //Second bad pair
					b = curr;
				}
			}
			prev= curr;
			curr = getNextInorder(st);
		}
		int temp = a.val;
		a.val = b.val;
		b.val = temp;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}