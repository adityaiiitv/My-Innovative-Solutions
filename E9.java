class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        while(x>0)
        {
            sb.append((char)(x%10+'0'));
            x/=10;
        }
        for(int i=0;i<sb.length()/2;i++)
        {
            if(sb.charAt(i)!=sb.charAt(sb.length()-i-1))
            {
                return false;
            }
        }
        return true;
    }
}