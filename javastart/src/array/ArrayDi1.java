package array;
//Di0 리펙토리
public class ArrayDi1 {
    public static void main(String[] args) {
        /*int[][] arr = new int[2][3];//행(row),열(col)

        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        */
        int[][] arr = {
                {1,2,3},
                {4,5,6}
        };
        for(int row = 0 ; row < arr.length ; row++){
            for(int col = 0 ; col <arr[row].length ; col++){
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }
    }
}
