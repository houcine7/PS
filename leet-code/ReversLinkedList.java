public class ReversLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        // to string method
        public String toString() {
            String result = "";
            ListNode current = this;
            while (current != null) {
                result += current.val + " ";
                current = current.next;
            }
            return result;
        }

    }

    public ListNode reversLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReversLinkedList rll = new ReversLinkedList();
        ListNode ln = rll.new ListNode(1,
                rll.new ListNode(2, rll.new ListNode(3, rll.new ListNode(5, rll.new ListNode(6)))));

        System.out.println(ln.toString());
        System.out.println(rll.reversLinkedList(ln).toString());

    }
}
