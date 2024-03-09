import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static boolean prime[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int answer = 0;

		List<Integer> primes = new ArrayList<>();
        prime = new boolean[N+1];        
        prime[0] = prime[1] = true;       
        for(int i=2; i*i<=N; i++){
            if(!prime[i]) for(int j=i*i; j<=N; j+=i) prime[j]=true;                
        }            
        for(int i=1; i<=N;i++){
        	if(!prime[i]) primes.add(i);     
        }
        
		int s = 0;
		int e = 0;
		int sum = 0;
		
		while(true) {
        	if(sum >= N ) sum -= primes.get(s++);
        	else if(e == primes.size()) break;
        	else sum += primes.get(e++);       	
        	if(N==sum) answer++;     
		}
		
		System.out.println(answer);
	}
}
