public class TSP {
    public static int tsp(int[][] graph){
        int[][] W = graph;
        int n = graph.length;
        int[][] dp = new int[n][1 << n];
        int[][] path = new int[n][1 << n];

        // dp배열, path배열 초기화
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < (1 << n) ; j++){
                dp[i][j] = -1;
                path[i][j] = -1;
            }
        }

        int node = 0; // 시작 노드 0
        int visit = 1 << node; // 비트마스크(0번 노드 방문했으므로 1)
        int returnValue = solve(node, visit, W, dp, path, n);

        // path 출력
        System.out.printf("경로: %d -> ", node);
        printPath(path, 0, 1, n);
        System.out.printf("%d\n", node);

        return returnValue; // 최소비용 반환
    }
    public static int solve(int node, int visit, int[][] graph, int[][] dp, int[][] path, int length){
        int[][] W = graph;
        int n = length;
        int minCost = Integer.MAX_VALUE;

        // visit = 11111인경우(모두 방문한경우)
        if(visit == (1 << n) - 1){
            // 마지막 노드와 시작노드를 잇는 비용 반환
            return W[node][0];
        }

        // dp배열에 이미 있는 원소일경우 계산 실시하지 않고 반환
        if(dp[node][visit] != -1){
            // System.out.printf("dp[%d][%s]에서 원소발견\n", node, Integer.toBinaryString(visit));
            return dp[node][visit];
        }

        // dp배열에 없는 원소일경우
        for(int next = 0 ; next < n ; next++){
            // visit하지 않은 노드만 방문
            if((visit & (1 << next)) == 0 && next != node){
                // visit에 있는 원소(노드)를 방문한 상태에서 node에서 이을 지점?
                int cost = W[node][next] + solve(next, visit | 1 << next, graph, dp, path, n);
                if(cost < minCost){
                    minCost = cost;
                    dp[node][visit] = minCost;
                    path[node][visit] = next;
                }
            }
        }
        return minCost;
    }

    public static void printPath(int[][] path, int node, int visited, int n){
        if (visited == (1 << n) - 1) return;
        int next = path[node][visited];
        System.out.print(next + " -> ");
        printPath(path, next, visited | (1 << next), n);
    }
}
