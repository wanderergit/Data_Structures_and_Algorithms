package Greedy;

import java.util.Arrays;

/*
    Elements of programming interviews = pg 335
    q) A database has to respond to a set of client SQL queries. The service time required for each query is known in advance. For this application, the queries must be processed by the database one at a time, but can be done in any order. The time a query waits before its turn comes is called its waiting time.
    Given service times for a set of queries, compute a schedule for processing the queries that minimizes the total waiting time. Return the minimum waiting time. For example, if the service times are (2,5,1,3), if we schedule in the given order, the total waiting time is0+(2)+(2+5)+(2+5+l) = 17. If however, we schedule queries in order of decreasing service times, the total waiting time is 0 + (5) + (5 + 3) + (5 + 3 + 2) = 23. As we will see, for this example, the minimum waiting time is 10.
 */
public class MinimiseWaitingTime {
    public static void main(String[] args) {
        int[] completionTimes = {2, 5, 1, 3};
        System.out.println(solve(completionTimes));
    }
    public static int solve(int[] completionTimes){
        Arrays.sort(completionTimes);
        int sum = 0;
        int max = 0;
        for(int i = 0; i < completionTimes.length; i++){
            max += sum;
            sum += completionTimes[i];
        }
        return max;
    }
}
