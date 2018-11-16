
/*

Let count[i] be the number of unique binary search trees for i. 
The number of trees are determined by the number of subtrees which have different root node.

i=0, count[0]=1 //empty tree

i=1, count[1]=1 //one tree

i=2, count[2]=count[0]*count[1] // 0 is root
            + count[1]*count[0] // 1 is root

i=3, count[3]=count[0]*count[2] // 1 is root
            + count[1]*count[1] // 2 is root
            + count[2]*count[0] // 3 is root

i=4, count[4]=count[0]*count[3] // 1 is root
            + count[1]*count[2] // 2 is root
            + count[2]*count[1] // 3 is root
            + count[3]*count[0] // 4 is root
..
..
..

i=n, count[n] = sum(count[0..k]*count[k+1...n]) 0 <= k < n-1
*/


public int Num_uniqueTrees(int n){
        int []count = new int [n];

        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i < n; i++){
            for (int j = 0; j < i -1; j++ ){
            count[i] += + count[j] * count[i-j-1];
            }
        }
        return count[n];
    }
