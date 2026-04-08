/*
 Given 4 Nodes starting from 1 to 4 .
 What are the total No. of Unique Binary Search.
*/

public class Day3NumberOfUniqueBinarySearchTree {
    public static int Memoization(int n, int[] dp){
        if(n<=1) return 1;
        if(n==2) return 2;
        if(dp[n]!=0) return dp[n];
        for(int i=1; i<=n; i++){
            int left = Memoization(i-1,dp);
            int right = Memoization(n-i,dp);
            int mul = left*right;
            dp[n] += mul;
        }
        return dp[n];

    }
    public static int Tabulation(int n){
        // TC:- O(n^2)
        // AS:- O(n)
        int[] dp =  new int[n+1];
        if(n<=1) return 1;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            for(int j=1; j<=i; j++){
                int left = j-1;
                int right = i-j;
                int mul = dp[left] * dp[right];
                dp[i] += mul;
            }
        }
        return dp[n];
    }
    static void main() {
        // Given Nodes:- 4 starting from 1 to 4
        int n = 4;
        int[] dp = new int[n+1];
        System.out.println(Memoization(n,dp));
        System.out.println(Tabulation(n));
    }
}
