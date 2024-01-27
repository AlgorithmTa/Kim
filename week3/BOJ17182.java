import java.util.*;
import java.io.*;

public class BOJ17182{
    
    private static int N, K, ans = Integer.MAX_VALUE;
    private static int[][] times;
    private static boolean[] visited;
    
    public static void main(String args[]) throws IOException{

        getInput();
        
        for(int h=0; h<N; h++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(i==j) continue;
                    times[i][j] = Math.min(times[i][j], times[i][h]+times[h][j]);
                }
            }
        }
        visited[K] = true;
        dfs(0,K,0);
        System.out.println(ans);
    }   
    
    public static void dfs(int level , int start, int sum) {
        if(level == N-1) {
            ans = Math.min(ans, sum);
            return ;
        }
        
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(level+1,i,sum+ times[start][i]);
                visited[i] = false;
            }
        }
    }
    
    private static void getInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        times = new int[N][N];
        visited = new boolean[N];
        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                times[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}