class Solution {
    public int[] plusOne(int[] digits) {
        int c = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            // 158, 123, 114
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // 199, 149, 79, 999, 99, 9
            if (digits[i] == 9) {
                digits[i] = 0;
                c = 1;
            }
            if (i == 0 && c > 0) {
                int[] arr = new int[digits.length + 1];
                arr[0] = 1;
                return arr;
            }
        }
        return digits;
    }
}