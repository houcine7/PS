public class SwapNodesInPairs {

    /*
     * 1=> 2 => 3=>4 =>5
     * 2=>1 =>4=>3=>5
     * 
     */

    public static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        while (head != null) {
            if (head.next != null) {
                ListNode ls = new ListNode(head.next.val, new ListNode(head.val));
                // System.out.println(ls);
                result.next = ls;
                result = ls.next;

                head = head.next.next;

            } else {
                ListNode ls = new ListNode(head.val);
                result.next = ls;
                result = ls;
                head = head.next;
            }

        }

        // System.out.println(dummy.next);
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode ls2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        swapPairs(ls2);

    }

}