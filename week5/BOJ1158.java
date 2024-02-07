import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1158 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        br.close();
        
        List<Integer> circle = new ArrayList<>();
        
        int left = N;
        int index = 0;
        for(int i = 1 ; i <= N ; i ++)
        	circle.add(i);
        
        while(circle.size() != 0) {
        	index += K - 1;
        	index %= left;
        	sb.append(circle.get(index)).append(", ");
        	circle.remove((int)index);
        	left--;
        }
        int size = sb.length();
        sb.replace(size - 2, size, "");
        sb.append(">");
        System.out.println(sb);
        
        
	}
}
