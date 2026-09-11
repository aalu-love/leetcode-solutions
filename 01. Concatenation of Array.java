import java.util.Arrays;

class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] b = Arrays.copyOf(nums, 2 * nums.length);
        System.arraycopy(nums, 0, b, nums.length, nums.length);
        return b;
    }
}

// Easy analogy 🧠
// Imagine moving 100 boxes.
// For loop:
// You carry each box one by one.
// arraycopy():
// You use a truck to move all 100 boxes together. 🚚
// Both move 100 boxes, so both are O(n), but the truck is faster.
// That's basically why System.arraycopy() is faster.