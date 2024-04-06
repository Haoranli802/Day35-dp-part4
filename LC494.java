class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(Math.abs(target) > Math.abs(sum)) return 0;
        sum = sum + target;
        if(sum % 2 == 1) return 0;
        sum /= 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = sum; j >= nums[i]; j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}

/**
O(N * M), O(M)
 */
