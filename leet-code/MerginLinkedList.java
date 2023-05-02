public class MerginLinkedList {

    public static ListNode mergeSortedLinekdLists(ListNode list1, ListNode list2) {
        //

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while (list1 != null && list2 != null) {
            //

            if (list1.val > list2.val) {
                ListNode ls = new ListNode(list2.val);
                list2 = list2.next;
                result.next = ls;
                result = ls;
            } else {
                ListNode ls = new ListNode(list1.val);
                list1 = list1.next;
                result.next = ls;
                result = ls;
            }
        }

        while (list1 != null) {
            ListNode ls = new ListNode(list1.val);
            list1 = list1.next;
            result.next = ls;
            result = ls;
        }

        while (list2 != null) {
            System.out.println(list2);
            ListNode ls = new ListNode(list2.val);
            list2 = list2.next;
            result.next = ls;
            result = ls;
        }

        // System.out.println(result);
        // System.out.println(dummy.next);
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode ls1 = new ListNode(0); // , new ListNode(2, new ListNode(5))
        ListNode ls2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        mergeSortedLinekdLists(ls1, ls2);
    }

}
