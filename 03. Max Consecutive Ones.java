class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int Max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
                Max = Math.max(count, Max);
            } else {
                count = 0;
            }
        }
        return Max;

    }
}