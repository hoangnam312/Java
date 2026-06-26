import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        test(
                new int[]{1, 2, 3, 0, 0, 0},
                3,
                new int[]{2, 5, 6},
                3
        );

        test(
                new int[]{1},
                1,
                new int[]{},
                0
        );

        test(
                new int[]{0},
                0,
                new int[]{1},
                1
        );

        test(
                new int[]{4, 5, 6, 0, 0, 0},
                3,
                new int[]{1, 2, 3},
                3
        );
    }

    private static void test(int[] nums1, int m, int[] nums2, int n) {
        Solution.merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}

class Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] arr = new int[m + n];
        while (k < m + n) {
            // System.out.println("i " + i + "  j " + j + "  k " + k);
            if (i == m) {arr[k++] = nums2[j++]; continue;} 
            if (j == n) {arr[k++] = nums1[i++]; continue;}
            if (nums1[i] < nums2[j]) arr[k++] = nums1[i++]; else arr[k++] = nums2[j++];
            // k++;
        }
        k = 0;
        while (k < m + n) {
            // System.out.println("k " + k);
            nums1[k] = arr[k++];
        }
    }

}