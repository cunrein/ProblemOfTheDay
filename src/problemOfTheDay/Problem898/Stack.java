package problemOfTheDay.Problem898;

import kotlin.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Stack<T> {
    private final PriorityQueue<Pair<Integer, T>> queue = new PriorityQueue<>((o1, o2) -> o2.component1() - o1.component1());
    private int cnt = 0;

    public void push(T item) {
        queue.add(new Pair<>(++cnt, item));
    }

    public T pop () {
        if (!queue.isEmpty()) {
            T retv = queue.remove().component2();
            cnt--;
            return retv;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
