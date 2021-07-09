package graphs.problems;

public class WiredConnections {
    static class UnionFind {
        int[] parent;
        int n;
        int[] size;
        int numberOfComponents;

        UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
            this.n = n;
            numberOfComponents = n;
        }

        int find(int s){
            if(parent[s] == s) return s;
            return find(parent[s]);
        }

        void union(int s1, int s2){
            int p1 = find(s1);
            int p2 = find(s2);
            if(p1 == p2) return;

            if(size[p1]>=size[p2]){
                size[p1] += size[p2];
                parent[p2] = p1;
            } else {
                size[p2] += size[p1];
                parent[p1] = p2;
            }
            numberOfComponents -= 1;
        }

    }

    public static int makeConnected(int n, int[][] connections) {
        // we will use union-find to find the number of components
        // if we have the required number of edges, then we can return number of components - 1
        int numberOfEdges = connections.length;
        if(numberOfEdges < n-1) return -1;
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<numberOfEdges; i++){
            int[] edge = connections[i];
            uf.union(edge[0], edge[1]);
        }
        int numberOfComponents = uf.numberOfComponents;
        return numberOfComponents-1;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        System.out.println(makeConnected(n, connections));
    }
}
