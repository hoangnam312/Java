class Solution {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[i] == val && nums[j] != val) {
                nums[i] = nums[j];
                nums[j] = val;
            }
            if (nums[i] != val) i = i + 1;
            j = j + 1;
        }
        
        return i;
    }
}