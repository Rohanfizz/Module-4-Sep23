
class Solution {
    public TreeNode construct(int[] nums,int l,int r){
        if( l > r) return null;
        int  mid = (l+r)/2;
        TreeNode me = new  TreeNode(nums[mid]);
        me.left = construct(nums,l,mid-1);
        me.right = construct(nums,mid+1,r);
        return me;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums,0,nums.length-1);
    }
}