import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1976 {
    private static int[] itinerary;
    private static boolean[][] graph;
    private static boolean[] visit;
    private static int N, M;
    private static boolean ans = false;
    
    public static void main(String args[]) throws IOException {
        getInput();
        
            for(int k = 1 ; k <= N ; k++) {
        		for(int i = 1; i <= N ; i++) {
    		    	for(int j = 1; j <= N ; j++) {
    		    		if(k!= i && k!= j && i!= j) {
    		    			if(graph[i][k] && graph[k][j]) {
    		    				graph[i][j] = true;
    		    				graph[j][i] = true;
    		    			}
    		    		}
    		    	}
    		    }
        	}
        	
        	for(int i = 1 ; i < M ; i++) {
        		if(!graph[itinerary[i-1]][itinerary[i]]) {
        	        System.out.println("NO");
        	        return;
        		}
        	}
        
        
        System.out.println("YES");
    }
    
    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        
        
        itinerary = new int[M];
        graph = new boolean[N+1][N+1];
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++){
                graph[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
                if(i==j)graph[i][j] = true;
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M  ; i++){
            itinerary[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
}
