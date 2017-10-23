class HouseRober {
  /*
  * Given a list of non-negative integers representing the amount of money of
  * each house, determine the maximum amount of money you can rob tonight
  * without alerting the police.
  * param: int[] nums
  * output: maximum amount of money
  */
  public int rob(int[] nums) {
    if(nums == null || nums.length == 0) {
        return 0;
    }

    int size = nums.length;
    int[] dp = new int[size];
    dp[0] = nums[0];
    for(int houseIndex = 1; houseIndex < size; houseIndex++) {
        dp[houseIndex] = Math.max(dp[houseIndex-1], nums[houseIndex] + (houseIndex < 2 ? 0 : dp[houseIndex-2]));
    }
    return dp[size - 1];
  }
}
