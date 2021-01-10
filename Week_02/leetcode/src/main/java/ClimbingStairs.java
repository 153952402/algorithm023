

/**
 * 爬楼梯
 */
public class ClimbingStairs {

    public int climbStairs (int n) {
        int fn = 0, fn1 = 1, fn2 = 0;
        for (int i = 0; i < n; i++) {
            fn2 = fn + fn1;
            fn1 = fn2;
            fn = fn1;
        }
        return fn2;
    }
}
