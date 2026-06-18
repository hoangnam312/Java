class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String point : operations) {
            switch (point) {
                case "+":
                    int pre_1 = stack.pop();
                    int pre_2 = stack.pop();
                    stack.push(pre_2);
                    stack.push(pre_1);
                    stack.push(pre_1 + pre_2);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(point));
                    break;
            }
        }

        int sum = 0;
        for (int num : stack) {
            sum += num;
        }
        return sum;
    }
}