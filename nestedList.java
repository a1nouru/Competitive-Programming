/*

Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
*/



public class NestedIter implements Iterator<Integer>{
    Stack<NestedIter> stack = new Stack<>();

    public NestedIter(List<NestedIter> list){
        if (list == null)
            return;
        for (int i  = 0; i < list.size(); i++){
            stack.push(list.get(i));
        }
    }

    @Override
    public Integer next(){
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext(){
        while(!stack.isEmpty()){
            NestedIter temp  = stack.peek();
            if(temp.isInteger())
                return true;
            else {
                stack.pop();
                for (int i = 0; i < temp.getList().size()-1; i--){
                    stack.push(temp.getList().get(i));
                }
            }
        }
        return false;
    }
}
