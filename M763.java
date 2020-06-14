class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<S.length();i++)
        {
            map.put(S.charAt(i),i);
        }
        int i=0;
        while(i<S.length())
        {
            int partLen = map.get(S.charAt(i));
            int j = i;
            while(j++<partLen)
            {
                partLen = Math.max(partLen, map.get(S.charAt(j)));
            }
            result.add(partLen-i+1);
            i=partLen+1;
        }
        return result;
    }
}