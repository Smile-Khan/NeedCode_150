class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        for(char ch : t.toCharArray())
        {
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }

        int[] result = {-1, -1};
        int resultLen = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++)
        {
            Map<Character, Integer> countS = new HashMap<>();
            for(int j = i; j < s.length(); j++)
            {
                countS.put(s.charAt(j), countS.getOrDefault(s.charAt(j), 0) + 1);

                boolean flag = true;
                for(char ch : countT.keySet())
                {
                    if(countS.getOrDefault(ch, 0) < countT.get(ch))
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag && (j - i + 1) < resultLen)
                {
                    resultLen = j - i + 1;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return resultLen == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}