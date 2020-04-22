package io.tguduru.ds.lab.dailycodingproblem;

/**
 * This problem was asked by Jane Street.
 * <p>
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair.
 * <p>
 * For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
 * <p>
 * Given this implementation of cons:
 * <p>
 * def cons(a, b):
 * def pair(f):
 * return f(a, b)
 * return pair
 * Implement car and cdr.
 *
 * @author Guduru, Thirupathi Reddy
 * created 9/18/19
 */
public class PairConstructAndRetrieve {
    public static void main(String[] args) {
        long aVal = 4;
        long bVal = 6;
        Pair pair = pairConstruct(aVal, bVal);
        System.out.println(car(pairConstruct(11,12)).getFirst());
        System.out.println(cdr(pairConstruct(11,12)).getLast());
    }

    private static Pair cdr(Pair pair) {
        return new Pair(0, pair.getLast());
    }


    private static Pair car(Pair pair) {
        return new Pair(pair.getFirst(), 0);
    }

    private static Pair pairConstruct(long aVal, long bVal) {
        Pair pair = new Pair(aVal, bVal);
        return pair;
    }


    static class Pair {
        long first;
        long last;

        public Pair(long first, long last) {
            this.first = first;
            this.last = last;
        }

        public long getFirst() {
            return first;
        }

        public long getLast() {
            return last;
        }
    }

}
