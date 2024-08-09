package Study;

import java.io.*;
import java.util.*;
public class Day05 {
    static boolean[][] visited;
    static int h,w,t;
    static char[][] sheeps;
    static int count;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k=0;k<t;k++) {
            st= new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            visited = new boolean[h][w];
            sheeps = new char[h][w];
            count = 0;
            for (int i = 0; i < h; i++) {
                String str=br.readLine();
                for (int j = 0; j < w; j++) {
                    sheeps[i][j] = str.charAt(j);
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j] == false && sheeps[i][j] == '#') {
                        visited[i][j] = true;
                        dfs(i, j);
                        count++;

                    }
                }
            }
            System.out.println(count);
        }

    }
    public static void dfs(int x, int y){
     int []dx={0,1,0,-1};
     int []dy={1,0,-1,0};

     for(int i=0;i<4;i++){
         int cx=x+dx[i];
         int cy=y+dy[i];
         if(cx>=0&&cy>=0&&cx<h&&cy<w&&visited[cx][cy]==false){
             visited[cx][cy]=true;
             if(sheeps[cx][cy]=='#'){
                 dfs(cx,cy);
             }

         }

     }
    }
}
