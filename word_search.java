public static boolean exist(char [][] arr, String word){
        if (arr.length == 0 && arr[0].length == 0) return false; // base case

        int m = arr.length;
        int n = arr[0].length;

        for (int i = 0; i< m; i++){
            for (int j = 0; j < n; j++){
                if (DFS(arr,word,i,j,0)) return true;
            }
        }
        return false;
    }

    private static boolean DFS(char[][] arr,String word, int i, int j, int k){
        int m = arr.length;
        int n = arr[0].length;

        if (i < 0 || j < 0 || i > m || j> n) //checking if out of bounds
            return false;
        if (arr[i][j] == word.charAt(k)){
            if (k == word.length()-1) // we are at the end of the word and all the characters have been found.
                return true;
            else if( DFS(arr,word,i-1,j,k+1) //going left
                || DFS(arr,word,i+1,j,k+1) //going right
                || DFS(arr,word,i,j-1,k+1) //going down
                || DFS(arr,word,i,j+1,k+1)) //going up
                return true;
        }
        return false;
    }
