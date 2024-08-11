package Study;
import java.io.*;
import java.util.*;
public class Day07 {
    static int n;
    static int [][] graph;
    static boolean [][] visited;
    static ArrayList<Integer> list;
    static int count;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        graph=new int[n][n];
        visited=new boolean[n][n];
        list=new ArrayList<>();

        for(int i=0;i<n;i++){
            String str=br.readLine();
            for(int j=0;j<n;j++){
                graph[i][j]=str.charAt(j)-'0';

            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //System.out.println(graph[i][j]);
                if(visited[i][j]==false&&graph[i][j]==1){
                    visited[i][j]=true;
                    count=1;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    public static void dfs(int x, int y){
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        for(int i=0;i<4;i++){
            int cx=x+dx[i];
            int cy=y+dy[i];
            if(cx>=0&&cy>=0&&cx<n&&cy<n){
                if(graph[cx][cy]==1&&visited[cx][cy]==false){
                    count++;
                    visited[cx][cy]=true;
                    dfs(cx,cy);
                }
            }

        }
    }
}
