class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLenght = 0;

        for(int right = 0; right < s.length(); right++)
        {
            char ch = s.charAt(right);
            count[ch - 'A']++;

            // Track the frequency of the most frequent character in the current window
            maxFreq = Math.max(maxFreq, count[ch - 'A']);

            // If character to replace exceed k, shrink the window from the left
            if((right - left + 1) - maxFreq > k)
            {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // UPdate the maximum length found so far
            maxLenght = Math.max(maxLenght, right - left + 1);
        }
        return maxLenght;
    }
}
