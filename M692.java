class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words)
        {
            if(map.containsKey(word))
                map.put(word, map.get(word)+1);
            else map.put(word,1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        List<String> result = new LinkedList<>();
        while(!pq.isEmpty())
        {
            result.add(0,pq.poll().getKey());
        }
        return result;
    }
}