class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        vector<int> s1freq(26, 0);
        vector<int> windowFreq(26, 0);

        for(int i = 0; i < n; i++)
        {
            s1freq[s1[i] - 'a']++;
        }

        for(int i = 0; i < n; i++)
        {
            windowFreq[s2[i] - 'a']++;
        }

        if(s1freq == windowFreq) return true;

        for(int i = n; i < m; i++)
        {
            windowFreq[s2[i - n] - 'a']--;

            windowFreq[s2[i] - 'a']++;

            if(s1freq == windowFreq) return true;
        }
        return false;
    }
};
