package hashtables;

import java.util.Arrays;

/*
    Elements of Programming interviews  Pg 347 -> Compute an assignment of tasks
    Q)  Each worker must be assigned exactly two tasks. Each task takes a fixed amount of time. Tasks are independent, i.e., there are no constraints of the form "Task 4 cannot start before Task 3 is completed." Any task can be assigned to any worker.
        We want to assign tasks to workers so as to minimize how long it takes before all tasks are completed. For example, if there are 6 tasks whose durations are 5, 2, 1, 6, 4, 4 hours, then an optimum assignment is to give the first two tasks (i.e., the tasks with duration 5 and 2) to one worker, the next two (1 and 6) to another worker, and the last two tasks (4 and 4) to the last worker. For this assignment, all tasks will finish after max(5 + 2, 1 + 6, 4 + 4) = 8 hours.
 */
public class TasksToWorkers {
    public static void main(String[] args) {
        int[] tasks = {5, 2, 1, 6, 4, 4};
        System.out.println(solve(tasks));
    }
    public static int solve(int[] tasks){
        Arrays.sort(tasks);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<tasks.length/2+1; i++){
            if(max < tasks[i]+tasks[tasks.length-i-1])
                max = tasks[i]+tasks[tasks.length-i-1];
        }
        return max;
    }
}

/*
    The time complexity is the time taken by sort, which is O(N*logN)
 */