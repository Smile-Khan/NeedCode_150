class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        // Frequency array for characters in t
        int[] tCount = new int[128];
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }
        
        // Number of unique characters in t that need to be matched
        int required = 0;
        for (int count : tCount) {
            if (count > 0) {
                required++;
            }
        }
        
        int left = 0, right = 0;
        int formed = 0; // Number of unique characters currently matching their required frequency
        
        int[] windowCount = new int[128];
        
        // Storing minimum length and starting index of the window
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount[c]++;
            
            // If the current character's frequency matches its frequency in t, increment formed
            if (tCount[c] > 0 && windowCount[c] == tCount[c]) {
                formed++;
            }
            
            // Try and contract the window until it ceases to be desirable
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);
                
                // Update the minimum window if a smaller one is found
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }
                
                // Character at the left pointer is about to be excluded from the window
                windowCount[leftChar]--;
                if (tCount[leftChar] > 0 && windowCount[leftChar] < tCount[leftChar]) {
                    formed--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}