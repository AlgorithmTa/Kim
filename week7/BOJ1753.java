import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    private static List<List<Node>> graph = new ArrayList<>();
    private static int[] dist;
    private static int V, E, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        
        for(int i = 0 ;i <= V ; i++){
            graph.add(new ArrayList<>());
        }
        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i = 0  ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(new Node(v, w));
        }
        
        br.close();
        
        dijkstra(K);
        
        
        for(int i = 1 ; i <= V ; i++){
            if(i == K) {
                sb.append("0\n"); 
                continue;
            }
            if(dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n"); 
                continue;
            }
            else sb.append(dist[i]).append("\n"); 
        }
        
        System.out.println(sb);
        
    }
    
    private static void dijkstra(int start){
       PriorityQueue<Node> pq = new PriorityQueue<>();
       boolean[] check = new boolean[V + 1];
       pq.add(new Node(start, 0));
       dist[start] = 0;

       while(!pq.isEmpty()){
           Node cur = pq.poll();
           int num = cur.num;

           if(check[num] == true) continue;
           check[num] = true;
           
           for(Node node : graph.get(num)){
               if(dist[node.num] > dist[num] + node.weight){
                   dist[node.num] = dist[num] + node.weight;
                   pq.add(new Node(node.num, dist[node.num]));
               }
           }
       }
    }
    
    static class Node implements Comparable<Node>{
        int num, weight;
    
        public Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
