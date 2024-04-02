class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum % 2 != 0) return false;
        sum = sum / 2;
        int[] dp = new int[sum + 1];
        for(int i = 0; i < nums.length; i++){
            for(int j = sum; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if(dp[sum] == sum) return true;
        }
        
        return dp[sum] == sum;
    }
}
//O(N^2), O(N)
