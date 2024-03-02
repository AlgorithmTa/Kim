import java.io.*;
import java.util.*;

public class BOJ2670{
    
    public static double[] d;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        double answer = 0;
        d = new double[N];
        d[0] = Double.parseDouble(st.nextToken());
        
        for(int i = 1 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Double.parseDouble(st.nextToken());
            double multi = d[i-1] * d[i];
            if(multi > d[i]) d[i] = multi;
            if(answer < d[i]) answer = d[i];
        }
        
        System.out.println(String.format("%.3f",answer));
        
    }
}
