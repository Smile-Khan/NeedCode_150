class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;

        for(int i = 0; i < s.length(); i++)
        {
            HashMap<Character, Integer> count = new HashMap<>();
            int maxF = 0;

            for(int j = i; j < s.length(); j++)
            {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);

                maxF = Math.max(maxF, count.get(s.charAt(j)));

                if((j - i + 1) - maxF <= k)
                {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }
}
