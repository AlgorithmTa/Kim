import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1916 {
    
    private static int N, M;
    private static int[][] cost;
    private static int[] d;
    private static PriorityQueue<Node> pq = new PriorityQueue<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
        cost = new int[N+1][N+1];
        d = new int[N+1];
        
        for(int i = 0 ; i <= N ; i++){
            d[i] = -1;
            for(int j = 0 ; j <= N ; j++)
                cost[i][j] = -1;
        }
        
		for(int i = 0 ; i < M ; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    if(cost[a][b] != -1 && cost[a][b] < c)  
		        continue;
		    cost[a][b] = c;
		}
        
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		d[s] = 0;
		pq.offer(new Node(s, 0));
		
		while(!pq.isEmpty()){
		    
		    Node node = pq.poll();
		    int pos = node.pos;
		    int dis = node.dis;
		    
		    if(d[pos] < dis && d[pos] != -1) continue;
		    
		    for(int i = 1 ; i <= N ; i++){
           
		        if(cost[pos][i] != -1){
		            int nDis = dis + cost[pos][i];
		            if(nDis < d[i] || d[i] == -1){
		                d[i] = nDis;
		                pq.offer(new Node(i, nDis));
		            }
		        }
		    }
		}
        System.out.println(d[e]);
		
	}
	
	static class Node implements Comparable<Node>{
	    int pos, dis;
	    
	    Node(int pos, int dis){
	        this.pos=pos;
	        this.dis=dis;
	    }

		@Override
		public int compareTo(Node o) {
			return o.dis - this.dis;
		}
	}
}


