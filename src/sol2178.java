// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class sol2178 {
    static int n,m;
    static int [][] graph;
    static int [][] distance;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());


        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

       graph=new int[n][m];
       distance=new int[n][m];


        for(int i=0;i<n;i++){
            String str=br.readLine();
            for(int j=0;j<m;j++){
                graph[i][j]=str.charAt(j)-'0';
            }

        }
        distance[0][0]=1;
        bfs(0,0);



    }
    public static void bfs(int y,int x){
        int[] dy={-1,0,1,0};
        int[] dx={0,1,0,-1};
        Queue<int[]> que=new LinkedList<>();
        graph[0][0]=0;
        que.offer(new int []{0,0});

        while(!que.isEmpty()){
            int[] point=que.poll();
            if(point[0]==n-1&&point[1]==m-1){
                System.out.println(distance[n-1][m-1]);
                break;
            }
            for(int i=0;i<4;i++){
                int cy=point[0]+dy[i];
                int cx=point[1]+dx[i];
                if(cx>=0&&cy>=0&&cx<m&&cy<n&&graph[cy][cx]==1){
                    que.offer(new int[]{cy,cx});
                    graph[cy][cx]=0;
                    distance[cy][cx]=distance[point[0]][point[1]]+1;
                }
            }
        }








    }
}