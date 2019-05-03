/* Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/
//Not the fastest solution, but a little bit different from other solutions. 

class Solution{
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> results = new ArrayList<>();
        generate(results, numRows);
        return results;
    }
    
    public void generate(List<List<Integer>> results, int numRows){
        if (numRows == 1) results.add(Arrays.asList(1));
        else if (numRows > 1){
            generate(results, numRows -1);
            List<Integer> prevList = results.get(numRows-2);
            List<Integer> thisList = new ArrayList<>();
            
            for (int i = 0; i < prevList.size(); i++){
                if (i == 0) thisList.add(1);
                if (i > 0) thisList.add(prevList.get(i-1)+prevList.get(i));
                if (i == prevList.size()-1) thisList.add(1);
            }
            results.add(thisList);
        }
    }
}
