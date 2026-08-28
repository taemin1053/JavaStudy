package codingTest.heap;
//testTwoque에서 언급한 Treemap 사용해서 구현해보겠습니다.
import java.util.Arrays;
import java.util.TreeMap;

class testTreeMap{
    //key: 들어오는 숫자 Integer
    //Value: 해당 숫자의 빈도수
    private final TreeMap<Integer, Integer> map = new TreeMap<>();

    public void insert(int num){
        map.put(num, map.getOrDefault(num, 0 ) +1);
    }
    public void deleteMax(){
        if(map.isEmpty()){
            return;
        } /*
        if(map.get(map.lastKey()) > 1){
//            Map 스킬중 merge()는 키가 존재하면 기존값과 새로운 값을 연산하여 덮어쓴다 람다식으로 .put을 사용안해됨 (람다식의 중요성 )
            map.merge(map.lastKey(), 1, (oldValue, newValue) -> oldValue - newValue);
        } else {
            map.remove(map.lastKey());
        }
        lastKey() 과한 호출
        max = map.lastKey(); 로 줄일것
        */
        int max = map.lastKey();
        if(map.get(max) > 1){
//            Map 스킬중 merge()는 키가 존재하면 기존값과 새로운 값을 연산하여 덮어쓴다 람다식으로 .put을 사용안해됨 (람다식의 중요성 )
            map.merge(max, 1, (oldValue, newValue) -> oldValue - newValue);
        } else {
            map.remove(max);
        }
    }
    public void deleteMin(){
        if(map.isEmpty()){
            return;
        }
        int min = map.firstKey();
        if(map.get(min) > 1){
            map.merge(min, 1 ,(a,b)-> a - b);
        } else{
            map.remove(min);
        }
    }
    public int[] getResult(){
        if(map.isEmpty()){
            return new int[]{0,0};
        }
        return new int[]{map.lastKey(), map.firstKey()};
    }
}
public class testTwque2 {
   public int[] solutionTree(String[] operations){
       testTreeMap tm = new testTreeMap();
       for(String oper : operations){
           String[] spl = oper.split(" ");
           String command = spl[0];
           int num = Integer.parseInt(spl[1]);
           if("I".equals(command)){
               tm.insert(num);
           }
           if("D".equals(command)){
               if(num == 1){
                   tm.deleteMax();
               } else if(num == -1){
                   tm.deleteMin();
               }
           }
       }
       return tm.getResult();
   }

    public static void main(String[] args) {
        testTwque2 tt = new testTwque2();
        String[] arr = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] arr2 = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
//        System.out.println(tt.solutionTree(arr)); 이렇게 호출하면 배열의 메모리 주소값이 출력된다.
        System.out.println(Arrays.toString(tt.solutionTree(arr)));
        System.out.println(Arrays.toString(tt.solutionTree(arr2)));
        //Arrays.toString으로 묶어줘야지 실제 배열값이 정상출력됨
    }
}
