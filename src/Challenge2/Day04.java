package Challenge2;

import java.io.*;
import java.util.*;

public class Day04 {
    static int n;
    //static boolean blue;
    static char[][] colors;
    static boolean[][] visited,visitedrgb;
    static int rgb,rg;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        colors=new char[n][n];
        visited=new boolean[n][n];
        visitedrgb=new boolean[n][n];
        for(int i=0;i<n;i++){
            String str=br.readLine();
            for(int j=0;j<n;j++){
                colors[i][j]=str.charAt(j);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false){
                    rg++;
                    rg(i,j);
                }
                if(visitedrgb[i][j]==false){
                    rgb++;
                    rgb(i,j);
                }
            }
        }
        System.out.println(rgb+" "+rg);

    }
    public static void rg(int x,int y){
       // System.out.println(x+ " "+y);
        int [] dx={-1,0,1,0};
        int [] dy={0,1,0,-1};
        boolean blue=false;
        if (colors[x][y] == 'B')
            blue=true;


        //System.out.println(blue);
        visited[x][y]=true;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] color=q.poll();
            for(int i=0;i<4;i++){
                int cx=color[0]+dx[i];
                int cy=color[1]+dy[i];

                if(cx>=0&&cy>=0&&cx<n&&cy<n){
                    if(visited[cx][cy]==false){

                        if(blue==true){
                            if(colors[cx][cy]=='B'){
                                visited[cx][cy]=true;
                                q.add(new int[]{cx,cy});
                            }
                        }else{
                            if(colors[cx][cy]!='B'){
                                visited[cx][cy]=true;
                                q.add(new int[]{cx,cy});
                            }

                        }
                    }
                }
            }


        }
    }
    public static void rgb(int x,int y){
        // System.out.println(x+ " "+y);
        int [] dx={-1,0,1,0};
        int [] dy={0,1,0,-1};
        char standard;
        standard=colors[x][y];

        visitedrgb[x][y]=true;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] color=q.poll();
            for(int i=0;i<4;i++){
                int cx=color[0]+dx[i];
                int cy=color[1]+dy[i];

                if(cx>=0&&cy>=0&&cx<n&&cy<n){
                    if(visitedrgb[cx][cy]==false&&colors[cx][cy]==standard){
                        visitedrgb[cx][cy]=true;
                        q.add(new int[]{cx,cy});

                    }
                }
            }


        }
    }
}
