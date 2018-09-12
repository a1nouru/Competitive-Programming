//Big O(1) for getMin call. 


/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) — Push element x onto stack.
pop() — Removes the element on top of the stack.
top() — Get the top element.
getMin() — Retrieve the minimum element in the stack.

*/
class MinStack {
    public:
        void push(int x) {
            eleStack.push(x);
            if (minStack.empty() || x &lt;= minStack.top())
                minStack.push(x);
        }

        void pop() {
            if (eleStack.empty()) return;
            if (eleStack.top() == minStack.top())
                minStack.pop();
            eleStack.pop();
        }

        int top() { return eleStack.top(); }

        int getMin() {
            return minStack.top();
        }

    private:
        stack&lt;int&gt; eleStack;
        stack&lt;int&gt; minStack;
};
