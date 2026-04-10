class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++)
        {
            char current = s.charAt(right);
            freq[current - 'A']++;


            maxFreq = Math.max(maxFreq, freq[current - 'A']);

            // Check if window is valid
            int windowLength = right - left + 1;
            if(windowLength - maxFreq > k)
            {
                // Window invallid, need to shrink
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }

            // Update max length (window is now valid)
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
