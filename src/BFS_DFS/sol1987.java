package BFS_DFS;
import java.io.*;
import java.util.*;
public class sol1987 {
    static int n,m;
    static boolean[] alpha=new boolean[26];
    static char [][] graph;
    static boolean [][] visited;
    static int max=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        graph=new char[n][m];
        for(int i=0;i<n;i++){
            String str=br.readLine();
            for(int j=0;j<m;j++){
                graph[i][j]=str.charAt(j);
            }
        }
        visited=new boolean[n][m];
        dfs(0,0,1);
        System.out.println(max);

    }
    public static void dfs(int r,int c,int count){
        int [] dr={0,1,0,-1};
        int [] dc={1,0,-1,0};
        char ch=graph[r][c];
        visited[r][c]=true;
        int temp=ch-'A';
        alpha[temp]=true;
        for(int i=0;i<4;i++){
            int cr=r+dr[i];
            int cc=c+dc[i];
            if(cc>=0&&cr>=0&&cr<n&&cc<m){
                if(visited[cr][cc]==false&&alpha[graph[cr][cc]-'A']==false){
                    dfs(cr,cc,count+1);
                }else{
                    if(max<count){
                        max=count;
                    }
                }
            }
        }
        visited[r][c]=false;
        alpha[ch-'A']=false;
    }

}