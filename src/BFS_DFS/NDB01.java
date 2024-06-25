package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NDB01 {
    static int k;
    static boolean[][] visit;
    static  ArrayList<Integer> list;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());
        visit=new boolean[n+1][n+1];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            visit[start][end]=true;
        }

        list=new ArrayList<>();
        dfs(x,0);
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
    public static void dfs(int x,int count){
        if(count==k){
            if(!list.contains(x)){
                list.add(x);
            }
            return;

        }
        for(int i=0;i<visit.length;i++){
            if(visit[x][i]==true){

                dfs(i,count+1);
            }
        }
    }

}
