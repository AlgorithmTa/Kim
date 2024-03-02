import java.util.*;
import java.io.*;

public class BOJ3109 {
	static int R,C,answer;
	static char[][] board;
    static int[][] unit = {{-1,1},{0,1},{1,1}};
	static boolean finished;
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
		    st = new StringTokenizer(br.readLine());
			board[i] = st.nextToken().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			finished = false;
			board[i][0] = '@';
			dfs(i,0);
		}
		System.out.println(answer);
	}
	
	public static void dfs(int x, int y) {
		
		if(y == C-1) {
			finished = true;          
			answer++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int nx = x + unit[i][0];
			int ny = y + unit[i][1];
			if(nx<0 || nx>=R || ny>=C || board[nx][ny] == 'x' || board[nx][ny] == '@') continue;
			if(finished) continue;
			board[nx][ny] = '@';
			dfs(nx,ny);
		}
		
	}
}