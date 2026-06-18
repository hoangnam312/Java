class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int keepCount = 0;

        for (int num : nums) {
            if (num == 1) {
                keepCount++;
                maxCount = Math.max(maxCount, keepCount);
            } else {
                keepCount = 0;
            }
        }

        return maxCount;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,1,0,1,1,1};

        System.out.println(
            solution.findMaxConsecutiveOnes(nums)
        );
    }
}