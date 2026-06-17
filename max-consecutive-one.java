class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 0, 1, 1, 1, 0, 0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int keepCount = 0;
        for (int i : nums) {
            if (i == 1) {
                keepCount++;
                if (keepCount > maxCount) maxCount = keepCount;
            } else {
                if (keepCount > maxCount) maxCount = keepCount;
                keepCount = 0;
            }
        }
        return maxCount;
    }
}