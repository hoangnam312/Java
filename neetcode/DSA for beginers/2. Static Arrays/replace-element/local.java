// Replace Elements With Greatest Element On Right Side
// You are given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
// After doing so, return the array.

// Example 1:
// Input: arr = [2,4,5,3,1,2]
// Output: [5,5,3,2,2,-1]

// Example 2:
// Input: arr = [3,3]
// Output: [3,-1]

// Constraints:
// 1 <= arr.length <= 10,000
// 1 <= arr[i] <= 100,000

class Main {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 3, 1, 2 };

        int[] result = replaceElements(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        result[arr.length - 1] = -1;

        for (int i = arr.length - 1; i > 0; i--) {
            // System.out.println(" ------------------ ");
            // System.out.println("i: " + i + "; arr[i]: " + arr[i] + "; result[i]: " +
            //         result[i]);
            result[i - 1] = (arr[i] > result[i]) ? arr[i] : result[i];
        }

        return result;
    }
}
