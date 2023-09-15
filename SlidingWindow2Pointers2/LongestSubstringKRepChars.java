import java.util.*;

class Solution {
//https://course.acciojob.com/idle?question=9be96ee1-cf8d-4bcc-936b-899f22782a7f
	public int longestSubstringXuniqueKrep(String s,int x,int k){
		int sp = 0;
		int ep = 0;

		int unique = 0;
		int numRepK = 0;

		HashMap<Character,Integer> hm = new HashMap<>();
		int ans = 0;
		while(ep<s.length()){
			char cep = s.charAt(ep);
			hm.put(cep,hm.getOrDefault(cep,0) + 1);

			if(hm.get(cep)==1) unique++;
			if(hm.get(cep)==k) numRepK++;

			//it is possible that due to addition of a char,
			//the window might have became invalid
			while(unique > x){
				char csp = s.charAt(sp);
				hm.put(csp,hm.get(csp) -1);

				//after decrementing
				if(hm.get(csp) == 0) unique--;
				if(hm.get(csp) == k-1) numRepK--;

				sp++;
			}
			//if im having exactly x unique characters
			//and all of those x characters are repeating k times
			if(unique == x && numRepK == x) ans = Math.max(ans,ep-sp+1);
			ep++;
		}
		return ans;
	}
	
    public int longestSubstring(String s, int k) {
        // write code here
		int ans = 0;
		for(int x = 1;x<=26;x++){
			ans = Math.max(ans,longestSubstringXuniqueKrep(s,x,k));
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
