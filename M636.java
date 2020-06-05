class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int lastEvent = 0,id,time;
        String[] log;
        for(int i=0;i<logs.size();i++)
        {
            log = logs.get(i).split(":");
            id = Integer.parseInt(log[0]);
            time = Integer.parseInt(log[2]);
            if (!st.isEmpty())
            {
                result[st.peek()] +=  time - lastEvent;
            }
            lastEvent = time;
            if(log[1].equals("end"))
            {
                result[st.pop()]++;
                lastEvent++;
            }
            else{
                st.push(id);
            }
        }
        return result;
    }
}