import java.util.Arrays;

public class MyHashMap {

    ListNode[] nodes = new ListNode[100000];

    public MyHashMap() {

    }

    public void put(int key, int value) {
        int index = getHash(key);
        if (nodes[index] != null)
            nodes[index] = new ListNode(-1, -1);
        ListNode prev = find(nodes[index], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else
            prev.next.val = value;

    }

    private MyHashMap.ListNode find(MyHashMap.ListNode listNode, int key) {
        ListNode node = listNode, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;

        }
        return prev;
    }

    public int get(int key) {
        int i = getHash(key);
        if (nodes[i] == null)
            return -1;
        ListNode ls = find(nodes[i], key);
        return ls.next == null ? -1 : ls.next.val;
    }

    public void remove(int key) {
        int i = getHash(key);
        if (nodes[i] != null) {
            ListNode prev = find(nodes[i], key);
            if (prev.next != null)
                prev.next = prev.next.next;
        }
    }

    public int getHash(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }

}
