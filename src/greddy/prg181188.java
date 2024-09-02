package greddy;
import java.util.*;
public class prg181188 {

    
    class Solution {
        public int solution(int[][] targets) {
            int answer = 0;
            int end=0;
            Arrays.sort(targets,(o1,o2)->{
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }else{
                    return o1[0]-o2[0];
                }
            });
            //System.out.println(Arrays.deepToString(targets));
            for(int i=0;i<targets.length;i++){
                if(targets[i][0]>=end){
                    end=targets[0][1];
                    answer++;
                }
            }
            return answer;
        }
    }
}
