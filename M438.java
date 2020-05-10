class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sSize = s.length();
        if(s==null || sSize==0)
            return result;
        
        int[] count = new int[26];
        int pSize = p.length();
        for(int i=0;i<pSize;i++)
        {
            count[p.charAt(i)-'a']++;
        }
        int start = 0, end = 0, total = pSize;
        while(end<sSize)
        {
            if(count[s.charAt(end++)-'a']-->=1) 
                total--;
            
            if(total==0) 
                result.add(start);
            
            if(end-start == pSize && count[s.charAt(start++)-'a']++>=0) 
                total++;
        }
        return result;
    }
}