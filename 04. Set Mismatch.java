class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] n = new int[nums.length];
        int[] res = new int[2];
        int d = 0;
        int m = 0;

        for (int i = 0; i < nums.length; i++) {
            if (n[nums[i] - 1] == -1) {
                d = nums[i];
            }
            n[nums[i] - 1] = -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (n[i] == 0) {
                m = i + 1;
            }
        }
        res[0] = d;
        res[1] = m;

        return res;
    }
}