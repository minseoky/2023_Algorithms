public class Main {
    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE/2-1;
        int[][] W = {
                {0,4,INF,INF,INF,10,INF},
                {3,0,INF,18,INF,INF,INF},
                {INF,6,0,INF,INF,INF,INF},
                {INF,5,15,0,2,19,5},
                {INF,INF,12,1,0,INF,INF},
                {INF,INF,INF,INF,INF,0,10},
                {INF,INF,INF,8,INF,INF,0}
        };
        Solution.minWeight(W, 1, 5);

    }
}
