import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Arrays.sort(nums);
        int[] n = new int[nums.length];
        List<Integer> j = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            n[nums[i] - 1] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (n[i] == 0) {
                j.add(i + 1);
            }
        }

        return j;
    }
}