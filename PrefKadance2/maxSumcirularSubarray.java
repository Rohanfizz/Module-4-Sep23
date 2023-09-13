class Solution {
    public int maxSubarraySumCircular(int[] arr) {
      int maxTrain = 0;
		int  maxSumSubarray = Integer.MIN_VALUE;

		int minTrain = 0;
		int minSumSubarray = Integer.MAX_VALUE;

		int total = 0;

		for(int i = 0;i<arr.length;i++){
			total+=arr[i];

			//Calc maxSumSubarray
			maxTrain = Math.max(arr[i],arr[i] + maxTrain);
			maxSumSubarray = Math.max(maxSumSubarray,maxTrain);

			//Calc minSumSubarray
			minTrain = Math.min(arr[i],arr[i]+minTrain);
			minSumSubarray = Math.min(minSumSubarray,minTrain);
		}

		//if all are -ve
		if(total == minSumSubarray) return maxSumSubarray;

		return Math.max(maxSumSubarray , total - minSumSubarray);

		
    }
}