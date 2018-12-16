
*/
/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.







/*
code from: https://leetcode.com/problems/course-schedule/discuss/202941/Explained-idea-with-Java-code

As many people asking for the explanation of the algortihm, below is the idea.
The idea is Topological sort.
Every Entry(matrix[i][j]) in the matrix designates the dependency of the course j on the course i.
if matrix[i][j] == 1 => course j is dependent on course i.
The indegree[j] denotes the no. of dependencies for course j.
Then we search for the courses whose indegree is zero (all such independent courses can be finished first.)
Next for each of such courses mark them as finished(increase count), and subsequently check if other courses were dependent on this course.
If yes, reduce the dependency count i.e. indegree for those courses.
if any of their indegree becomes zero after reduction, that course becomes a candidate to be finished next (no more pre-requisite).
At the end we see of count equals total no. of courses.

*/


public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[][] matrix = new int[numCourses][numCourses]; // i -> j
    int[] indegree = new int[numCourses];
    
    for (int i=0; i<prerequisites.length; i++) {
        int ready = prerequisites[i][0];
        int pre = prerequisites[i][1];
        indegree[ready]++; 
        matrix[pre][ready] = 1;
    }
    
    int count = 0;
    Queue<Integer> queue = new LinkedList();
    for (int i=0; i<indegree.length; i++) {
        if (indegree[i] == 0) queue.offer(i);
    }
    while (!queue.isEmpty()) {
        int course = queue.poll();
        count++;
        for (int i=0; i<numCourses; i++) {
            if (matrix[course][i] != 0) {
                if (--indegree[i] == 0)
                    queue.offer(i);
            }
        }
    }
    return count == numCourses;
}
