import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * THINKING OF THE SOLUTION
 * 
 * for(i=0;i<lists.length){
 * for(j=i+1;j<lis
 * 
 * ts.length){
 * 
 * }
 * }
 */

public class MergArrayOfLinekdLists {

    public static ListNode mergeKLists(ListNode[] lists) {

        int i = 0;
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while (i < lists.length) {
            System.out.println(i);

            if (lists[i] == null) {
                i++;
                continue;
            }
            int min = lists[i].val;
            int curr = i;

            for (int j = i + 1; j < lists.length; j++) {
                if (lists[j] != null && lists[i] != null && lists[j].val < min) {
                    min = lists[j].val;
                    curr = j;
                }
            }
            System.out.println(curr);

            ListNode ls = new ListNode(min);
            result.next = ls;
            result = ls;

            lists[curr] = lists[curr].next;

            if (lists[i] == null) {
                i++;
            }

            System.out.println(dummy.next);

        }

        return dummy.next;
    }

    public static ListNode mergeKls(ListNode[] lsts) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < lsts.length; i++) {
            while (lsts[i] != null) {
                list.add(lsts[i].val);
                lsts[i] = lsts[i].next;
            }
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        for (Integer val : list) {
            ListNode ls = new ListNode(val);
            result.next = ls;
            result = ls;
        }

        return dummy.next;
    }

    /**
     * sloution of the problem with recursion
     * 
     * @param args
     */

    public static ListNode mergeRecursive(ListNode[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        return mergeHleper(arr, 0, arr.length - 1);

    }

    private static ListNode mergeHleper(ListNode[] arr, int start, int end) {
        System.out.println("..");

        if (start == end) {
            return arr[start];
        }

        if (start + 1 == end) {
            return merge(arr[start], arr[end]);
        }

        int mid = start + (end - start) / 2;

        ListNode left = mergeHleper(arr, start, mid);
        ListNode rigth = mergeHleper(arr, mid + 1, end);

        return merge(left, rigth);
    }

    private static ListNode merge(ListNode ls1, ListNode ls2) {

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while (ls1 != null & ls2 != null) {
            //
            // System.out.println("...");
            if (ls1.val <= ls2.val) {

                result.next = ls1;
                ls1 = ls1.next;
            } else {
                result.next = ls2;
                ls2 = ls2.next;
            }

            System.out.println(ls1);
            result = result.next;
        }

        result.next = (ls1 != null) ? ls1 : ls2;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode ls2 = new ListNode(1, new ListNode(2, new ListNode(5)));
        ListNode ls1 = new ListNode(1, new ListNode(3, new ListNode(7)));
        ListNode ls3 = new ListNode(0, new ListNode(4));
        ListNode nullLs = new ListNode();

        // mergeKLists(new ListNode[] { ls1, ls2, ls3 });

        System.out.println(mergeRecursive(new ListNode[] { ls1, ls2, ls3 }));

    }

}
