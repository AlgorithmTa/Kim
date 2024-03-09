import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int[][] dp;
    static int[] array;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        array = new int[N+1];
        dp = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	array[i] = Integer.parseInt(st.nextToken());
        	array[i+1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i =2 ; i <= N; i++) {
        	for(int j = 0 ; j < N - i + 1 ; j++) {
        		dp[j][j+i-1] = Integer.MAX_VALUE;
        		for(int k = j ; k < j + i - 1; k++) {
        			int value = dp[j][k]  + dp[k+1][j+i-1] + (array[j]*array[k+1]*array[j+i]);
					dp[j][j+i-1] = Math.min(dp[j][j+i-1], value);
        		}
        	}
        }
        
        System.out.println(dp[0][N-1]);
        
    }
}
