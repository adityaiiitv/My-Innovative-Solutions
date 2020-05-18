class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st = new Stack<>();
        int index = T.length-1, bigger;
        int[] result = new int[T.length];
        for(int i=T.length-1;i>=0;i--)
        {
            if(st.isEmpty())
            {
                st.push(i);
                result[index--] = 0;
            }
            else{
                if(T[i]<T[st.peek()])
                {
                    st.push(i);
                    result[index--] = 1;
                }
                else{
                    while(!st.isEmpty() && T[st.peek()]<=T[i])
                    {
                        st.pop();
                    }
                    if(st.isEmpty())
                    {
                        st.push(i);
                        result[index--] = 0;
                        continue;
                    }
                    bigger = st.peek();
                    st.push(i);
                    result[index--] = bigger-index-1;
                }
            }
        }
        return result;
    }
}