package codingTest.stackQueue;

import java.util.HashMap;

//완주 못한 사람 출력
class SolutionHash
{
    public String solution(String[] participant, String[] completion){
        HashMap<String,Integer> partMap = new HashMap<String, Integer>();

        for(String p : participant){
            partMap.put(p, partMap.getOrDefault(p, 0) + 1);
        }
        for(String c : completion){
            partMap.put( c, partMap.get(c) -1);
        }
        for(String p : partMap.keySet()){
            if(partMap.get(p) == 1){
                return p;
            }

        }
        return "";
    }
}
public class testhash1 {
}
