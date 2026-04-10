class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        int[] freqS1 = new int[26];
        int[] windowFreq = new int[26];

        for(int i = 0; i < n; i++)
        {
            freqS1[s1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < n; i++)
        {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(freqS1, windowFreq)) return true;

        // Slide the window
        for(int i = n; i < m; i++)
        {
            // Remove leftmost character of previous window
            windowFreq[s2.charAt(i - n) -'a']--;

            // Add new character
            windowFreq[s2.charAt(i) - 'a']++;

            // Compare frequencies
            if(Arrays.equals(freqS1, windowFreq)) return true;
        }
        return false;
    }
}
