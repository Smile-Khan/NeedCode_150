class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs)
        {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length())
        {
            // Find the delimiter position
            int j = i;
            while(str.charAt(j) != '#')
            {
                j++;
            }

            // Parse length
            int length = Integer.parseInt(str.substring(i, j));

            // Extract string of that length

            String extracted = str.substring(j + 1, j + 1 + length);
            result.add(extracted);

            // Move pointer to next position
            i = j + 1 + length;
        }
        return result;
    }
}
