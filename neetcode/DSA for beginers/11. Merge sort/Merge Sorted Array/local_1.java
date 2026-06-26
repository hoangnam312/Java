import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        test(
                new int[] { 1, 2, 3, 0, 0, 0 },
                3,
                new int[] { 2, 5, 6 },
                3);

        test(
                new int[] { 1 },
                1,
                new int[] {},
                0);

        test(
                new int[] { 0 },
                0,
                new int[] { 1 },
                1);

        test(
                new int[] { 4, 5, 6, 0, 0, 0 },
                3,
                new int[] { 1, 2, 3 },
                3);

        test(
                new int[] { 1, 2, 3, 5, 7, 9, 11, 0, 0, 0, 0 },
                7,
                new int[] { 5, 6, 8,10 },
                4);
    }

    private static void test(int[] nums1, int m, int[] nums2, int n) {
        Solution.merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}

class Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0)
            return;
        if (nums1[m - 1] <= nums2[0]) {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
            return;
        }
        

        int i = m - 1;
        int j = n - 1;
        int k = m + n -1;
        // stop condition:
        // i, j < 0
        // nums1[i] <= nums2[0]
        // j == 0 && nums1[i] <= nums2[j]
        while (i >= 0 && j >= 0 && k >= 0 && nums1[i] >= nums2[0] ) {
            // System.out.println("k: " + k + " -- i: " + i + "  nums1[i]: " + nums1[i] + "  |  j: " + j + "  nums2[j]: " + nums2[j]);
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        if (j >= 0) {
            for (int l = 0; l <= j; l++)
            nums1[l] = nums2[l];
        }
    }

}