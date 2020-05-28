/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        ListNode slow = head, fast = head;
        int length=0;
        while(fast!=null)
        {
            slow = slow.next;
            fast = fast.next;
            length++;
            if(fast!=null)
            {
                fast = fast.next;
                length++;
            }
        }
        Stack<Integer> st = new Stack<>();
        int i=0;
        while(i<length/2)
        {
            st.push(head.val);
            i++;
            head = head.next;
        }
        while(!st.isEmpty())
        {
            if(slow.val!=st.pop())
                return false;
            slow = slow.next;
        }
        return true;
    }
}