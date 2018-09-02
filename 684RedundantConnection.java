class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int num = edges.length;
        UnionAndFind uf = new UnionAndFind(num);
        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1])) return edge;
        }
        throw new AssertionError();
    }
}
class UnionAndFind{
    int[] parent; 
    int[] rank;
    public UnionAndFind(int size){
        parent = new int[size+1];
        rank = new int[size+1];
        for(int i = 1; i <= size; i++){
            parent[i] = i;
        }
    }
    
    public int find(int node){
        if(parent[node] != node) parent[node] = find(parent[node]);
        return parent[node];
    }
    
    //其实就是Union and find,这里要注意parent改的是根节点的parent哦，不能单把叶子节点的改了
    public boolean union(int n1, int n2){
        int pn1 = find(n1);
        int pn2 = find(n2);
        if(pn1 == pn2) return false;
        if(rank[pn1] > rank[pn2]){
            parent[pn2] = pn1;
        }else if(rank[pn1] < rank[pn2]){
            parent[pn1] = pn2;
        }else{
            parent[pn1] = pn2;
            rank[pn2]++;
        }
        return true;
    }  
}