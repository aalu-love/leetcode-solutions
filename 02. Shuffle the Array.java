class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int[] arr = new int[n * 2];
        int j=1;
        int k=n;

        if(n==1) return nums;

        for (int i = 0; i < n*2;i+=2) {
            arr[i] = nums[j-1];
            arr[i+1] = nums[k];
            j++;
            k++;
        }

        return arr;
    }
}