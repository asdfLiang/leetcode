package hot100.mediumCanFinish;

import java.util.*;

/**
 * 207. 课程表
 *
 * @since 2024/8/9 下午3:27
 * @author by liangzj
 */
public class CanFinishMain {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // preCourseCount[course] = preCourseNumber; 每个课程前导课程的数量
        int[] preCourseCount = new int[numCourses];
        // Map<course, List<nextCourse>>; 每个课程的后续课程
        Map<Integer, List<Integer>> nextCoursesMap = new HashMap<>(numCourses);

        Queue<Integer> willStudyCourses = new LinkedList<>();
        for (int[] prerequisite : prerequisites) {
            preCourseCount[prerequisite[0]]++;
            List<Integer> nextCourses =
                    nextCoursesMap.getOrDefault(prerequisite[1], new ArrayList<>());
            nextCourses.add(prerequisite[0]);
            nextCoursesMap.put(prerequisite[1], nextCourses);
        }

        // 无前导课程的课程进入待学习队列
        for (int course = 0; course < numCourses; course++) {
            if (preCourseCount[course] == 0) {
                willStudyCourses.offer(course);
            }
        }
        if (numCourses > 0 && willStudyCourses.isEmpty()) return false;

        // 进行学习
        while (!willStudyCourses.isEmpty()) {
            int studyCourse = willStudyCourses.poll();
            numCourses--;

            List<Integer> nextCourses = nextCoursesMap.getOrDefault(studyCourse, new ArrayList<>());
            for (int nextCourse : nextCourses) {
                preCourseCount[nextCourse]--; // 后续课程的前导课程数-1
                if (preCourseCount[nextCourse] == 0) { // 后续课程的前导课程学完了，后学课程也进入待学习队列
                    willStudyCourses.offer(nextCourse);
                }
            }
        }

        return numCourses == 0;
    }
}
