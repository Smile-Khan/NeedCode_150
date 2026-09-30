class Solution {
    public int lengthOfLongestSubstring(String s) {
       int[] lastIndex = new int[256];
       for(int i = 0; i < 256; i++)
       {
        lastIndex[i] = -1;
       }

       int maxLen = 0;
       int left = 0;

       for(int right = 0; right < s.length(); right++)
       {
        char ch = s.charAt(right);

        // If characters is repeated within the current window, shrink the window
        if(lastIndex[ch] >= left)
        {
            left = lastIndex[ch] + 1;
        }

        lastIndex[ch] = right;
        maxLen = Math.max(maxLen, right - left + 1);
       }
       return maxLen;
    }
}
