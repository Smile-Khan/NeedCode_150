class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i <= n; i++)
        {
            result.add(new ArrayList<>());
        }
        result.get(0).add("");

        for(int k = 0; k <= n; k++)
        {
            for(int i = 0; i < k; i++)
            {
                for(String left : result.get(i))
                {
                    for(String right : result.get(k - i - 1))
                    {
                        result.get(k).add("(" + left + ")" + right);
                    }
                }
            }
        }
            return result.get(n);
    }

}
