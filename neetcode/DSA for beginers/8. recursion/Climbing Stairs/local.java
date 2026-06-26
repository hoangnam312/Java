class Main {
    public static void main(String[] args) {
        test(1);
        test(2);
        test(3);
        test(4);
        test(5);
    }

    private static void test(int n) {
        Solution solution = new Solution();

        int result = solution.climbStairs(n);

        System.out.println(
                "n = " + n +
                ", result = " + result);
    }
}

class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
