package array;
//Di1 리펙토리
public class ArrayDi2 {
    public static void main(String[] args) {
        int[][] arr = new int[5][3];

        int i = 1;

        for(int row = 0 ; row < arr.length ; row++){
            for(int col = 0 ; col < arr[row].length ; col++){
                arr[row][col] = i++;
            }
        }
        for(int row = 0 ; row < arr.length ; row++){
            for(int col = 0 ; col < arr[row].length ; col++){
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }
    }
}
