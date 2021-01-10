import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 丑数
 */
public class UglyNumberIiSolution {

    public int nthUglyNumber (int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        Long s = 1L;
        for (int i = 1; i < n; i++) {
            s = set.pollFirst();
            set.add(s * 2);
            set.add(s * 3);
            set.add(s * 5);
        }
        return set.pollFirst().intValue();
    }
}
