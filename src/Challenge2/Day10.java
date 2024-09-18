package Challenge2;
import java.util.*;

public class Day10 {

    // 스트라이크와 볼의 개수를 계산하는 메서드
    public static int[] check(int guess, int num) {
        int[] result = new int[2]; // result[0] = 스트라이크 수, result[1] = 볼 수
        String g = Integer.toString(guess);
        String n = Integer.toString(num);

        for (int i = 0; i < 3; i++) {
            if (g.charAt(i) == n.charAt(i)) {
                result[0]++; // 같은 자리에 같은 숫자면 스트라이크
            } else if (n.contains(Character.toString(g.charAt(i)))) {
                result[1]++; // 다른 자리에 있으면 볼
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> conditions = new ArrayList<>(); // 입력받은 조건을 저장할 리스트

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int s = sc.nextInt();
            int b = sc.nextInt();
            conditions.add(new int[]{num, s, b});
        }

        int count = 0; // 가능한 숫자의 개수

        // 가능한 모든 숫자 조합(123 ~ 987)
        for (int guess = 123; guess <= 987; guess++) {
            String g = Integer.toString(guess);
            if (g.contains("0") || g.charAt(0) == g.charAt(1) || g.charAt(1) == g.charAt(2) || g.charAt(0) == g.charAt(2)) {
                continue; // 0이 포함되거나, 중복된 숫자가 있으면 넘어간다.
            }

            boolean isValid = true;

            for (int[] condition : conditions) {
                int num = condition[0];
                int s = condition[1];
                int b = condition[2];
                int[] result = check(guess, num);

                if (result[0] != s || result[1] != b) {
                    isValid = false; // 주어진 조건과 맞지 않으면 이 숫자는 유효하지 않다.
                    break;
                }
            }

            if (isValid) {
                count++; // 모든 조건을 만족하면 가능한 숫자
            }
        }

        System.out.println(count);
        sc.close();
    }
}
