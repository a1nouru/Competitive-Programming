public class Main {

    public static int exist(int m, int n){
        if (m == 0 && n == 0) return 0;
        return DFS(0,0,0, m, n);
    }

    private static int DFS(int i, int j, int k, int m, int n){
        if (i == m-1 && j == n-1)
            return 1;

        if (i < m-1 && j < n-1) //checking if out of bounds
            return DFS(i+1,j,k, m,n) + DFS(i,j+1,k, m,n);
        
        if (i < m-1) return DFS(i+1,j,k, m,n);
         if (j < n-1) return DFS(i,j+1,k, m,n);
         return 0;
    }
