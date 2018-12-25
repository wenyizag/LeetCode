//solution 1. merge sort
class Solution {
    int global = 0;
    public boolean isIdealPermutation(int[] A) {
        int local = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] < A[i-1]) local++;
        }
        mergeSort(A, 0, A.length - 1);
        // for(int cur : A) System.out.print(cur + " ");
        // System.out.println(local + " " + global);
        return local == global;
    }
    
    public void mergeSort(int[] A, int l, int r){
        if(l >= r) return;
        int mid = (l + r) / 2;
        
        mergeSort(A, l, mid);
        mergeSort(A, mid+1, r);
        
        global += merge(A, l, mid, r);
        // System.out.println("invert sort" + invert);
        // return;
        // return invert;
    }
    
    public int merge(int[] A, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        int invert = 0;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = l, j = 0; i <= m; i++, j++) L[j] = A[i];
        for(int i = m + 1, j = 0; i <= r; i++, j++) R[j] = A[i];
        
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                A[k++] = L[i++];
            }else{
                invert += (n1 - i);                
                A[k++] = R[j++];
            }
        }
        
        while(i < n1) A[k++] = L[i++];
        while(j < n2) A[k++] = R[j++];
        // System.out.println("invert merge" + invert);
        
        return invert;
    }
}

//solution 2
    public boolean isIdealPermutation(int[] A) {
        for(int i = 0; i < A.length; i++){
            if(Math.abs(A[i] - i) > 1) return false;
        }
        return true;
    }