package BFS_DFS;

public class pg250136 {


    class Solution {
        static int [][] land;
        static int n,m,count;
        static boolean visited[][];
        // static ArrayList<Integer> [] oil;
        static boolean[] mcount; //각 넓이가 방문한 m
        static int[] msum;    //m열의 넓이합
        public int solution(int[][] land) {
            int answer = 0;
            this.land=land;
            n=land.length;
            m=land[0].length;
            visited=new boolean[n][m];
            mcount=new boolean[m];
            msum=new int[m];
            // oil=new ArrayList[m+1];
            // for(int i=0;i<m;i++){
            //     oil[i]=new ArrayList<>();
            // }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    count=0;
                    mcount=new boolean[m];
                    if(land[i][j]==1&&visited[i][j]==false){
                        visited[i][j]=true;
                        dfs(i,j);
                        for(int k=0;k<m;k++){
                            if(mcount[k]==true){
                                msum[k]+=count;
                            }
                        }
                    }
                    visited[i][j]=true;
                }
            }

            for(int i=0;i<m;i++){
                if(msum[i]>answer){
                    answer=msum[i];
                }
            }
            return answer;
        }
        public static void dfs(int x,int y){
            mcount[y]=true;
            count++;
            //visited[x][y]=true;
            int []dx=new int[]{0,-1,0,1};
            int []dy=new int[]{1,0,-1,0};
            for(int i=0;i<4;i++){
                int cx=x+dx[i];
                int cy=y+dy[i];
                if(cx>=0&&cy>=0&&cx<n&&cy<m&&land[cx][cy]==1&&visited[cx][cy]==false){
                    visited[cx][cy]=true;
                    dfs(cx,cy);
                }
            }


        }
    }
}
