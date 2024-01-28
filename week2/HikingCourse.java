import java.util.*;

public class Solution {
    private List<List<Node>> graph;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int s = path[0];
            int e = path[1];
            int w = path[2];

            if (isGate(s, gates) || isSummit(e, summits)) {
                graph.get(s).add(new Node(e, w));
            } else if (isGate(e, gates) || isSummit(s, summits)) {
                graph.get(e).add(new Node(s, w));
            } else {
                graph.get(s).add(new Node(e, w));
                graph.get(e).add(new Node(s, w));
            }
        }

        return dijkstra(n, gates, summits);
    }

    private  int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<Node> q = new LinkedList<>();
        int[] intensity = new int[n + 1];

        Arrays.fill(intensity, Integer.MAX_VALUE);

        for (int gate : gates) {
            q.add(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while (!q.isEmpty()) {
            Node current = q.poll();

            if(current.weight > intensity[current.number]) continue;

            for (int i = 0; i < graph.get(current.number).size(); i++) {
                Node next = graph.get(current.number).get(i);

                int dis = Math.max(intensity[current.number], next.weight);
                if (intensity[next.number] > dis) {
                    intensity[next.number] = dis;
                    q.add(new Node(next.number, dis));
                }
            }
        }

        int maxSummit = Integer.MAX_VALUE;
        int maxWeight = Integer.MAX_VALUE;
        Arrays.sort(summits);

        for (int summit : summits) {
            if (intensity[summit] < maxWeight) {
                maxSummit = summit;
                maxWeight = intensity[summit];
            }
        }

        return new int[]{maxSummit, maxWeight};
    }

    private boolean isGate(int num, int[] gates) {
        for (int gate : gates) {
            if (num == gate) return true;
        }
        return false;
    }

    private boolean isSummit(int num, int[] submits) {
        for (int submit : submits) {
            if (num == submit) return true;
        }
        return false;
    }

    private class Node {
        int number;
        int weight;

        Node(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}