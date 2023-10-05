package BFS_DFS;

public class pg43165 {
    class Solution {
        int sum=0;
        static int [] numbers;
        int count;
        int target;
        int correct;
        public int solution(int[] numbers, int target) {
            int answer = 0;
            this.count=numbers.length;
            this.numbers=numbers;
            this.target=target;
            dfs(0);

            answer=correct;

            return answer;
        }
        public void dfs(int idx){
            if(idx==count){
                //System.out.println(sum);
                if(sum==target){
                    correct++;
                }
                return;
            }
            int [] plusminus={-numbers[idx],numbers[idx]};
            for(int i=0;i<2;i++){
                sum=sum+plusminus[i];
                dfs(idx+1);
                sum=sum-plusminus[i];
            }
        }
    }
}
