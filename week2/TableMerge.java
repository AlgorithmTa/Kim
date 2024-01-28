import java.util.*;

class Solution {
    public int[] parents = new int[2501];
    public String[] table = new String[2501];

    public int find(int a) {
        if (parents[a] == a)
            return a;
        else
            return parents[a] = find(parents[a]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parents[b] = a;
    }

    public String[] solution(String[] commands) {
        for (int i = 1; i <= 2500; i++) {
            parents[i] = i;
            table[i] = "";
        }

        List<String> result = new ArrayList<>();
        
        for(String line : commands){
           StringTokenizer st = new StringTokenizer(line);
            String command = st.nextToken();


            if ("UPDATE".equals(command)) {
                if (st.countTokens() == 2) {

                    String before = st.nextToken();
                    String after = st.nextToken();

                    for (int i = 1; i <= 2500; i++) {
                        if (before.equals(table[i]))
                            table[i] = after;
                    }
                }
                else {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    String after = st.nextToken();
                    int num = (x-1) * 50 + y;
                    table[find(num)] = after;
                }
            } else if ("MERGE".equals(command)) {
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                int n1 =  (x1-1) * 50 + y1;
                int n2 =  (x2-1) * 50 + y2;
                int root1 = find(n1);
                int root2 = find(n2);
 
                if (root1 == root2) continue;

                String rootString = table[root1].isBlank()? table[root2] : table[root1];
                table[root1] = "";
                table[root2] = "";
                union(root1, root2);
                table[root1] = rootString;

            } else if ("UNMERGE".equals(command)) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                int num =  (x-1) * 50 + y;
                int root = find(num);
                String rootString = table[root];
                table[root] = "";
                table[num] = rootString;
                List<Integer> deleteList = new ArrayList();
                for (int i = 1; i <= 2500; i++) {
                    if (find(i) == root)
                        deleteList.add(i);
                }
                for (Integer t : deleteList)
                    parents[t] = t;
            } else if ("PRINT".equals(command)) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                int num =  (x-1) * 50 + y;
                int root = find(num);
                if (table[root].isBlank())
                    result.add("EMPTY");
                else
                    result.add(table[root]);
            }
        }
        return result.toArray(new String[0]);
    }
}