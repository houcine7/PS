import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AddTowNumbersLinkedList {

    // public static ListNode add2Numbers(ListNode l1, ListNode l2) {
    // //

    // float firstNumber = 0;
    // float secondNumber = 0;
    // int n = 1;
    // while (l1 != null) {
    // firstNumber += l1.val * n;
    // n = n * 10;
    // l1 = l1.next;
    // }

    // n = 1;
    // while (l2 != null) {
    // secondNumber += l2.val * n;
    // n = n * 10;
    // l2 = l2.next;
    // }

    // float sum = firstNumber + secondNumber;

    // ListNode dummy = new ListNode(-1);
    // ListNode result = dummy;

    // if (sum == 0)
    // return new ListNode(0);

    // System.out.println(sum);
    // while ((int) sum != 0) {

    // System.out.println((sum % 10));
    // result.next = new ListNode((int) (sum % 10));
    // result = result.next;
    // sum = (sum / 10);
    // System.out.println(sum);
    // }

    // return dummy.next;
    // }

    public static ListNode addTowNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            result.next = new ListNode((sum + carry) % 10);
            result = result.next;
            carry = sum / 10;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        // ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        // ListNode l2 = new ListNode(4, new ListNode(0, new ListNode(6)));

        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(1,
                new ListNode(1, new ListNode(1,
                        new ListNode(1, new ListNode(1,
                                new ListNode(1, new ListNode(1,
                                        new ListNode(1, new ListNode(1)))))))))));

        ListNode l2 = new ListNode(1, new ListNode(1, new ListNode(1,
                new ListNode(1, new ListNode(1,
                        new ListNode(1, new ListNode(1,
                                new ListNode(1, new ListNode(1,
                                        new ListNode(1, new ListNode(1)))))))))));

        System.out.println(addTowNumbers(l1, l2).toString());
    }

}
