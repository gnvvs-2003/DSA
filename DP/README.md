# Methods
1. Memorization : Top-Down approach ,in the direction of main problem to base case 
2. Tabulation : Bottom-up approach ,in the diredction of base case to main problem 

Examples :Fibanocci number 
```
f(n) = f(n-1)+f(n-2)
```

Using DP we remove the time and space complexity of overlapping sub problems 

For f(5) we need to store 6 different vales 
therefore we store 
dp[0] = f(0)
dp[1] = f(1)
dp[i] = f(i)

intially we set all the values of the dp array to `-1`

if(dp[i]==-1){
    calculate the dp value and store the dp value
}
else{
    skip the calculation i.e already value exists in dp
}

return the dp[_value_]

`Code.java`

```java
import java.util.*;
class Code{
    static int f(int n, int[]dp ){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1) return dp[n];
        return dp[n] = f(n-1,dp)+f(n-2,dp);
    }
    public static void main(String[]args){
        int key = 5; # requires 6 length DP array
        int dp[] = new int[key+1];
        Arrays.fill(dp,-1);
        System.out.println(f(key,dp));
    }
}
```

Time complexity : each node is visited once i.e O(n)
Space complexity : O(n)

> Using tabulation : from base case 

```java
dp[0] = 0;
dp[1] = 1;
for(int i=2;i<=n;i++){
    dp[i] = dp[i-1]+dp[i-2];
}
```

Time and space complexity = O(n)

>Space Optimization : 
dp[i] =  dp[i-1] + dp[i-2]

declaring dp[i-1] as prev
and dp[i-2] as prev_2

=> dp[i] = current 
=>current = prev+prev_2 (loop from 2 to n)
prev_2 = prev;
prev = current;

Space complexity = O(1)

