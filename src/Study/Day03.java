package Study;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
public class Day03 {
    static String [][] graph;
    //static int count;
    static Set<String> set;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        set=new HashSet<>();
        graph=new String[5][5];
        for(int i=0;i<5;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                graph[i][j]=st.nextToken();
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                dfs(i,j,1,graph[i][j]);
            }
        }

        System.out.println(set.size());
    }



    public static void dfs(int x, int y, int cnt,String str){
        if(cnt==6){
            set.add(str);
            return;
        }
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        for(int i=0;i<4;i++){
            int cx=x+dx[i];
            int cy=y+dy[i];
            if(cx>=0&&cy>=0&&cx<5&&cy<5){
                dfs(cx,cy,cnt+1,str+graph[cx][cy]);
            }
        }

    }
}
