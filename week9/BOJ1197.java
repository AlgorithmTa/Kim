import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1197 {

	private static StringBuilder sb = new StringBuilder();
	private static Edge[] edges;
	private static int[] parents;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
    	int V = Integer.parseInt(st.nextToken());
    	int E = Integer.parseInt(st.nextToken());
    	
    	edges = new Edge[E];
    	parents = new int[V+1];
    	
    	for(int e = 0 ;e < E ; e++) {
        	st = new StringTokenizer(br.readLine());
    		int A = Integer.parseInt(st.nextToken());
    		int B = Integer.parseInt(st.nextToken());
    		int C = Integer.parseInt(st.nextToken());
    		
    		edges[e] = new Edge(A, B, C);
    	}
    	
    	Arrays.sort(edges);
    	
    	//크루스칼
    	for(int v = 0 ; v <= V ; v++) {
    		parents[v] = v;
    	}
    	
    	long weight = 0;
    	int count = 0;
    	for(Edge edge : edges) {
    		if(!union(edge.from, edge.to)) continue;
    		weight += edge.weight;
    		if(++count == V-1) break;
    	}
    	
    	System.out.println(weight);
        br.close();
	}
	
	private static boolean union(int from, int to) {
		int aRoot = findRoot(from);
		int bRoot = findRoot(to);
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		return true;
	}

	private static int findRoot(int x) {
		if(parents[x] == x) return x;
		return parents[x] = findRoot(parents[x]);
	}

	static class Edge implements Comparable<Edge>{

		int from, to, weight;
		
		Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}

}
