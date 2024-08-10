package Study;

import javax.swing.text.SimpleAttributeSet;
import java.io.*;
import java.util.*;

public class Day06 {
    static int n,m;
    static int [][] graph;
   // static boolean [][] visited;
    static int MAX_COUNT;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        MAX_COUNT=0;
        graph=new int[n][m];
       // visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j]==0){

                    BFS(i,j);


                }

            }
        }
        System.out.println(MAX_COUNT);

    }
    public static void BFS(int x, int y){
        boolean[][] visited=new boolean[n][m];
        int count=0;
        int []dx={-1,-1,-1,0,0,1,1,1};
        int []dy={-1,0,1,-1,1,-1,0,1};
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y]=true;
        while(!q.isEmpty()){
            count++;
            int size=q.size();
            for(int i=0;i<size;i++){
                Node node1=q.poll();
               // System.out.println(node1.x+" "+node1.y);

                for(int j=0;j<8;j++){
                    int cx=node1.x+dx[j];
                    int cy=node1.y+dy[j];
                    if(cx>=0&&cy>=0&&cx<n&&cy<m&&visited[cx][cy]==false){
                        if(graph[cx][cy]==1){
                            MAX_COUNT=Math.max(MAX_COUNT,count);

                            return;
                        }else{
                            visited[cx][cy]=true;
                            q.add(new Node(cx,cy));
                        }
                    }
                }
            }



        }

    }
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

}
