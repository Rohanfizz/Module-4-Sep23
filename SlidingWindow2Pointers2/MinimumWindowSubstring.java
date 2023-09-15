import java.io.*;
import java.util.*;
//https://course.acciojob.com/idle?question=8c817174-62b5-46e8-8cf7-00cc0d0ffa47
class Solution {

	public boolean isValid(HashMap<Character,Integer> ideal,HashMap<Character,Integer> curr){
		for(char key: ideal.keySet()){
			if(!curr.containsKey(key)) return false;
			else if(curr.get(key) < ideal.get(key)) return false;
		}
		return true;
	}
	
    public String minWindow(String s, String t) {
		// write code here
		int ansLen = Integer.MAX_VALUE;
		String ans = "";

		int sp= 0;
		int ep = 0;

		HashMap<Character,Integer> ideal = new HashMap<>();
		HashMap<Character,Integer> curr = new HashMap<>();

		//lets populate ideal hashmap
		for(int i = 0;i<t.length();i++){
			char c = t.charAt(i);
			ideal.put(c,ideal.getOrDefault(c,0) + 1);
		}

		while(ep<s.length()){
			//introduce
			char currChar = s.charAt(ep);
			curr.put(currChar,curr.getOrDefault(currChar,0) + 1);

			while(isValid(ideal,curr)){
				//UPDATE ANSWER
				if(ansLen > (ep-sp+1)){
					ansLen  = ep-sp+1;
					ans = s.substring(sp,ep+1);
				}
				//SHRINK
				curr.put(s.charAt(sp) , curr.get(s.charAt(sp)) - 1);
				sp++;
			}

			ep++;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}