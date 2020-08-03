class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        if(x<0)
        {
            isNegative = true;
        }
        if(isNegative)
        {
            x-=(2*x);
        }
        int num=0, oldNum = 0, tail;
        while(x>0)
        {
            tail = x%10;
            num = num*10 + tail;
            if((num-tail)/10!=oldNum)
            {
                return 0;
            }
            x/=10;
            oldNum = num;
        }
        if(isNegative)
        {
            num-=(2*num);
        }
        return num;
    }
}