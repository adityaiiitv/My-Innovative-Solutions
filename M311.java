class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int al = A.length, aw = A[0].length , bw = B[0].length;
        int[][] C = new int[al][bw];
        for(int i=0;i<al;i++)
        {
            for(int j=0;j<bw;j++)
            {
                C[i][j] = 0;
                for(int k=0;k<aw;k++)
                {
                    if(A[i][k]!=0 && B[k][j]!=0)
                        C[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return C;
    }
}