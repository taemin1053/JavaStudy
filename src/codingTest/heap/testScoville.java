package codingTest.heap;

import java.util.PriorityQueue;

public class testScoville {
    public int solution(int[] scoville, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++ ){
            priorityQueue.offer(scoville[i]);
        }
        int count = 0;
        while(priorityQueue.peek() < k){
            //큐크기가 2보다 작으면 사실상 1개 (결국 다 합쳐졌는데 K이상 지수로 못넘긴거) 제한 사항의따라 return -1
            if(priorityQueue.size() <2){
                return -1;
            }
            //첫번째(가장 작은 스코빌 지수) 큐에서 꺼내오기
            int fpop = priorityQueue.poll();
            //두번째로 작은 스코빌 지수 가져오기
            int spop = priorityQueue.poll();
//섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
            int sco =  fpop + (spop *2);
            //sco를 힙에 넣어 while로 조건 확인
            priorityQueue.offer(sco);
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,10,2,4,5};
       testScoville answer = new testScoville();
        System.out.println(answer.solution(arr, 10));


    }
}
