class Solution {
    int[] weights;
    Random random;
    public Solution(int[] w) {
        this.random = new Random();
        weights = w;
        for(int i = 1;i<w.length;i++)
        {
            weights[i] += weights[i-1];
        }
    }
    
    public int pickIndex() {
        int left = 0, right = weights.length-1, mid;
        int index = random.nextInt(weights[weights.length-1])+1;
        while(left<right)
        {
            mid = (left+right)/2;
            if(weights[mid]==index)
            {
                return mid;
            }
            if(weights[mid]<index)
            {
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */