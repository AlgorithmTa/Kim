import java.util.*;
import java.io.*;

public class BOJ2012 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[] students = new int[N+1];
        students[0] = 0;
        
        for(int i = 1 ; i <= N ; i++){
            students[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(students);
        for(int i = 1 ; i <= N ; i++){
            answer += Math.abs(students[i] - i );
        }
        
        System.out.println(answer);
    }
}
