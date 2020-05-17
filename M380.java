class Node {
    int val;
    public Node(int v)
    {
        val = v;
    }
}
class RandomizedSet {

    List<Node> li;
    Map<Integer, Node> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        li = new ArrayList<>();        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
        {
            return false;
        }
        Node n = new Node(val);
        li.add(n);
        map.put(val, n);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        Node n = map.get(val);
        li.remove(n);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return li.get((int)(Math.random() * ( li.size()))).val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */