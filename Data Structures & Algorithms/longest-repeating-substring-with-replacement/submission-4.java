class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;

        HashSet<Character> charSet = new HashSet<>();

        for(char ch : s.toCharArray())
        {
            charSet.add(ch);
        }

        for(char ch : charSet)
        {
            int count = 0;
            int left = 0;

            for(int right = 0; right < s.length(); right++)
            {
                if(s.charAt(right) == ch)
                {
                    count++;
                }

                while((right - left + 1) - count > k)
                {
                    if(s.charAt(left) == ch)
                    {
                        count--;
                    }
                    left++;
                }
                result = Math.max(result, right - left + 1);
            }
        }
        return result;
    }
}
