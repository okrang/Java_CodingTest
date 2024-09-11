package Challenge2;

import java.io.*;
import java.util.*;
public class Day03 {
    static int n,m,k;
    static int[][] farm;
    static boolean[][] visited;
    static int count;
    static boolean result;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        farm=new int[n][n];
        visited=new boolean[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                farm[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int start=m;
        boolean possible=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false&&farm[i][j]==0){
                    visited[i][j]=true;
                    count=1;
                    dfs(i,j);
                   // System.out.println(count);
                    int mod=count%k;
                    int div=count/k;
                    if(mod!=0){
                        div++;
                    }
                    if(m>=div){
                        m=m-=div;
                       // System.out.println(m);
                    }else{
                        possible=false;
                        break;
                    }
                }
            }
            if(possible==false){
                break;
            }
        }
        if(start==m){
            possible=false;
        }
        if(possible==false){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println("POSSIBLE");
            System.out.println(m);
        }
    }
    public static void dfs(int x,int y){
        int [] dx={-1,0,1,0};
        int [] dy={0,1,0,-1};
        for(int i=0;i<4;i++){
            int cx=x+dx[i];
            int cy=y+dy[i];
            if(cx>=0&&cy>=0&&cx<n&&cy<n){
                if(visited[cx][cy]==false&&farm[cx][cy]==0){
                    visited[cx][cy]=true;
                    count++;
                    dfs(cx,cy);

                }

            }
        }
    }
}
