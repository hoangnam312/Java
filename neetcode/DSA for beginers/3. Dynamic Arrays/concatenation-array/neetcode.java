class Solution {
    public int[] getConcatenation(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>(nums.length * 2);

        for (int i : nums) {
            result.add(i);
        }
        for (int i : nums) {
            result.add(i);
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i).intValue();
        }

        return ans;
    }
}