package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalCovering {
    static class Interval{
        int from;
        int to;
        Interval(int f, int t){
            from = f;
            to = t;
        }
    }
    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(0, 3),
                new Interval(3, 4),
                new Interval(2, 6),
                new Interval(6, 9)
        };
        System.out.println("The minimum no. of visits the foreman has to make is : " + solve(intervals));
    }
    public static int solve(Interval[] intervals){
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval a, Interval b){
               return (a.to - b.to);
            }
        });
        int maxVisits = 0;
        for(int i=0; i< intervals.length;){
            int endTime = intervals[i].to;
            maxVisits++;
            while(i< intervals.length && endTime >= intervals[i].from && endTime <= intervals[i].to){
                i++;
            }
        }
        return maxVisits;
    }
}
