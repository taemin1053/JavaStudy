public class exam {
    public static void main(String[] args) {
        Solution sol = new Solution();

        
    }
}

class Solution{
    public int solution(int[] number){
        int sum = 45;

        for(int i = 0 ; i < number.length ; i++ ){
            sum -= number[i];
        }

        return sum;
    }
}
