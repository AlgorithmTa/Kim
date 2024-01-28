import java.util.*;

class OilDrilling {
    List<Integer> landSize = new ArrayList<>();
    List<Integer> landStart = new ArrayList<>();
    List<Integer> landEnd = new ArrayList<>();
    int[] landCol;
    boolean[][] visit;
    int n, m, count, size, landMin, landMax;
    int[][] unit = {{1,0},{0,-1},{-1,0},{0,1}};
    int[][] land;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        count = 0;
        this.land = land;
        visit = new boolean[n][m];
        landCol = new int[m];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(land[i][j] == 1 && !visit[i][j]){
                    size = 1;
                    landMin = j;
                    landMax = j;
                    visit[i][j] = true;
                    dfs(i, j);
                    landStart.add(landMin);
                    landEnd.add(landMax);
                    landSize.add(size);
                    count++;
                }
            }
        }
        
        for(int i = 0 ; i < count ; i++){
            for(int s = landStart.get(i) ; s <= landEnd.get(i); s++){
                landCol[s] += landSize.get(i);
            }
        }
        for(int i : landCol){
            if(answer < i) answer = i;
        }
        return answer;
    }
    
    public void dfs(int p, int q){                    
        if(landMin > q){
            landMin = q;                
        }
        if(landMax < q){
            landMax = q;          
        }
        for(int i = 0 ; i < 4 ; i++){
            int x = p + unit[i][0];
            int y = q + unit[i][1];
            
            if(x >= 0 && x < n && y >= 0 && y < m){
                if(!visit[x][y] && land[x][y] == 1){
                    visit[x][y] = true;
                    size++;

                    dfs(x,y);
                }
            }
        }
    }
    
}
