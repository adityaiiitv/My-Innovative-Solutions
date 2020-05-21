class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban = new HashSet<>();
        for(String s : banned)
        {
            if(!ban.contains(s))
                ban.add(s);
        }
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ");
        paragraph = paragraph.replaceAll("\\s+", " ");
        paragraph = paragraph.toLowerCase();
        String[] para = paragraph.split(" ");
        HashMap<String, Integer> freq = new HashMap<>();
        int max = 0;
        String result = "";
        for(String word : para)
        {
            if(!ban.contains(word))
            {
                freq.put(word, freq.getOrDefault(word, 0)+1);
                if(freq.get(word)>max)
                {
                    max = Math.max(max, freq.get(word));
                    result = word;
                }                    
            }
        }
        return result;
    }
}