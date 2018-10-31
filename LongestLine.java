/*

Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
Example:
Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3
Hint: The number of elements in the given matrix will not exceed 10,000.

*/

class Solution {
public:
    int longestLine(vector<vector<int>>& M) {
        int max1=0;
        int i,j,m=M.size();
        if(!m) return 0;
        int n=M[0].size();
        for(i=0;i<m;i++){
            int b=0;
            for(j=0;j<n;j++)
            if(M[i][j]==1) {
                b++;
                max1=max(max1,b);
            }
            else b=0;

        }
        for(i=0;i<n;i++){
            int b=0;
            for(j=0;j<m;j++)
            if(M[j][i]==1) {
                b++;
                max1=max(max1,b);
            }
            else b=0;

        }
        //Diagonal 
        for(i=0;i<m;i++){
            int b=0;j=0;int x=i;
            while(x<m&&j<n){
                if(M[x][j]==1) {
                    b++;
                    max1=max(max1,b);
                }
                else b=0;
                x++;j++;
            }

        }
        for(j=1;j<n;j++){
            int b=0;i=0;int y=j;
            while(i<m&&y<n){
                if(M[i][y]==1) {
                    b++;
                    max1=max(max1,b);
                }
                else b=0;
                i++;y++;
            }

        }
        // Anti diagonal 
        for(j=0;j<n;j++){
            int b=0;i=0;int y=j;
            while(i>=0&&i<m&&y>=0&&y<n){
                if(M[i][y]==1) {
                    b++;
                    max1=max(max1,b);
                }
                else b=0;
                y--;i++;
            }

        }
       for(i=1;i<m;i++){
            int b=0;j=n-1;int x=i;
            while(x<m&&j>=0){
                if(M[x][j]==1) {
                    b++;
                    max1=max(max1,b);
                }
                else b=0;
                j--;x++;
            }

        }
        return max1;
    }
};
