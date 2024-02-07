import java.util.*;
import java.io.*;

public class BOJ15723 {
    
    private static boolean[][] thesis = new boolean[26][26];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < 26 ; i++)
            thesis[i][i] = true;
        
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0)-'a';
            st.nextToken();
            int b = st.nextToken().charAt(0)-'a';
            
            thesis[a][b] = true;
        }
        
        for(int k = 0; k < 26 ; k++){
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 26 ; j++){
                    if(k!= i && k!=j && i!=j)
                        if(thesis[i][k] && thesis[k][j]) 
                            thesis[i][j] = true;
                }
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0)-'a';
            st.nextToken();
            int b = st.nextToken().charAt(0)-'a';
            if(thesis[a][b]) sb.append("T\n");
            else sb.append("F\n");
        }
        System.out.println(sb);
        br.close();
        
    }
}
