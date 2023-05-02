import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddTowNumbersLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> numb1 = new ArrayList<>();
        List<Integer> numb2 = new ArrayList<>();
        String a = "";
        String b = "";

        while (l1.next != null) {
            numb1.add(l1.val);
            l1 = l1.next;
        }

        while (l2.next != null) {
            numb2.add(l2.val);
            l2 = l2.next;
        }

        int n = Math.max(numb1.size(), numb2.size());

        for (int i = 0; i < n; i++) {
            if (i < numb1.size()) {
                a += numb1.get(i);
            }
            if (i < numb2.size()) {
                b += numb2.get(i);
            }

        }

        StringBuilder sb = new StringBuilder(a + l1.val);
        StringBuilder sb2 = new StringBuilder(b + l2.val);

        a = sb.reverse().toString();
        b = sb2.reverse().toString();

        System.out.println("this is the first number" + a);
        System.out.println("this is the first number" + b);
        float sum = (new BigInteger(a)).floatValue() + (new BigInteger(b)).floatValue();

        String sumNumbers = (Math.round(sum) + "");

        // System.out.println(sumNumbers);

        ListNode head = new ListNode(0);
        ListNode current = head;

        for (int i = sumNumbers.length() - 1; i >= 0; i--) {

            int value = Character.getNumericValue(sumNumbers.charAt(i));
            current.next = new ListNode(value);
            current = current.next;
        }

        System.out.println(head.next);
        return head.next;

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        AddTowNumbersLinkedList at = new AddTowNumbersLinkedList();

        ListNode l = new ListNode();
        System.out.println(l.val);
        System.out.println(at.addTwoNumbers(l1, l2).toString());
    }

}
