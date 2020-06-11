class Solution {
    Map<String, Integer> map;
    public int minKnightMoves(int x, int y) {
        map = new HashMap<>();
        map.put("0,0",0);
        map.put("1,0",3);
        map.put("1,1",2);
        map.put("2,0",2);
        return dP(Math.abs(x),Math.abs(y));
    }
    
    public int dP(int x, int y)
    {
        if(x<y)
        {
            int temp = x;
            x = y;
            y = temp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(",").append(y);
        String s = sb.toString();
        if(map.containsKey(s)) return map.get(s);
        int val = Math.min(dP(Math.abs(x-2),Math.abs(y-1)), dP(Math.abs(x-1),Math.abs(y-2))) + 1;
        map.put(s,val);
        return val;
    }
}