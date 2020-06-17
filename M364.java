/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int maxLevel = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int sum = 0;
        for(NestedInteger i : nestedList)
        {
            getMaxLevel(i,1);
        }
        for(NestedInteger i : nestedList)
        {
            sum+=getSum(i, maxLevel);
        }
        return sum;
    }
    private void getMaxLevel(NestedInteger num, int level)
    {
        if(level>maxLevel)
        {
            maxLevel = level;
        }
        if(num.isInteger())
        {
            return;
        }
        else{
            List<NestedInteger> li = num.getList();
            for(NestedInteger l : li)
            {
                getMaxLevel(l, level+1);
            }
        }
        
    }
    private int getSum(NestedInteger num, int weight)
    {
        int sum = 0;
        if(num.isInteger())
        {
            sum+=weight*num.getInteger();
        }
        else{
            List<NestedInteger> li = num.getList();
            for(NestedInteger l : li)
            {
                sum+=getSum(l, weight-1);
            }
        }
        return sum;
        
    }
}