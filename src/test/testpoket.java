package test;

import java.util.HashSet;

class SolutionPoket{
    public int solution(int[] nums){
        HashSet<Integer> poket =new HashSet<>();
        //해쉬에 nums 넣기
        for(int n : nums){
            poket.add(n);
        }
        //종류수, 최대 종류수 선언
        int poketSize = poket.size();
        int numsSize = nums.length/2;
        //비교
        int answer=Math.min(poketSize,numsSize);

        return answer;
    }
}
public class testpoket {
}
