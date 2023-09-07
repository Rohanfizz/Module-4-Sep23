
import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){
        
    }
    BST(Node root){
        root=root;
    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.val == val)
            return root;
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    void print(Node root){
        System.out.print(root.val + " ");
        if(root.left != null){
            print(root.left);
        }
        if(root.right != null){
            print(root.right);
        }
    }
}

class Solution{

	public int min(Node root){
		if(root.left == null) return root.val;
		return min(root.left);
	}
	
    public Node deleteNode(Node root, int val){
        // WRITE YOUR CODE HERE
		if(root == null) return null;
		if(root.val  ==  val){
			
			//I am standing on the person i want to delete
			//Case 1 - leaf
			if(root.left  == null && root.right == null){
				return null;
			}else if(root.left != null && root.right == null){ //Case 2 - left child only
				return root.left;
			}else if(root.left == null && root.right != null){ //Case 3 - right child only
				return root.right;
			}
			//Both the children are present
			// I want  to search for a candidate which can replace me
			//left subtree's max and right subtree's min are both valid candidates
			int rMin = min(root.right);
			root.val = rMin;
			// Now ill be having 2 nodes with val = rMin, I want to delete the one in the right subtree
			root.right = deleteNode(root.right,rMin);
			
		}else if(val > root.val){
			Node updatedRight = deleteNode(root.right,val);
			root.right= updatedRight;
		}else{
			Node updatedLeft = deleteNode(root.left,val);
			root.left = updatedLeft;
		}
		return root;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        Solution obj=new Solution();
        t.root= obj.deleteNode(t.root, k);
        t.print(t.root);
    }
}