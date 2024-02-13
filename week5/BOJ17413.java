import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413 {
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringBuilder sb = new StringBuilder();
	     
	     char[] S = br.readLine().toCharArray();
	     int index = 0;
	     Stack<Character> word = new Stack<>();
	     
	     while(index < S.length) {
	    	 if(isWord(S[index])) {
	    		 word.push(S[index++]);
	    		 continue;
	    	 }

    		 while(!word.isEmpty()) 
    			 sb.append(word.pop());
	    	 
	    	 if(S[index] == '<') {
	    		 while(S[index] != '>')
	    			 sb.append(S[index++]);
	    	 }
	    	 
    		 sb.append(S[index++]);
	     }
	     
		 while(!word.isEmpty()) 
			 sb.append(word.pop());
	     
	     br.close();
	     System.out.println(sb);
	}
	
	private static boolean isWord(char c) {
		return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
	}
}
