class SortColors {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        for(int i = 0; i <= twoIndex; i++) {
            if(nums[i] == 0) {
                swap(nums, zeroIndex++, i);
            } else if(nums[i] == 2) {
                swap(nums, twoIndex--, i--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
