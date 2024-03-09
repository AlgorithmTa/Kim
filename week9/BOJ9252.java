import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] string1 = br.readLine().toCharArray();
        char[] string2 = br.readLine().toCharArray();
        dp = new int[string1.length+1][string2.length+1];
        int x = string1.length, y = string2.length;
        
        for(int i = 1 ; i <= string1.length ; i++) {
        	for(int j = 1; j <= string2.length ; j++) {
        		if(string1[i-1] == string2[j-1]) {
        			dp[i][j] = dp[i-1][j-1] +1;
       
        		} else {
        			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        		}
        	}
        }
        
        sb.append(dp[string1.length][string2.length]).append("\n");
        
        Stack<Character> st = new Stack<>();
        while (x > 0 && y > 0) {
            if (dp[x][y] == dp[x - 1][y]) {
                x--;
            } else if (dp[x][y] == dp[x][y - 1]) {
                y--;
            } else {
                st.push(string1[x-1]);
                x--;
                y--;
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        
        System.out.println(sb);
    }
}
