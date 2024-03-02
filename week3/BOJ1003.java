import java.util.*;
import java.io.*;

public class BOJ1003{
    static int[][] dp;
    static int answer = 1;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2 ; i <=40; i++){
            dp[i][0] += (dp[i-1][0] + dp[i-2][0]);
            dp[i][1] += (dp[i-1][1] + dp[i-2][1]);
        }

        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }
}