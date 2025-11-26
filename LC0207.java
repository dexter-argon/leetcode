import java.util.*;

public class LC0207 {
	class Solution {
		public boolean canFinish(int numCourses, int[][] prerequisites) {
			/*
			 * [ai, bi] ai <- bi (to complete course bi you have to complete ai first)
			 */

			// first find course with zero indegree and process other dependent nodes by
			// reducing their indegrees
			// can continue the process

			Queue<Integer> queue = new ArrayDeque<>();
			int[] degreeMap = new int[numCourses];
			List<List<Integer>> nodesMap = new ArrayList<>();

			for (var i = 0; i < numCourses; ++i) {
				nodesMap.add(new ArrayList<>());
			}

			// 1. build inDegree mapping
			for (var prerequisite : prerequisites) {
				int ai = prerequisite[0];
				int bi = prerequisite[1];

				degreeMap[bi] += 1;
				nodesMap.get(ai).add(bi);
			}

			for (var course = 0; course < numCourses; ++course) {
				var inDegree = degreeMap[course];

				if (inDegree != 0) {
					continue;
				}

				queue.add(course);
			}

			int visitedCourses = 0;

			while (!queue.isEmpty()) {
				var course = queue.poll();

				++visitedCourses;

				var dependentCourses = nodesMap.get(course);
				for (var dependentCourse : dependentCourses) {
					degreeMap[dependentCourse] -= 1;
					if (degreeMap[dependentCourse] == 0) {
						queue.add(dependentCourse);
					}
				}

			}

			return visitedCourses == numCourses;
		}
	}
}
