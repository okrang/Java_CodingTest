package BFS_DFS;

import java.util.*;
import java.io.*;

public class sol7576 {
    static int n,m;
    static int graph[][];
   // static boolean visited[][];
    static int count=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        graph=new int[n][m];

        Queue<Node> que=new LinkedList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(graph[i][j]==1){
                    que.offer(new Node(i,j));
                }
            }
        }
        while(!que.isEmpty()){

            int [] cx={0,1,0,-1};
            int [] cy={1,0,-1,0};
            int length=que.size();
            for(int k=0;k<length;k++){
                Node node=que.poll();
               // graph[node.x][node.y]=1;
                for(int i=0;i<4;i++){
                    int dx=node.x+cx[i];
                    int dy=node.y+cy[i];
                    if(dx>=0&&dy>=0&&dx<n&&dy<m&&graph[dx][dy]==0){
                        graph[dx][dy]=1;
                        que.offer(new Node(dx,dy));
                    }

                }
            }
            if(!que.isEmpty()){
                count++;
            }



        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j]==0){
                    count=-1;
                    break;
                }
            }
        }



        System.out.println(count);

    }
    public static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }


    }
}