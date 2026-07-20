class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> map = new HashMap<>();

       for(String s : strs)
       {
        // Count characters frequencies
        int[] count = new int[26];
        for(char ch : s.toCharArray())
        {
            count[ch - 'a']++;
        }

        // Build key 
        StringBuilder key = new StringBuilder();
        for(int i = 0; i < 26; i++)
        {
            if(count[i] > 0)
            {
                key.append((char) ('a' + i));
                key.append(count[i]);
            }
        }
        map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
       }
       return new ArrayList<>(map.values());
    }
}
