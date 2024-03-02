import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1933 {
    
    public static PriorityQueue<Point> pq = new PriorityQueue<>();
    public static TreeMap<Integer, Integer> tm = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2){
            return o2-o1;
        }
    });
    public static List<Integer> answerH = new ArrayList<>();
    public static List<Integer> answerX = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        
        int height = 0;
        
        for(int i = 0  ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            
            pq.offer(new Point(H, L, true));
            pq.offer(new Point(-1 * H, R, false));
        }
        
        br.close();
        
        int prev = 0;
        while(!pq.isEmpty()) {
            Point point = pq.poll();
            
            if(point.H > 0){
                tm.put(point.H, tm.getOrDefault(point.H, 0) + 1);
            }
            
            else{
                int key = -1 * point.H;
                int cnt = tm.get(key);
                
                if(cnt == 1) tm.remove(key);
                else tm.put(key, cnt - 1);
                
            }
            
            if(tm.size() == 0){
                sb.append(point.X).append(" ").append(0).append(" ");
                prev = 0;
                continue;
            }
            
            if(prev != tm.firstKey()) {
                sb.append(point.X).append(" ").append(tm.firstKey()).append(" ");
                prev = tm.firstKey();
            }
        }
        
        System.out.println(sb);
    }
    
    static class Point implements Comparable<Point>{
        int H;
        int X;
        
        Point(int H, int X, boolean isFront){
            this.H = H;
            this.X = X;
        }
        
        @Override
        public int compareTo(Point o) {
            if(o.X != this.X) return this.X - o.X;
            return o.H - this.H;
        }
    }
}
