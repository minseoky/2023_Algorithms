
public class Main {
    public static final int INF = Integer.MAX_VALUE / 2;
    public static void main(String[] args) {
        int[][] W =
                {
                        {0,1,INF,1,5},
                        {9,0,3,2,INF},
                        {INF,INF,0,4,INF},
                        {INF,INF,2,0,3},
                        {3,INF,INF,INF,0}
                };
        floyd(W);
    }

    public static void floyd(int[][] W) {
        int n = W.length;
        int[][] D = new int[n][n];
        // D 배열을 초기화합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D[i][j] = W[i][j];
            }
        }
        // 플로이드 알고리즘을 적용합니다.
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
        // 결과를 출력합니다.
        System.out.println("최단거리 결과:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
    }

}