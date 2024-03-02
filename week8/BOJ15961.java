import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ15961 {
	
	private static int[] sushies;
	private static Map<Integer, Integer> selectedK = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); 
		int k = Integer.parseInt(st.nextToken()); 
		int c = Integer.parseInt(st.nextToken()); 
		
		sushies = new int[N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			sushies[i] = Integer.parseInt(st.nextToken()); 
		}
		
		br.close();
		
		int start = 0;
		int end = k;
		int left = d- k;

		
		for(int i = start ; i < end ; i++) {
			if(!selectedK.containsKey(sushies[i]))
				selectedK.put(sushies[i], 1);
			else 
				selectedK.put(sushies[i], selectedK.get(sushies[i])+1);
		}
		
		if(!selectedK.containsKey(c)) {
			selectedK.put(c, 1);
		}
		else {
			selectedK.put(c, selectedK.get(c)+1);
		}
		
		int max = selectedK.size();
		
		while(true) {
			if(max < selectedK.size())	 max = selectedK.size();
			
			if(start == N) break;
			
			
			if(selectedK.get(sushies[start]) == 1) 
				selectedK.remove(sushies[start]);
			else 
				selectedK.put(sushies[start], selectedK.get(sushies[start])-1);
 
			if(!selectedK.containsKey(sushies[end])) 
				selectedK.put(sushies[end], 1);
			else 
				selectedK.put(sushies[end], selectedK.get(sushies[end])+1);
			
			start++;
			end = (end + 1)%N;
		}
		System.out.println(max);
		return;
	}
}
