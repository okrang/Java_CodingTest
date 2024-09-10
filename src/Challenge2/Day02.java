package Challenge2;
import java.io.*;
import java.util.*;
public class Day02 {
    static int a,b;
    static int count;
    static int[][] map;
    static boolean [][] visited;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            if(a==0&&b==0){
                break;
            }
            count=0;
            map=new int[b][a];
            visited=new boolean[b][a];
            for(int i=0;i<b;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<a;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<b;i++){
                for(int j=0;j<a;j++){
                    if(map[i][j]==1&&visited[i][j]==false){
                        count++;
                        dfs(i,j);
                    }
                }
            }
            System.out.println(count);




        }
    }
    public static void dfs(int x,int y){
        int [] dx={-1,-1,-1,0,0,1,1,1};
        int [] dy={-1,0,1,-1,1,-1,0,1};

        for(int i=0;i<8;i++){
            int cx=x+dx[i];
            int cy=y+dy[i];
            if(cx>=0&&cy>=0&&cx<b&&cy<a){
                if(visited[cx][cy]==false&&map[cx][cy]==1){
                    visited[cx][cy]=true;
                    dfs(cx,cy);
                }
            }

        }

    }
}
