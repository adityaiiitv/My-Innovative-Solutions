class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> map = new HashMap<>();
        int dist;
        dist = distanceOf(p1,p2);
        map.put(dist, map.containsKey(dist) ? map.get(dist) + 1 : 1);
        dist = distanceOf(p1,p3);
        map.put(dist, map.containsKey(dist) ? map.get(dist) + 1 : 1);
        dist = distanceOf(p1,p4); 
        map.put(dist, map.containsKey(dist) ? map.get(dist) + 1 : 1);
        dist = distanceOf(p2,p3);
        map.put(dist, map.containsKey(dist) ? map.get(dist) + 1 : 1);
        dist = distanceOf(p2,p4); 
        map.put(dist, map.containsKey(dist) ? map.get(dist) + 1 : 1);
        dist = distanceOf(p3,p4);
        map.put(dist, map.containsKey(dist) ? map.get(dist) + 1 : 1);
        if(map.size()!=2)
        {
            return false;
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue()!=2 && entry.getValue()!=4)
            {
                return false;
            }
        }
        return true;
    }
    private int distanceOf(int[] p1, int[] p2)
    {
        return (p1[1]-p2[1])*(p1[1]-p2[1]) + (p1[0]-p2[0])*(p1[0]-p2[0]);
    }
}