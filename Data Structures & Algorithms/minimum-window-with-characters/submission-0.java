class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();

        for(char c : t.toCharArray())
        {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // Sliding window
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        while(right < s.length())
        {
            // Expand window by adding s[right]
            char c = s.charAt(right);
            right++;

            if(need.containsKey(c))
            {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if(window.get(c).equals(need.get(c)))
                {
                    valid++;
                }
            }

            // Try to shrink window from left while it's valid
            while(valid == need.size())
            {
                // Update minimum window
                if(right - left < minLen)
                {
                    minLen = right - left;
                    start = left;
                }

                // Remove s[left] from window
                char d = s.charAt(left);
                left++;

                if(need.containsKey(d))
                {
                    if(window.get(d).equals(need.get(d)))
                    {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
