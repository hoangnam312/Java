class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,1,0,1,1,1};

        System.out.println(
            solution.findMaxConsecutiveOnes(nums)
        );
    }
}

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
