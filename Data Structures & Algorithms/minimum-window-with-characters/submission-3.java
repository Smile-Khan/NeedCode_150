class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char ch : t.toCharArray())
        {
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }
        int have = 0;
        int need = countT.size();
        int[] result = {-1, -1};
        int resultLen = Integer.MAX_VALUE;
        int left = 0;

        for(int right = 0; right < s.length(); right++)
        {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(countT.containsKey(ch) && window.get(ch).equals(countT.get(ch)))
            {
                have++;
            }

            while(have == need)
            {
                if((right - left + 1) < resultLen)
                {
                    resultLen = right - left + 1;
                    result[0] = left;
                    result[1] = right;
                }

                char leftChar =s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar))
                {
                    have--;
                }
                left++;
            }
        }
        return resultLen == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}