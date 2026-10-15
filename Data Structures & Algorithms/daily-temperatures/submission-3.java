class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            // While the current temperature is warmer than the temperature at the index 
            // on the top of the stack, resolve the waiting days.
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            // push the current day's index onto the stack
            stack.push(i);
        }
        return result;
    }
}
