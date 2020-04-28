public class Solution {
    Dictionary<char, int> freq;
    int maxFreq;
    char maxOccuring;
    public string ReorganizeString(string S) {
        freq = new Dictionary<char, int>();
        maxFreq = 0;
        if(CanReorganizeString(S))
        {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<S.Length;i++)
            {
                sb.Append(maxOccuring);
            }
            int idx = freq[maxOccuring]*2;
            freq[maxOccuring] = 0;

            foreach(KeyValuePair<char, int> entry in freq)
            {
                int f = entry.Value;
                while (f > 0) 
                {
                    if (idx >= S.Length) {
                        idx = 1;
                    }
                    sb[idx] = entry.Key;
                    idx += 2;
                    f--;
                }
            }
            return sb.ToString();
        }
        return "";
    }
    private bool CanReorganizeString(string S)
    {
        foreach(char c in S)
        {
            if(freq.ContainsKey(c))
                freq[c] = freq[c]+1;
            else freq.Add(c,1);
            if(freq[c]>maxFreq)
            {
                maxFreq = freq[c];
                maxOccuring = c;
            }
        }
        int maxLen = S.Length/2 + S.Length%2;
        if(maxFreq>maxLen)
            return false;
        return true;
    }
}