package BFS_DFS;
import java.util.*;
public class pg43162 {

    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited=new boolean[n];
            Queue<Integer> q=new LinkedList<>();

            for(int i=0;i<n;i++){
                if(!visited[i]){
                    visited[i]=true;
                    q.offer(i);
                    while(!q.isEmpty()){
                        int node=q.poll();

                        for(int k=0;k<n;k++){
                            if(computers[node][k]==1&&!visited[k]){
                                visited[k]=true;
                                q.offer(k);
                            }
                        }
                    }
                    answer++;
                }
            }


            return answer;
        }

    }
}
