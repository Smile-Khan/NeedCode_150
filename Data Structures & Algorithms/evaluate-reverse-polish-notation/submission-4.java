class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens)
        {
            switch(token)
            {
                case "+":
                {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                }
                break;
                case "-":
                {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                break;
                case "*":
                {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                }
                break;
                case "/":
                {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);  // java division naturally truncates toward zero
                }
                break;
                default:
                // If it's an operand, parse and push into the stack
                stack.push(Integer.parseInt(token));
                break;
            }
        }
        return stack.pop();
    }
}
