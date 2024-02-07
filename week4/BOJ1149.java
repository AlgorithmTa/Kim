import java.util.*;
import java.io.*;

public class BOJ1149 {
    
    private static boolean[][] thesis = new boolean[26][26];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][3];
        int[][] cost = new int[N+1][3];
        
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i = 1 ;i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 1 ; i <= N ; i++){
            for(int j = 0 ; j < 3 ; j++){
                dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + cost[i][j];
            }
        }
        
        
        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
        br.close();
        
    }
}
