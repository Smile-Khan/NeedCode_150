class Solution {
public:
    int characterReplacement(string s, int k) {
        int result = 0;
        unordered_set<char> charSet(s.begin(), s.end());

        for(char c : charSet)
        {
            int count = 0;
            int left = 0;

            for(int r = 0; r < s.size(); r++)
            {
                if(s[r] == c)
                {
                    count++;
                }

                while((r - left + 1) - count > k)
                {
                    if(s[left] == c)
                    {
                        count--;
                    }
                    left++;
                }
                result = std::max(result, r - left + 1);
            }
        }
        return result;
    }
};
