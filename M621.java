class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0, numMaxes=0;
        for(char c : tasks)
        {
            if(!map.containsKey(c))
            {
                map.put(c, 1);
            }
            else{
                map.put(c, map.get(c)+1);
            }
            if(map.get(c)>maxFreq)
            {
                maxFreq = map.get(c); numMaxes = 1;
            }
            else if(map.get(c)==maxFreq)
            {
                numMaxes++;
            }
        }
        int slotsForMaxFreqs = numMaxes * maxFreq;
        int otherSpots = (maxFreq-1)*(n-(numMaxes-1));
        return Math.max(slotsForMaxFreqs + otherSpots, tasks.length);
    }
}