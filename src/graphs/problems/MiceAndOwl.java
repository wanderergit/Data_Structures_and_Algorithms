package graphs.problems;

import java.awt.geom.Point2D;

public class MiceAndOwl {

    static class Mouse {
        Point2D point;
        public Mouse(int x, int y){
            point  = new Point2D.Double(x, y);
        }
    }

    static class Hole {
        int capacity;
        Point2D point;
        public Hole(int x, int y, int capacity){
            point = new Point2D.Double(x, y);
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        Mouse[] mice = {
                new Mouse(1, 0),
                new Mouse(0, 1),
                new Mouse(8, 1),
                new Mouse(12, 0),
                new Mouse(12, 4),
                new Mouse(15, 5)
        };

        Hole[] holes = {
                new Hole(1, 1, 1),
                new Hole(10, 2, 2),
                new Hole(14, 5 ,1)
        };

        solve(mice, holes, 3);
    }

    public static void solve(Mouse[] mice, Hole[] holes, int radius){
        final int M = mice.length;
        final int H = holes.length;
    }

}
