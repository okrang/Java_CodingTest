package greddy;
import java.util.*;
public class prg181188 {

    class Solution {
        public int solution(int[][] targets) {
            int answer = 0;
            int end=0;
            Arrays.sort(targets,((o1,o2)->o1[0]-o2[0]));
            //System.out.println(Arrays.deepToString(targets));
            for(int i=0;i<targets.length;i++){
                if(targets[i][0]>=end){
                    end=targets[i][1];
                    answer++;
                    System.out.println(end);
                }
            }
            return answer;
        }
    }
}
