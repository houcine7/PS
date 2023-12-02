
public class ReorderList {
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
    }

    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head, temp = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev1 = null, current = slow;

        while (current != null) {
            ListNode temp1 = current.next;
            current.next = prev1;
            prev1 = current;
            current = temp1;
        }

        ListNode p = temp, q = prev1;
        while (prev1 != null && temp != null) {
            p = p.next;
            q = q.next;
            temp.next = prev1;
            prev1.next = p;

            temp = p;
            prev1 = q;
        }

    }

}
