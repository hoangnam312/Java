class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;

        for (int num : nums) {
            count = num == 1 ? count + 1 : 0;
            if (count > maxCount) maxCount = count;
        }

        return maxCount;
    }
}
