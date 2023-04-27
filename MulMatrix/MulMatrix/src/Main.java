import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1,2,3,4},
                {3,4,5,6},
                {1,2,3,4},
                {3,4,5,6}
        };
        int[][] matrix2 = {
                {1,2,3,4},
                {3,4,2,6},
                {1,4,3,4},
                {3,4,8,6}
        };

        System.out.println("Basic: "+ Arrays.deepToString(MulMatrix.mulMatrix_basic(matrix1,matrix2)));
        System.out.println("Strassen: "+ Arrays.deepToString(MulMatrix.mulMatrix_strassen(matrix1,matrix2)));
    }
}