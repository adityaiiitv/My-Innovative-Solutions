class Solution {
    public void rotate(int[][] matrix) {
        // Swap
        int[] tempA;
        for(int i=0;i<matrix.length/2;i++)
        {
            tempA = matrix[i];
            matrix[i] = matrix[matrix.length-i-1];
            matrix[matrix.length-i-1] = tempA;
        }
        // Transpose
        int temp;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i;j<matrix[0].length;j++)
            {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}