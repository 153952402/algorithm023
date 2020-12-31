
import java.util.Deque;
import java.util.LinkedList;

/**
 * 任务1： 用 add first 或 add last 这套新的 API 改写 Deque 的代码
 */
public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }

        System.out.println(deque);
    }

}