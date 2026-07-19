class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);

        return result;
    }
    private void backtrack(List<List<String>> result, List<String> current, String s, int start)
    {
        // Base case : reached the end
        if(start == s.length())
        {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try all possible substrings starting at 'start'
        for(int end = start + 1; end <= s.length(); end++)
        {
            String substring = s.substring(start, end);

            // Only explore if substring is palindrome
            if(isPalindrome(substring))
            {
                current.add(substring);// choose
                backtrack(result, current, s, end); // explore
                current.remove(current.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s)
    {
        int left = 0;
        int right = s.length() - 1;

        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
