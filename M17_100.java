class Solution {
    Map<Integer, String> map = new HashMap<>();
    List<String> result = new ArrayList<String>();
    int length;
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        {
            return result;   
        }
        map.put(2,"abc"); map.put(3,"def"); map.put(4,"ghi"); map.put(5,"jkl"); map.put(6,"mno");
        map.put(7,"pqrs"); map.put(8,"tuv"); map.put(9,"wxyz");
        length = digits.length();
        DFS(digits, 0, new StringBuilder());
        return result;
    }
    public void DFS(String digits, int pos, StringBuilder sb)
    {
        if(pos==length)
        {
            result.add(sb.toString());
            return;
        }
        String num = map.get(digits.charAt(pos)-'0');
        for(int i=0;i<num.length();i++)
        {
            sb.append(num.charAt(i));
            DFS(digits, pos+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}