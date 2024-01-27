import java.util.*;
import java.io.*;

public class BOJ2302 {
    static int[] dp;
    static int answer = 1;
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seats = Integer.parseInt(br.readLine());
        int vipNum = Integer.parseInt(br.readLine());
        
        dp = new int[seats+2] ;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
            
        for(int i = 3 ; i <= seats; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        int bf = 0;
        for(int i = 0 ; i< vipNum ; i++){
            int vip = Integer.parseInt(br.readLine());
            answer *= dp[vip-bf-1];
            bf = vip;
        }
        answer *= dp[seats-bf];
        
        System.out.println(answer);
    }
}