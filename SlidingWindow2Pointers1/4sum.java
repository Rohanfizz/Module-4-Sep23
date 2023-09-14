class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      Arrays.sort(nums);
      List<List<Integer>> ans = new  ArrayList<>();
      int n = nums.length;

      int i = 0;
      while(i<n){
        int j = i+1;
        while(j<n){
          long newTarget =1L*( 1L*target - 1L*nums[i] - 1L*nums[j]);

          int l = j+1;
          int r = n-1;
          
          while(l<r){
            long currSum = (long)(1L*nums[l] + 1L*nums[r]);
            if(currSum == newTarget){
              //I have found a quadruplet
                System.out.println(currSum +" "+newTarget);
              List<Integer> currQuad = new ArrayList<>();
              currQuad.add(nums[i]);
              currQuad.add(nums[j]);
              currQuad.add(nums[l]);
              currQuad.add(nums[r]);

              ans.add(currQuad);

              int currL = nums[l];
              while(l<r && nums[l] == currL) l++;
                
              int currR = nums[r];
              while(r>l && nums[r] == currR) r--;
            }else if(currSum < newTarget){
              int currL = nums[l];
              while(l<r && nums[l] == currL) l++;
            }else{
              int currR = nums[r];
              while(r>l && nums[r] == currR) r--;
            }


          }
          int currJ = nums[j];
          while(j<n && nums[j] == currJ) j++;
        }
        int currI = nums[i];
        while(i<n && nums[i] == currI) i++;//this will ensure that i comes on a new value
      }
      return ans;
    }
}