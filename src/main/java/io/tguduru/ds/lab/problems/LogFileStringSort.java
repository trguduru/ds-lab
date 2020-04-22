package io.tguduru.ds.lab.problems;

import java.util.*;

/**
 * Input
 * The input to the function/method consists of two argument - logFileSize, an integer representing the number of log lines.
 * logLines, a list of strings representing the log file.
 *
 * from aonecode.com from aonecode.com
 * Outputfrom aonecode.com
 * Return a list of strings representing the reordered log file data.from aonecode.com
 *
 * Note
 * Identifier consists of only lower case english character and numbers.from aonecode.com
 *
 * Example from aonecode.com
 *
 * Input
 * logFileSize = 5from aonecode.com
 * logLines =
 * [a1 9 2 3 1]
 * [g1 act car] [zo4 4 7]
 * [ab1 off key dog]from aonecode.com
 * [a8 act zoo]
 *
 * Output
 * [g1 act car]from aonecode.com
 * [a8 act zoo]
 * [ab1 off key dog]from aonecode.com
 * [zo4 4 7]
 * [a1 9 2 3 1]
 * @author Guduru, Thirupathi Reddy
 * @modified: 2019-08-17
 */
public class LogFileStringSort {
    public static void main(String[] args) {
        String[] input = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};

        List<Tuple> allStringLines = new ArrayList<>();
        List<Tuple> allNumericLines = new ArrayList<>();


        for (int i = 0; i < input.length; i++) {
            String line = input[i];
            Tuple lineTuple = new Tuple();
            String[] stringsInLine = line.split("\\s");
            lineTuple.setKey(stringsInLine[0]);
            try {
                long val = Long.parseLong(stringsInLine[1]);
                lineTuple.setValue(Arrays.toString(Arrays.copyOfRange(stringsInLine, 1, stringsInLine.length)));
                allNumericLines.add(lineTuple);
            } catch (NumberFormatException ex) {
                lineTuple.setValue(Arrays.toString(Arrays.copyOfRange(stringsInLine, 1, stringsInLine.length)));
                allStringLines.add(lineTuple);
            }
        }
        System.out.println("***  Input Lines ***");

        allStringLines.stream().forEach(System.out::println);
        allNumericLines.stream().forEach(System.out::println);

        Collections.sort(allStringLines, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.getValue().toString().compareTo(o2.getValue().toString());
            }
        });

        Collections.sort(allNumericLines, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.getValue().toString().compareTo(o2.getValue().toString());
            }
        });
        System.out.println("***  Sorted Lines ***");
        allStringLines.stream().forEach(System.out::println);
        allNumericLines.stream().forEach(System.out::println);



    }

    static class Tuple<T> {
        String key;
        T value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}
