class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            // While stack has indices AND current temp is warmer than temp at stack top

            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);  // push current index;
        }
        return result;
    }
}
