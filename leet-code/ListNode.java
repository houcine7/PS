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

    public int getVal() {
        return this.val;
    }

    public ListNode next() {
        return this.next;
    }

    @Override
    public String toString() {

        ListNode ls = this;
        String str = "";
        while (ls.next != null) {
            str += ls.val + "=>";
            ls = ls.next;
        }

        return str + ls.val;
    }

}