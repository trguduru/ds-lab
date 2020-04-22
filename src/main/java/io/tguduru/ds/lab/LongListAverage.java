package io.tguduru.ds.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.LongConsumer;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified: 2019-08-07
 */
public class LongListAverage implements LongConsumer {

    long total = 0, count = 0;

    @Override
    public void accept(long value) {
        total += value;
        count++;
    }

    public void combine(LongListAverage other) {
        total += other.total;
        count += other.count;
    }

    public double average() {
        return count > 0 ? (double)total / count : 0;
    }

    public static void main(String[] args) {
        List<Long> longs = new ArrayList<>();
        for (long i = 1; i <= 100_000_000; i++) {
            longs.add(i);
        }
        System.out.println(System.nanoTime() / 1_000_000);
        LongListAverage collect = longs.stream().collect(LongListAverage::new, LongListAverage::accept, LongListAverage::combine);
        System.out.println(System.nanoTime() / 1_000_000);
        System.out.println(collect.average());
    }
}
