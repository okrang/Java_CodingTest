package BFS_DFS;

public class pg1844 {
    class Solution {
        static int n,m;
        static int[][] maps;
        //static boolean[][] visit;
        static int answer;
        public int solution(int[][] maps) {

            answer = 0;
            this.maps=maps;
            n=maps.length;
            m=maps[0].length;
            // visit=new boolean[n][m];
            //visit[0][0]=true;
            dfs(0,0,1);
            if(answer==0){
                answer=-1;
            }
            return answer;

        }
        public static void dfs(int i,int j,int c){
            if(i==(n-1)&&j==(m-1)){
                if(answer==0){
                    answer=c;

                }else if(answer>c){
                    answer=c;

                }
                return;

            }


            int[] dx={0,1,0,-1};
            int[] dy={1,0,-1,0};
            for(int k=0;k<4;k++){
                int cx=dx[k]+i;
                int cy=dy[k]+j;

                if(cx>=0&&cy>=0&&cx<n&&cy<m&&maps[cx][cy]==1){

                    maps[cx][cy]=0;
                    //System.out.println(cx);
                    dfs(cx,cy,c+1);
                    maps[cx][cy]=1;
                }
        }

    }
}}
