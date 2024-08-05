package Study;
import java.io.*;
import java.util.*;
public class DAY01_answer {


    public class Main {
        public static void main(String[] args)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int N = Integer.parseInt(br.readLine());

            int[][] stickers = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                stickers[i][0] = Integer.parseInt(st.nextToken());
                stickers[i][1] = Integer.parseInt(st.nextToken());
            }

            int maxArea = 0;

            for (int i = 0; i < N; i++) {
                int w1 = stickers[i][0];
                int h1 = stickers[i][1];

                for (int j = i + 1; j < N; j++) {
                    int w2 = stickers[j][0];
                    int h2 = stickers[j][1];

                    // 모든 가능한 배치를 검사합니다.
                    if (fits(w1, h1, w2, h2, H, W)) {
                        maxArea = Math.max(maxArea, w1 * h1 + w2 * h2);
                    }
                    if (fits(w1, h1, h2, w2, H, W)) {
                        maxArea = Math.max(maxArea, w1 * h1 + w2 * h2);
                    }
                    if (fits(h1, w1, w2, h2, H, W)) {
                        maxArea = Math.max(maxArea, w1 * h1 + w2 * h2);
                    }
                    if (fits(h1, w1, h2, w2, H, W)) {
                        maxArea = Math.max(maxArea, w1 * h1 + w2 * h2);
                    }
                }
            }

            System.out.println(maxArea);
        }

        private static boolean fits(int w1, int h1, int w2, int h2, int H, int W) {
            // Check if the stickers fit within the paper in any orientation
            return (w1 + w2 <= W && Math.max(h1, h2) <= H) ||
                    (h1 + h2 <= H && Math.max(w1, w2) <= W) ||
                    (w1 + h2 <= W && Math.max(h1, w2) <= H) ||
                    (h1 + w2 <= H && Math.max(w1, h2) <= W);
        }
    }

}
