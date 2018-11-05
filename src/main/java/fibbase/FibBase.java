package fibbase;

import java.util.ArrayList;
import java.util.List;

public class FibBase {

	/**
	 * 
	 * @param a
	 *            > 0
	 * @param b
	 *            >= a
	 * @return y(a) + y(a+1) + y(a+2) + ... + y(b-1) + y(b)
	 */
	public static long ySum(long a, long b) {

	    long sum = 0;

	    for (long i = a; i <= b; i++) {
	        sum += y(i);
        }

        return sum;

	}

	private static long y(long n) {
	    return convertBinary(x(n));
    }

    /**
     *
     * @param bin last index = 1, first = largest
     * @return
     */
    private static long convertBinary(List<Integer> bin) {

	    long sum = 0;

	    for (int i = 0; i < bin.size(); i++) {

	        sum *= 2;
	        sum += bin.get(i);

        }

        return sum;

    }

    /**
     *
     * @param n
     * @return list of 1s or 0s
     */
	private static List<Integer> x(long n) {

	    List<Integer> fibBase = new ArrayList<Integer>();

	    List<Long> fibList = genFibList(n);

	    for (int i = fibList.size() - 1; i >= 0; i--) {

	        if (n >= fibList.get(i)) {
	            fibBase.add(1);
	            n -= fibList.get(i);
            } else {
	            fibBase.add(0);
            }

        }

        return fibBase;

    }

    /**
     *
     * @param n >= 1
     * @return
     */
    private static List<Long> genFibList(long n) {

        List<Long> fibList = new ArrayList<Long>();

	    long n1 = 1; // n-1th fib
	    long n2 = 1; // n-2th fib
	    long next = 2; // nth fib

	    long temp; // store next fib in calc

        fibList.add(n1);
        // skip first 1

        while (next <= n) {

            fibList.add(next);

            temp = n1 + next;
            n2 = n1;
            n1 = next;
            next = temp;

        }

        return fibList;

    }

}
