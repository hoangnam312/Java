class Solution {
    public static int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        result[arr.length - 1] = -1;

        for (int i = arr.length - 1; i > 0; i--) {
            result[i - 1] = (arr[i] > result[i]) ? arr[i] : result[i];
        }

        return result;
    }
}