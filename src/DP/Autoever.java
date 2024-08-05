package DP;
import java.util.*;
public class Autoever {

    // 0/1 Knapsack Problem을 해결하는 함수
    public static int knapsack(int[] weights, int[] values, int N, int M) {
        // DP 배열 초기화
        int[][] dp = new int[N + 1][M + 1];

        // DP 배열 채우기
        for (int i = 1; i <= N; i++) {
            int weight = weights[i - 1];
            int value = values[i - 1];
            for (int j = 1; j <= M; j++) {
                // 현재 아이템을 가방에 넣을 수 있는 경우
                if (weight <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                } else { // 현재 아이템을 가방에 넣을 수 없는 경우
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 최대 가치 반환
        return dp[N][M];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 보급품의 개수(N)와 가방의 최대 무게(M) 입력 받기
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 보급품의 무게와 가치 배열 초기화
        int[] weights = new int[N];
        int[] values = new int[N];

        // 보급품의 무게와 가치 입력 받기
        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }

        // knapsack 함수 호출하여 최대 가치 계산
        int max_value = knapsack(weights, values, N, M);

        // 결과 출력
        System.out.println("최대 가치: " + max_value);

        scanner.close();
    }
}
