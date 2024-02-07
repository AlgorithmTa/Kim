import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11404 {
	
	private static int[][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        
        cost = new int[n+1][n+1];
       
        
        //버스 확인
        for(int i = 0; i < m ; i++) {
        	st = new StringTokenizer(br.readLine());	
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
        	if(needToUpdate(cost[a][b], c)) cost[a][b] = c;

        }
        
        for(int k = 1 ; k <= n ; k++) {
            for(int p = 1 ; p <= n ; p++) {
            	for(int q = 1 ; q <= n ; q++) {
                	if(k != p && k != q && p!= q) {
		        		if(needToUpdate(cost[p][q], cost[p][k] + cost[k][q]) && cost[p][k] != 0 && cost[k][q] != 0)
		        			cost[p][q] = cost[p][k] + cost[k][q];
                	}
                }
        	}
        }
        
        for(int i = 1 ; i <= n ; i++) {
        	for(int j = 1 ; j<= n ; j++)
        		sb.append(cost[i][j]).append(" ");
        	sb.append("\n");
        }
        System.out.println(sb);
	}
    
    private static boolean needToUpdate(int bf, int af) {
    	if(bf == 0) return true;
    	return bf > af;
    }
}
