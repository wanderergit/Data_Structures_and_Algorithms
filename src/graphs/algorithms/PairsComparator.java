package graphs.algorithms;

import java.util.Comparator;

class PairsComparator implements Comparator<Pair> {

    @Override
    public int compare(Pair p1, Pair p2) {
        if(p1.distance > p2.distance) return 1;
        else if(p2.distance > p1.distance) return -1;
        return 0;
    }
}
