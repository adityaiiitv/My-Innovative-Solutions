class Solution {
    public void reverseString(char[] s) {
        char temp;
        int len = s.length/2;
        for(int i=0;i<len;i++)
        {
            temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }
}