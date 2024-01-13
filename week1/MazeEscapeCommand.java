import java.util.*;
import java.lang.*;

class MazeEscapeCommand{
    char[] token = {'d', 'l', 'r', 'u'};
    int[][] unit = {{1,0},{0,-1},{0,1},{-1,0}};
    int k, r, c, n, m;
    String answer = null;
    StringBuilder str = new StringBuilder();
    
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.k = k;
        this.r = r;
        this.c = c;
        this.n = n;
        this.m = m;
        
        int remain = Math.abs(x-r) + Math.abs(y-c);
        if(remain > k || (k -remain)%2==1 ) return "impossible";
        findTrack(x, y, 0);
        
        return answer == null ? "impossible" : answer;
    }
    
    public void findTrack(int x, int y, int depth){
        if(answer != null) return;
        if(Math.abs(x-r) + Math.abs(y-c) > k - depth) return;
        if(depth == k){
            answer = str.toString();
            return;
        }
            
        for(int i = 0 ; i < 4 ; i++){
            int nx = x + unit[i][0];
            int ny = y + unit[i][1];
            if(nx > 0 && nx <= n && ny > 0 && ny <= m){
                str.append(token[i]);
                findTrack(nx, ny, depth+1);
                str.delete(depth, depth+1);
                
            }
        }
    }
}