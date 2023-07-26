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
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        Queue<int[]> que=new LinkedList();
        for(int i=0;i<n;i++){

            int chess=Integer.parseInt(br.readLine());
            graph=new int [chess][chess];
            distance=new int [chess][chess];


            st=new StringTokenizer(br.readLine());
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            //graph[y][x]=1;
            que.offer(new int[]{y,x});

            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            //graph[a][b]=1;

            while(!que.isEmpty()){
                int[] point=que.poll();
                graph[point[0]][point[1]]=1;
                int[] dy={-2,-1,1,2,2,1,-1,-2};
                int[] dx={1,2,2,1,-1,-2,-2,-1};
                if(point[0]==a&&point[1]==b){
                    return;
                }
                for(int k=0;k<8;k++){
                    int cy=point[0]+dy[k];
                    int cx=point[1]+dx[k];
                    if(cy>=0&&cx>=0&&cy<chess&&cx<chess&&graph[cy][cx]!=1){
                        que.offer(new int[]{cy,cx});
                        distance[cy][cx]=distance[point[0]][point[1]]+1;
                    }
                }





            }

            System.out.println(distance[a][b]);

















        }

    }
}