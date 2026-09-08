class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string back to a list of strings
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = str.length();

        while (i < n) {
            int hashIdx = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, hashIdx));
            
            int start = hashIdx + 1;
            res.add(str.substring(start, start + len));
            
            i = start + len;
        }

        return res;
    }
}