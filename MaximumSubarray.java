public class MaximumSubarray {
  /*
  * Find the contiguous subarray within an array (containing at least one
  *  number) which has the largest sum.
  * param: int[] nums
  * output: maximum contiguous subarray
  */
  public int maxSubArray(int[] nums) {
    if(nums == null || nums.length == 0) {
        return 0;
    }
    int max = nums[0];
    int curMax = nums[0];
    for (int index = 1; index < nums.length; index++) {
        if(curMax < 0) {
            curMax = 0;
        }
        curMax += nums[index];
        if(curMax > max) {
            max = curMax;
        }
    }
    return max;
  }
}
