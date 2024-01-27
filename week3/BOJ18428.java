import java.util.*;
import java.io.*;

public class BOJ18428 {
	static int N, answer, count;
	static char[][] board;
	static boolean[][] visit;
	static boolean flag = false;
    static int[][] unit = {{-1,0},{0,1},{1,0},{0,-1}};
	static List<Node> teachers = new ArrayList<>();
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
		
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0 ; j < N ; j++){
    			board[i][j] = st.nextToken().charAt(0);
    			if(board[i][j] == 'T') {
    			    teachers.add(new Node(i, j));
    			}
		    }
		}
            
		combination(0);
		
		if(flag) 
		    System.out.println("YES");
		else System.out.println("NO"); 
		
	}
	
	static void combination(int cnt) {
	    if(flag) return;
        if (cnt == 3) {
            check();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = 'O';
                    combination(cnt+1);
                    board[i][j] = 'X';
                }
            }
        }
    }
	
	public static void check() {
		Queue<Node> q = new LinkedList<>();
		for(Node teacher : teachers){
		    q.offer(teacher);
		}
		
		while(!q.isEmpty()){
		    Node node = q.poll();
            int x = node.x;
            int y = node.y;
            
		    for(int i = 0 ; i < 4 ; i++){
		        int nx = x + unit[i][0];
		        int ny = y + unit[i][1];
		      
		        while(nx >= 0 && nx < N && ny >= 0 && ny < N){
		            if(board[nx][ny] == 'S') return;
		            if(board[nx][ny] != 'X') break;
		            nx +=unit[i][0];
		            ny +=unit[i][1];
		        }
		      
		    }
		}
		
		flag = true;
		return;
	}
	
	static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}