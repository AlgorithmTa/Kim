import java.util.*;
import java.io.*;

public class BOJ12891 {
    private static Map<Character, Integer> map = new HashMap<>();
    private static int count[] = new int[4];
    private static int answer = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        String dnaStr = st.nextToken();
        char[] dnaUnits = dnaStr.toCharArray();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i ++)
            count[i] = Integer.parseInt(st.nextToken());
            
        map.put('A',0);
        map.put('C',0);
        map.put('G',0);
        map.put('T',0);
        
        
        for(int i = 0 ; i < P; i++){
            map.put(dnaUnits[i], map.get(dnaUnits[i]) + 1);
        }
        
        updateAnswer();
        
        for(int i = 1 ; i <= S - P ; i++){
            if(!(dnaUnits[i-1] == dnaUnits[i+P-1])){
                map.put(dnaUnits[i-1], map.get(dnaUnits[i-1]) - 1);
                map.put(dnaUnits[i+P-1], map.get(dnaUnits[i+P-1]) + 1);
            }
            updateAnswer();
        }
        System.out.println(answer);
        br.close();
    }
    
    private static void updateAnswer(){
        if(map.get('A') >= count[0] && map.get('C') >= count[1] 
            && map.get('G') >= count[2] && map.get('T') >= count[3]){
            answer++;
        }
    }
}