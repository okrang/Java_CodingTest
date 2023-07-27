// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class sol7562 {
    public static int [][] graph;
    public static int [][] distance;
    public static int chess;
    public static int y,x,a,b;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        Queue<int[]> que;
        for(int i=0;i<n;i++){
            que=new LinkedList<>();
            chess=Integer.parseInt(br.readLine());
            graph=new int [chess][chess];
            distance=new int [chess][chess];


            st=new StringTokenizer(br.readLine());
            y=Integer.parseInt(st.nextToken());
            x=Integer.parseInt(st.nextToken());
            //graph[y][x]=1;
            que.offer(new int[]{y,x});
            graph[y][x]=1;

            st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            //graph[a][b]=1;

            while(!que.isEmpty()){
                int[] point=que.poll();

                int[] dy={-2,-1,1,2,2,1,-1,-2};
                int[] dx={1,2,2,1,-1,-2,-2,-1};
                if(point[0]==a&&point[1]==b){
                    break;
                }
                for(int k=0;k<8;k++){
                    int cy=point[0]+dy[k];
                    int cx=point[1]+dx[k];
                    if(cy>=0&&cx>=0&&cy<chess&&cx<chess&&graph[cy][cx]!=1){
                        que.offer(new int[]{cy,cx});
                        graph[cy][cx]=1;
                        distance[cy][cx]=distance[point[0]][point[1]]+1;
                    }
                }





            }

            System.out.println(distance[a][b]);









        }

    }
}