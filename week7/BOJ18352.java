import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] dist;
    private static int N, M, K, X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        dist = new int[N+1];
        for(int i = 0 ;i <= N ; i++){
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0  ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            graph.get(A).add(B);
        }
        
        br.close();
        
        dijkstra(X);
        
        
        for(int i = 1 ; i <= N ; i++){
            if(dist[i] == K){
                sb.append(i).append("\n"); 
            } 
        }
        
        if(sb.length() == 0)
            System.out.println(-1);
            
        else
            System.out.println(sb);
        
    }
    
    private static void dijkstra(int start){
       Queue<Integer> q = new LinkedList<>();
       boolean[] check = new boolean[N + 1];
       q.offer(start);
       dist[start] = 0;

       while(!q.isEmpty()){
           int num = q.poll();
           
           for(int next : graph.get(num)){
               if(dist[next] > dist[num] + 1){
                   dist[next] = dist[num] + 1;
                   q.offer(next);
               }
           }
       }
    }
}
