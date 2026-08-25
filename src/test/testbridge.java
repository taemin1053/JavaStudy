package test;
import java.util.*;
public class testbridge {
    public int solutionBridge(int bridge_length, int weight, int[] truck_weight){
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0; //걸리는 시간
        int current_weight = 0; //현재 다리무게
        //다리 큐에 배열 채우기
        for(int i= 0; i < bridge_length; i++){
            bridge.add(0);
        }
        //반복문 시작 트럭배열의 갯수가 끝날때까지
        for(int truck: truck_weight){
            while(true){
                time++;
                //큐 앞에 0빼기
                current_weight -= bridge.poll();

                //현재 무게 확인
                if(current_weight + truck < weight){
                    current_weight += truck;
                    bridge.add(truck);
                    break;
                }
                else{
                    bridge.add(0);
                }
            }

        }
        //마지막 트럭이 올라간 상태로 끝나기 때문에 return할때 최대 트럭 수를 더해야함
        return time + bridge_length;
    }
    public  static void main(String[] args) {
        int a = 2;
        int b = 10;
        int[] arr = {7, 4, 5, 6};
        testbridge step = new testbridge();
        int time = step.solutionBridge(a, b, arr);
        System.out.println(time );
    }

}

