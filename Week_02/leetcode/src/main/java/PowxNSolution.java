

/**
 * Pow(x, n)
 */
public class PowxNSolution {
    public double myPow(double x, int n) {
        if(x == 0.0d) return 0.0d;
        long b = n;//防止n为 Integer.MIN_VALUE 导致 n = -n 报错;
        double res = 1;

        if(b < 0) {
            b = -b;
            x = 1 / x;
        }
        while (b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b = b >> 1;
        }
        return res;
    }
}
