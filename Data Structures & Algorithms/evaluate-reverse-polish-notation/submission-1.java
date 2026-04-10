class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens)
        {
            // Check if token is an operator
            if(token.equals("+") || token.equals("-") ||
               token.equals("*") || token.equals("/"))
               {
                // Pop two operands (order matters)
                int b = stack.pop();    // Second operand
                int a = stack.pop();    // First operand

                // Apply operation
                switch(token)
                {
                    case "+":
                    stack.push(a + b);
                    break;
                    
                    case "-":
                    stack.push(a - b);
                    break;

                    case "*":
                    stack.push(a * b);
                    break;

                    case "/":
                    stack.push(a / b);  // Truncates towards zero
                    break;
                }
               }
               else
               {
                // Token is a number
                stack.push(Integer.parseInt(token));
               }
        }
        // Final
        return stack.pop();
    }
}
