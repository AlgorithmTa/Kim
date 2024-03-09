import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static List<List<Integer>> list;
	private static int[] d, in;
	private static int N, K, W, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 0 ; t < T ; t ++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			d = new int[N+1];
			in = new int[N+1];
			list = new ArrayList<>();
			for(int i = 0 ; i <= N ; i++)
				list.add(new ArrayList<>());

			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i <= N ; i++)
				d[i] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int f = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				list.get(f).add(s);
				in[s]++;
			}
			
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			
			answer = 0;
			sb.append(topologicalSort(W)).append("\n");
		
		}

		br.close();
		System.out.println(sb);

	}

	private static int topologicalSort(int node) {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[N+1];
		
        for(int i=1; i<=N; i++) {
            result[i] = d[i];
 
            if(in[i] == 0)
                q.offer(i);
        }
		
        while(!q.isEmpty()) {
            int cur = q.poll();
 
            for(Integer i : list.get(cur)) {
                result[i] = Math.max(result[i], result[cur] + d[i]);
                in[i]--;
 
                if(in[i] == 0)
                    q.offer(i);
            }
        }
        
        return result[W];
	}

}
