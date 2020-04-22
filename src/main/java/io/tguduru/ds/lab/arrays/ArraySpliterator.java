package io.tguduru.ds.lab.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified: 2019-08-07
 */
public class ArraySpliterator {
    public static void main(String[] args) {
        String name = "name";
        String number = "111-222-4444";
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
        Map<String, String> stringMap = new HashMap<>();
        for (long i = 0; i < 10_000_000; i++) {
            stringMap.put(name + i, number);
        }
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println(System.nanoTime() / 1_000_000);
        System.out.println(stringMap.get(name + 9_99_999));
        System.out.println(System.nanoTime() / 1_000_000);
    }
}
