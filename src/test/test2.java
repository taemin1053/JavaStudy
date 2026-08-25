package test;

import java.util.ArrayList;// 1. 요금 싼 순서대로 나오는 우선순위 큐를 만든다.
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node2 implements Comparable<Node2>{
    int num;
    int won;
    public Node2(int num, int won) {
        this.num = num;
        this.won = won;
    }
    @Override
    public int compareTo(Node2 o) {
        return Integer.compare(this.won, o.won);
    }

}
// 2. 최저 요금 장부(배열)를 만들고 무한대로 채운다.
class Solution2 {
    static final int maxWon = 100 * 200000;
    static List<List<Node2>> graph = new ArrayList<>();

    public int solution2(int n, int s, int a, int b, int[][] fares){
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] fare : fares){
            int r =  fare[0];
            int c = fare[1];
            int w = fare[2];
            graph.get(r).add(new Node2(c, w));
            graph.get(c).add(new Node2(r, w));
        }

        int[] distS = dijkstra(s,n);
        int[] distA = dijkstra(a,n);
        int[] distB = dijkstra(b,n);

        int minFare = maxWon;
        for(int j= 1; j <= n; j++){
            int sumFare = distS[j] + distA[j] + distB[j];
            if(minFare > sumFare){
                minFare = sumFare;
            }
        }
        return minFare;
    }
    private int[] dijkstra(int s, int n){
        // 3. 출발지 요금을 0원으로 적고 큐에 넣는다.
        int[] dist = new int[n+1];
        Arrays.fill(dist, maxWon);

        PriorityQueue<Node2> fq = new PriorityQueue<>();
        dist[s] = 0;
        fq.offer(new Node2(s, 0));
        // 4. 큐가 빌 때까지 계속 반복한다.
        while(!fq.isEmpty()){
            //    4-1. 큐에서 제일 싼 놈을 꺼낸다.
            Node2 cur = fq.poll();
            int now = cur.num;
            int curCost = cur.won;
            //    4-2. 이미 장부보다 비싸면 무시한다.
            if(dist[now] < curCost){
                continue;
            }
            //    4-3. 주변 길을 탐색해서 더 싸면 장부를 고치고 큐에 넣는다.
            for(Node2 neighbor : graph.get(now)){
                int nextCost = neighbor.won + dist[now];

                if(nextCost < dist[neighbor.num]){
                    dist[neighbor.num] = nextCost;
                    fq.offer(new Node2(neighbor.num, nextCost));
                }
            }
        }
        return dist;

    }
}




//    4-2. 이미 장부보다 비싸면 무시한다.


/*public class test2 {
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
}*/
