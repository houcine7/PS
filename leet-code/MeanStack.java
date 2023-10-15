import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeanStack {

    LinkedList<Integer> ls;

    public MeanStack() {
        this.ls = new LinkedList<>();
    }

    public void push(int val) {
        ls.addFirst(val);
    }

    public void pop() {
        ls.poll();
    }

    public int top() {
        return ls.peek();
    }

    public int getMin() {
        Queue<Integer> q = new PriorityQueue<>(ls);
        return q.peek();
    }

}
