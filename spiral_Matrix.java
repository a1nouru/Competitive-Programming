//Generally this problem seems easy when you see the solution, however it took a bit more time than I thought.
//Implementation is fairly easy to understand. 

public static List<Integer> spiralMatrix(Integer [][]matrix){

        List<Integer> results = new ArrayList<>(); 
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) return results; // Base case. 

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n -1;
        int top = 0;
        int bottom = m;

        while(results.size() < m*n){

            for(int i = left; i <= right; i++){
                results.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++){
                results.add(matrix[i][right]);
            }
            right--;

            //prevent duplicate row
            if(bottom<top)
                break;

            for (int i = right; i >= left; i--){
                results.add(matrix[bottom][i]);
            }
            bottom--;

            // prevent duplicate column
            if(right<left)
                break;

            for (int i = bottom; i >= top; i--){
                results.add(matrix[i][left]);
            }
            left++;
        }

        return results;
    }
