package DisjointSets;

public class UnionFind {

    // the number of elements in the union find
    private int size;

    // tracks the size of each disjoint set
    private int[] sz;

    // tracks the parent of each element in the union find
    private int[] parent;

    // tracks the number of components at any particular stage (disjoint sets)
    private int numComponents;

    public UnionFind(int size){
        if(size < 0)
            throw new IllegalArgumentException("Size should be greater than 0");
        this.size = numComponents = size;
        sz = new int[size];
        parent = new int[size];

        for(int i=0; i<size; i++){
            parent[i] = i; // Link to itself, self loop
            sz[i] = 1; // initial size of all components is 1
        }
    }

    public int find(int p){

        // find the root of the component/set
        int root = p;
        while(root != parent[root])
            root = parent[root];

        // compress the path leading back to p
        // doing this operation is called "path compression"
        // and this is what gives us amortised constant time
        while(p!=root){
            int next = parent[p];
            parent[p] = root;
            p = next;
        }
        return root;
    }

    // return whether the elements are in the same component or not
    public boolean isSameComponent(int p, int q){
        return (find(p) == find(q));
    }

    // returns the size of the component which 'p' belongs to
    public int componentSize(int p){
        return sz[find(p)];
    }

    // returns the size of the union find data structure
    public int getSize(){
        return size;
    }

    // returns the number of remaining components/sets
    public int components(){
        return numComponents;
    }

    // unify the components/sets which contains 'p' and 'q'
    public void unify(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        // if already in the same component/set, do nothing
        if(pRoot == qRoot) return;

        // check which component size is larger and merge the smaller one into the larger one
        if(sz[pRoot] >= sz[qRoot]){
            sz[pRoot] += sz[qRoot];
            parent[qRoot] = pRoot;
        } else {
            sz[qRoot] += sz[pRoot];
            parent[pRoot] = qRoot;
        }

        // every time there is a union of two components, the total number of components
        // must be decreased by one
        numComponents -= 1;

    }


}
