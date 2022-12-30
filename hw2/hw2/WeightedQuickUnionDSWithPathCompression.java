package hw2;

public class WeightedQuickUnionDSWithPathCompression {
    private int[] parent;
    private int[] size;
    public WeightedQuickUnionDSWithPathCompression(int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int p) {
        if (p == parent[p]) {
            return p;
        } else {
            parent[p] = find(parent[p]);
            return parent[p];
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void connect(int p, int q) {
        int p_parent = find(p);
        int q_parent = find(q);
        if (p_parent == q_parent) {
            return;
        } else if(size[p_parent] > size[q_parent]) {
            parent[q_parent] = p_parent;
            size[p_parent] += size[q_parent];
        } else {
            parent[p_parent] = q_parent;
            size[q_parent] += size[p_parent];
        }
    }
}