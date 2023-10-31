import java.util.*;

public class codingtestcns {
    public static void main(String[] args) {
        int n = 5; // 노드의 수
        int[][] arr = {
                {0, 5, 3, 2, 1},
                {5, 0, 4, 2, 1},
                {3, 4, 0, 1, 2},
                {2, 2, 1, 0, 1},
                {1, 1, 2, 1, 0}
        };

        List<Integer> nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeList.add(i);
        }

        // 다익스트라 알고리즘을 사용하여 노드 순서를 결정
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minNode = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    minDistance = distances[j];
                    minNode = j;
                }
            }
            visited[minNode] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && arr[minNode][j] != 0 && distances[minNode] + arr[minNode][j] < distances[j]) {
                    distances[j] = distances[minNode] + arr[minNode][j];
                }
            }
        }

        nodeList.sort(Comparator.comparingInt(node -> distances[node]));

        // 결과 출력
        System.out.println("노드의 순서: " + nodeList);
    }
}
