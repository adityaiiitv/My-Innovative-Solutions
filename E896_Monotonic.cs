public class Solution {
    public bool IsMonotonic(int[] A) {
        bool isInc = false, isDec = false;
        for(int i=0;i<A.Length-1;i++)
        {
            if(!isInc && !isDec)
            {
                if(A[i+1]>A[i])
                    isInc = true;
                else if(A[i+1]<A[i])
                    isDec = true;
            }
            else if(isInc)
            {
                if(A[i+1]<A[i])
                    return false;
            }
            else if(isDec)
            {
                if(A[i+1]>A[i])
                    return false;
            }
        }
        return true;
    }
}