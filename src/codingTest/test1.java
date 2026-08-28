package codingTest;

import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node other){
        return Integer.compare(this.cost, other.cost);
    }
}

class Solution{
    static final int INF = 200 * 100000;
    static List<List<Node>> graph;

    public int solution(int n, int s, int a, int b, int[][] fares){
        graph = new ArrayList<>();

        for(int i = 0; i<= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] fare : fares){
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];
            graph.get(u).add(new Node(v, cost));
            graph.get(v).add(new Node(u, cost));
        }

        System.out.println("==================================================");
        System.out.println(" 택시 합승 최단 경로 다익스트라 분석 로그 시작");
        System.out.println("==================================================");

        int[] distS = dijkstra(s, n);
        int[] distA = dijkstra(a, n);
        int[] distB = dijkstra(b, n);

        int minFare = INF;

        System.out.println("\n========== [ 4. 최적의 환승역(K) 탐색 시작 ] ==========");
        for(int k = 1; k <= n; k++){
            int totalFare = distS[k] + distA[k] + distB[k];
            System.out.println("환승역 K = " + k + "번 지점 | S->K(" + distS[k] + ") + K->A(" + distA[k] + ") + K->B(" + distB[k] + ") = 총 " + totalFare + "원");

            if(totalFare < minFare){
                System.out.println("  🔥 [최저가 갱신!] 기존 " + (minFare == INF ? "무한대" : minFare) + "원 -> " + totalFare + "원으로 변경");
                minFare = totalFare;
            }
        }
        return minFare;
    }

    private int[] dijkstra(int start, int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        // 🔥 치명적 버그 수정 완료: 출발지 장부를 0원으로 갱신해 주어야 알고리즘이 정상 시작됨!
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        System.out.println("\n========== [ 다익스트라 시작: 출발지 " + start + "번 지점 ] ==========");

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int now = current.index;
            int cost = current.cost;

            System.out.println("\n[탐색] 큐에서 꺼낸 현재 위치: " + now + "번 지점 (여기까지 누적 요금: " + cost + "원)");

            if(dist[now] < cost){
                System.out.println("  -> 낡은 정보입니다. (장부 요금 " + dist[now] + " < 큐 요금 " + cost + ") 무시하고 넘어갑니다.");
                continue;
            }

            for( Node neighbor : graph.get(now)){
                int newCost = dist[now] + neighbor.cost;
                System.out.println("  -> 주변 길 탐색: " + now + " -> " + neighbor.index + " (해당 구간 요금: " + neighbor.cost + ") | 총 예상 요금: " + newCost + "원");

                if(newCost < dist[neighbor.index]){
                    System.out.println("    => 💡 [장부 업데이트!] " + neighbor.index + "번 지점 기존 요금 " + (dist[neighbor.index] == INF ? "무한대" : dist[neighbor.index]) + "원 -> " + newCost + "원으로 싼 길 발견! 큐에 새 정보 투입!");
                    dist[neighbor.index] = newCost;
                    pq.offer(new Node(neighbor.index, newCost));
                } else {
                    System.out.println("    => 기존에 알던 요금 " + dist[neighbor.index] + "원보다 비싸거나 같아서 갱신하지 않습니다.");
                }
            }
        }

        System.out.println("\n>> 🏁 출발지 " + start + "번 지점에서 완성된 최저가 장부 목록");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + "번:" + dist[i] + "원 ");
        }
        System.out.println();
        return dist;
    }
}

public class test1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {
                {4, 1, 10}, {3, 5, 24}, {5, 6, 2},
                {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
                {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
        };

        int result = sol.solution(n, s, a, b, fares);
        System.out.println("\n==================================================");
        System.out.println("✅ 최종 계산된 최저 예상 택시요금: " + result + "원");
        System.out.println("==================================================");
    }
}