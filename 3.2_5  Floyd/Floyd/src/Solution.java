import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void minWeight(int[][] graph, int node1, int node2) {
        if (node1 < 1 || node2 < 1) {
            System.out.println("인풋에러");
            return;
        }
        int n = graph.length;
        int[][] W = graph;
        int[][] T = new int[n][n];
        int[][] R = new int[n][n];

        // 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                T[i][j] = W[i][j];
                R[i][j] = j;
            }
        }

        // 최소 계산
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (T[i][k] + T[k][j] < T[i][j]) {
                        T[i][j] = T[i][k] + T[k][j];
                        R[i][j] = R[i][k];
                    }
                }
            }
        }

        // 결과
        System.out.println("간선 비용 그래프:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(T[i]));
        }

        int minValue = T[node1 - 1][node2 - 1];
        System.out.printf("노드 %d to 노드 %d 최소 비용: %d%n", node1, node2, minValue);

        List<Integer> path = new ArrayList<>();
        path.add(node1);
        int current = node1 - 1;
        while (current != node2 - 1) {
            current = R[current][node2 - 1];
            path.add(current + 1);
        }

        System.out.println("경로: " + path.toString());
    }
}
