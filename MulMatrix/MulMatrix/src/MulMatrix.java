public class MulMatrix {
    public static int[][] mulMatrix_basic(int a[][], int b[][]){
      int row = a.length;
      int col = b[0].length;
      int r = a[0].length; // = b.length
      int[][] output = new int[row][col];
      for(int i = 0 ; i < row ; i++){
          for(int j = 0 ; j < col ; j++){
              for(int k = 0 ; k < r ; k++){
                  output[i][j] += a[i][k]*b[k][j];
              }
          }
      }

      return output;
    };


    public static int[][] mulMatrix_strassen(int a[][], int b[][]) {
        int row = a.length;
        int col = b[0].length;
        int r = a[0].length; // = b.length
        int[][] output = new int[row][col];

        if (row == 1 && col == 1) {
            output[0][0] = a[0][0] * b[0][0];
            return output;
        }

        // Divide the matrices into four sub-matrices
        int newSize = row / 2;
        int[][] a11 = new int[newSize][newSize];
        int[][] a12 = new int[newSize][newSize];
        int[][] a21 = new int[newSize][newSize];
        int[][] a22 = new int[newSize][newSize];
        int[][] b11 = new int[newSize][newSize];
        int[][] b12 = new int[newSize][newSize];
        int[][] b21 = new int[newSize][newSize];
        int[][] b22 = new int[newSize][newSize];

        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                a11[i][j] = a[i][j];
                a12[i][j] = a[i][j + newSize];
                a21[i][j] = a[i + newSize][j];
                a22[i][j] = a[i + newSize][j + newSize];
                b11[i][j] = b[i][j];
                b12[i][j] = b[i][j + newSize];
                b21[i][j] = b[i + newSize][j];
                b22[i][j] = b[i + newSize][j + newSize];
            }
        }

        // Recursively multiply the sub-matrices
        int[][] m1 = mulMatrix_strassen(add(a11, a22), add(b11, b22));
        int[][] m2 = mulMatrix_strassen(add(a21, a22), b11);
        int[][] m3 = mulMatrix_strassen(a11, subtract(b12, b22));
        int[][] m4 = mulMatrix_strassen(a22, subtract(b21, b11));
        int[][] m5 = mulMatrix_strassen(add(a11, a12), b22);
        int[][] m6 = mulMatrix_strassen(subtract(a21, a11), add(b11, b12));
        int[][] m7 = mulMatrix_strassen(subtract(a12, a22), add(b21, b22));

        // Combine the sub-matrices to get the final result
        int[][] c11 = subtract(add(add(m1, m4), m7), m5);
        int[][] c12 = add(m3, m5);
        int[][] c21 = add(m2, m4);
        int[][] c22 = subtract(add(add(m1, m3), m6), m2);

        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                output[i][j] = c11[i][j];
                output[i][j + newSize] = c12[i][j];
                output[i + newSize][j] = c21[i][j];
                output[i + newSize][j + newSize] = c22[i][j];
            }
        }

        return output;
    }

    public static int[][] add(int a[][], int b[][]){
        int n = a.length;
        int[][] output = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                output[i][j] = a[i][j] + b[i][j];
            }
        }
        return output;
    }

    public static int[][] subtract(int a[][], int b[][]){
        int n = a.length;
        int[][] output = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                output[i][j] = a[i][j] - b[i][j];
            }
        }
        return output;
    }
}
