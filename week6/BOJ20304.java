import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20304 {
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		boolean[] checked = new boolean[N+1];
		Queue<Node> q = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ;i++) {
		    int input = Integer.parseInt(st.nextToken());
		    if(!checked[input]){
		        checked[input] = true;
		        q.offer(new Node(input, 0));
		    }
		}
		
		int answer = 0;
		while(!q.isEmpty()){
		    Node node = q.poll();
		    int x = node.x;
		    int d = node.d;
		    answer = d;
		    
		    int t = 1;
		   
		    while(t <= N){
		        int result = t ^ x;
		        if(result <= N && !checked[result]){
		            checked[result] = true;
		            q.offer(new Node(result, d+1));
		        }
		        t = t<<1;
		    }
		}
		
		System.out.println(answer);
		br.close();
		
		
		
	}
	
	private static class Node{
	    int x, d;
	    
	    Node(int x, int d){
	        this.x = x;
	        this.d = d;
	    }
	}
}


