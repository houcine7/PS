import java.util.Stack;

public class ReversNodesInKGrp {

    /*
     * 1 => 5=> 7=> 8=> 9=> 10=>11 k=4
     * 8=>7=>5=>1 =>9=>10=>11
     * 
     */

    // execution time 5ms
    public static ListNode reverseKGrp(ListNode head, int k) {

        Stack<Integer> st = new Stack<>();

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        while (head != null) {
            st.add(head.val);

            head = head.next;

            if (st.size() == k) {
                while (!st.isEmpty()) {
                    ListNode ls = new ListNode(st.pop());
                    result.next = ls;
                    result = ls;
                }
            }
        }

        for (Integer number : st) {
            ListNode ls = new ListNode(number);
            result.next = ls;
            result = ls;
        }

        // System.out.println(dummy);

        return dummy.next;

    }

    // 2nd try
    public static ListNode reverseKNode2(ListNode head, int k) {

        String s = "";

        while (head != null) {
            s += head.val;
            head = head.next;
        }

        int start = 0;
        int end = k - 1;
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while (true) {
            for (int j = end; j >= start; j--) {
                // System.out.println(s.charAt(j));
                ListNode ls = new ListNode(Integer.parseInt("" + s.charAt(j)));
                // System.out.println(ls);
                result.next = ls;
                result = ls;
            }

            if (2 * end >= s.length()) {
                break;
            } else {
                int holder = end;
                end = (2 * holder) - 1;
                start = holder + 1;
            }
        }

        for (int i = end; i < s.length(); i++) {
            ListNode ls = new ListNode(Integer.parseInt("" + s.charAt(i)));
            result.next = ls;
            result = ls;
        }

        // System.out.println(dummy.next);
        return null;
    }

    public static void main(String[] args) {
        ListNode ls2 = new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        reverseKNode2(ls2, 4);
    }

}
