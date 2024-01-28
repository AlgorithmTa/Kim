import java.util.*;

class SumOfTwoQueue{
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    long sum[] = new long[2];
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        for(int i : queue1) sum[0] += i;
        for(int i : queue2) sum[1] += i;
        
        initQueue(q1, queue1);
        initQueue(q2, queue2);
        
        while(sum[0] != sum[1]) {
            if(answer > (queue1.length + queue2.length) * 2)
                return -1;
            int e = 0;
            if(sum[0] < sum[1]) {
                e = q2.poll();
                q1.add(e);
                sum[0] += e;
                sum[1] -= e;
            }
            else if(sum[0] > sum[1]) {
                e = q1.poll();
                q2.add(e);
                sum[0] -= e;
                sum[1] += e;
            }
            else 
            {
                return answer;
            }
            answer++;
        }
        return answer;
    }
                  
    public void initQueue(Queue to, int[] from){
        for(int i : from){
            to.offer(i);
        }
    }
                  
                  
}