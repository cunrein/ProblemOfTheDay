package problemOfTheDay.Problem1013;

public class Problem1013 {
    public static void main(String[] args) {
        System.out.println(bitwiseAndNtoM(12, 15));
        System.out.println(bitwiseAndNtoM(10, 20));

        System.out.println(andOperator(12, 15));
        System.out.println(andOperator(10, 15));
    }

    static int msbPos(long n)
    {
        int msb_p = -1;
        while (n > 0) {
            n = n >> 1;
            msb_p++;
        }
        return msb_p;
    }

    // Function to find Bit-wise & of all
    // numbers from x to y.
    static long andOperator(long x, long y)
    {
        long res = 0; // Initialize result
        while (x > 0 && y > 0) {
            // Find positions of MSB in x and y
            int msb_p1 = msbPos(x);
            int msb_p2 = msbPos(y);
            // If positions are not same, return
            if (msb_p1 != msb_p2)
                break;
            // Add 2^msb_p1 to result
            long msb_val = (1 << msb_p1);
            res = res + msb_val;
            // subtract 2^msb_p1 from x and y.
            x = x - msb_val;
            y = y - msb_val;
        }
        return res;
    }

    public static int bitwiseAndNtoM(int n, int m) {
        var retv = n;
        for (int i = n+1; i < m; i++) {
            retv = retv & i;
        }
        return retv;
    }
}
