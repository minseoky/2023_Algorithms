public class OBST {
    public static void optsearchtree(int n, double P[], int R[][]){

        long startTime = System.currentTimeMillis();


        int i, j, k, diagonal;
        double A[][] = new double[n+1][n+1];
        for(i = 0 ; i <= n ; i++){
            A[i][i] = 0;
            R[i][i] = 0;
            if(i < n){
                A[i][i+1] = P[i];
                R[i][i+1] = i+1;
            }
        }

        for(diagonal = 2 ; diagonal <= n ; diagonal++){
            for(i = 0 ; i <= n - diagonal ; i++){
                j = i + diagonal;
                double min = Double.MAX_VALUE; // 큰 값으로 설정
                int min_k = i;
                for(k = i+1 ; k <= j ; k++){
                    if(A[i][k-1] + A[k][j] < min){
                        min = A[i][k-1] + A[k][j];
                        min_k = k;
                    }
                }
                A[i][j] = min + sumProbabilities(P, i, j); //i~j까지의 확률 합
                R[i][j] = min_k;
            }
        }
        System.out.println("-+-+-+- A -+-+-+-");
        for (int q = 0; q < A.length; q++) {
            double[] inArr = A[q];
            for (int p = 0; p < inArr.length; p++) {
                System.out.print(String.format("%.3f", inArr[p]) + " ");
            }
            System.out.println();
        }

        System.out.println("-+-+-+- R -+-+-+-");
        for (int q = 0; q < R.length; q++) {
            int[] inArr = R[q];
            for (int p = 0; p < inArr.length; p++) {
                System.out.print(inArr[p] + " ");
            }
            System.out.println();
        }

        System.out.println("평균검색시간:" + A[0][n]);


        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("실행 시간: " + executionTime + "밀리초");
    }

    private static double sumProbabilities(double P[], int start, int end) {
        double sum = 0;
        for (int i = start; i < end; i++) {
            sum += P[i];
        }
        return sum;
    }
}
