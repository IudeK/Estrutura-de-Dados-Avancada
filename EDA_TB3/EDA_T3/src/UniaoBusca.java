public class UniaoBusca {

    int[] arr;
    int count;

    public UniaoBusca(int n){
        this.count = n;
        this.arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i;
        }
    }

    public int size(){
        return count;
    }

    public int find(int p){ 
        if( p < 0 || p >= this.count ){
            return -1;
        }

        return arr[p];
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public void unionElements(int p, int q){
        int pId = find(p);
        int qId = find(q);

        if( pId == qId ){
            return ;
        }

        for (int i=0; i<count; i++){
            if ( pId == arr[i] ){
                arr[i] = qId;
            }
        }
    }
}