class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        int lenCommon = strs[0].length();
        for(String str : strs)
        {
            if(lenCommon==0)
                return "";
            lenCommon = Math.min(str.length(), lenCommon);
            for(int i=0;i<lenCommon;i++)
            {
                if(str.charAt(i)!=strs[0].charAt(i))
                {
                    lenCommon = i;
                    break;
                }
            }
        }
        return strs[0].substring(0,lenCommon);
    }
}