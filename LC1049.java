class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i : stones) sum += i;
        int total = sum;
        sum = sum / 2;
        int[] dp = new int[sum + 1];
        for(int i = 0; i < stones.length; i++){
            for(int j = sum; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return total - 2 * dp[sum];
    }
}
//O(N^2), O(N)
