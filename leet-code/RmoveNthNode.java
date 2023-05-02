import java.util.ArrayList;
import java.util.List;

public class RmoveNthNode {

    public static ListNode removeNthNodeFromEnd(ListNode head, int n) {

        List<Integer> ls = new ArrayList<>();

        if (head.next != null) {
            ls.add(head.val);
        } else if (head.val == 0) {
            return null;
        }

        while (head.next != null) {
            head = head.next;
            ls.add(head.val);
        }

        System.out.println(ls);

        ListNode dummy = new ListNode(-1);

        ListNode current = dummy;

        for (int i = 0; i < ls.size(); i++) {
            if (i != ls.size() - n) {
                ListNode newNode = new ListNode(ls.get(i));
                current.next = newNode;
                current = newNode;
            }
        }

        System.out.println(dummy.next);

        return dummy.next;
    }

    public static ListNode deleteNthNode(ListNode head, int n) {

        ListNode holderList = head;
        int counter = 1;

        while (holderList.next != null) {
            counter++;
            holderList = holderList.next;
        }

        if (counter == n) {
            return head.next;
        }

        ListNode ls = head;
        int i = 0;

        while (++i < counter - n) {
            ls = ls.next;
            // System.out.println(ls);
        }

        System.out.println(ls.next);
        ls.next = ls.next.next;
        // System.out.println(ls);
        System.out.println(head);
        return head;
    }

    public static void main(String[] args) {
        deleteNthNode(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }

}
