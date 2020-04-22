package io.tguduru.ds.lab.arrays.logic;


import io.tguduru.ds.lab.crackingcode.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 * Note:
 * <p>
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * <p>
 * <p>
 * https://leetcode.com/problems/course-schedule/
 * <p>
 * Approach:
 * <p>
 * Constraints:
 * 1.
 * Ideas:
 * 1. Build a directed graph with the inputs
 * 2. Try find whether the graph has any cyclic edges or not. add isVisited property.
 * Complexities:
 * Time - O(N)
 * Test Cases:
 * Code:
 *
 * @author Guduru, Thirupathi Reddy
 * created 9/15/19
 */
public class CourseSchedule {
    public static void main(String[] args) {
        Graph<Long, Long> graph = new Graph<>(true);
        List<Course> courses = new ArrayList<>();
        Course course1 = new Course(1, 0);
        Course course2 = new Course(2, 1);
        Course course3 = new Course(3, 2);
        Course course4 = new Course(4, 3);
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        for (Course course : courses) {
            graph.insertVertex(course.getCourseId());
            graph.insertVertex(course.getPrerequisiteId());
            graph.insertEdge(course.getPrerequisiteId(), course.getCourseId(), 0L);
        }

        boolean isCyclic = graph.isCyclic();
        System.out.println(isCyclic ? "Cannot Complete the courses." : " Can complete the courses");
        graph.breadthFirstSearch(0L);
    }

    static class Course {
        long courseId;
        long prerequisiteId;

        public Course(long courseId, long prerequisiteId) {
            this.courseId = courseId;
            this.prerequisiteId = prerequisiteId;
        }

        public long getCourseId() {
            return courseId;
        }

        public long getPrerequisiteId() {
            return prerequisiteId;
        }
    }
}
