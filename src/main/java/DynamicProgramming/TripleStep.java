package DynamicProgramming;

import java.util.Arrays;

public class TripleStep {
    public int tripleStep(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return helper(n, memo);
    }

    public int helper(int n, int[] memo) {
        if(n < 0) return 0;
        else if(n == 0) return 1;
        else if(memo[n] != -1) return memo[n];
        else memo[n] = helper(n-1, memo) + helper(n-2, memo) + helper(n-3, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        TripleStep ts = new TripleStep();
        System.out.println(ts.tripleStep(4));
    }
}
