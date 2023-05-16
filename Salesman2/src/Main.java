public class Main {
    public static void main(String[] args) {
        int I = 1000;
        int n = 24;
        int[][] W = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    W[i][j] = 0;
                } else {
                    W[i][j] = (int) (Math.random() * 10) + 1;
                }
            }
        }
        /*
        int[][] W = {
                {0,2,4,3,3,3,4,3,4,3},
                {2,0,4,1,4,5,3,4,5,3},
                {5,2,0,6,2,1,2,3,4,5},
                {3,2,3,0,7,1,2,3,4,5},
                {3,1,6,4,0,1,2,3,4,5},
                {0,2,4,3,3,0,4,3,4,3},
                {2,0,4,1,4,5,0,4,5,3},
                {5,2,0,6,2,1,2,0,4,5},
                {3,2,3,0,7,1,2,3,0,5},
                {3,1,6,4,0,1,2,3,4,0}
        };
        */

        long startTime = System.currentTimeMillis();

        int answer = TSP.tsp(W);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;


        if (answer < 1000) {
            System.out.println("최소비용:" + answer);
        } else {
            System.out.println("간선을 순회할 수 없습니다.");
        }
        System.out.println("소요된 시간(ms): " + elapsedTime);
    }
}
