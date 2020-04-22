package io.tguduru.ds.lab.dailycodingproblem;

import java.util.Hashtable;
import java.util.Map;

/**
 *
 * Write a function to flatten a nested dictionary. Namespace the keys with a period.
 *
 * For example, given the following dictionary:
 *
 * {
 *     "key": 3,
 *     "foo": {
 *         "a": 5,
 *         "bar": {
 *             "baz": 8
 *         }
 *     }
 * }
 * it should become:
 *
 * {
 *     "key": 3,
 *     "foo.a": 5,
 *     "foo.bar.baz": 8
 * }
 * You can assume keys do not contain dots in them, i.e. no clobbering will occur.
 *
 *
 * @author Guduru, Thirupathi Reddy
 * created 3/4/20
 */
public class Problem_173_FlattenDictionary {
    public static void main(String[] args) {
        System.out.println("Show dictionary");
        Map hashtable = new Hashtable();
        Map childHashtable = new Hashtable();
        childHashtable.put("Child","Value");
        hashtable.put("Awesome",childHashtable);
        System.out.println(hashtable);
    }
}
