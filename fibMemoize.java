  //Nouru Muneza. 
  //This is my Intro code to Dynamic programming using Memoization. 
  
  public static int fib(int n, Integer [] memo){
        if(memo[n] != null) return memo[n]; //reading pre-calculated values. 

        if (n == 1 || n == 2) return 1;
        else
            memo[n] = fib(n-1, memo) + fib(n-2, memo); //storing pre-calculated values. 
        return memo[n];
    }

Time complexity: Big (n)
Space complezity: Big(2n) => Big O(n). 2n because of both stack calls due to recursion and store table of memoization. 
