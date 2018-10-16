 public static int largestRectangleArea(int[] height) {
        if(height.length == 0 || height == null){
            return 0;
        }
        Stack<Integer> stack = new Stack<>(); //stack to keep increasing heights
        int max = 0;
        int i = 0;

        while(i < height.length){

            if(stack.isEmpty() || height[i] > height[stack.peek()]){ 
                stack.push(i);
                i++;
            }
            else { //if we reach valley (hight->low)
                int indx = stack.pop(); 
                int h = height[indx];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h*w);
            }
        }
        while(!stack.isEmpty()){ //if there is heights left in stack 
            int indx = stack.pop();
            int h = height[indx];
            int w = stack.isEmpty() ? i : i - stack.peek() -1;
            max = Math.max(max, h*w);
        }

        return max;
    }
