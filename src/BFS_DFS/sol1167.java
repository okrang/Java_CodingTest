package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

import java.util.*;


public class sol1167 {
    static int n;
    static int max=0;
    static int node;
    static ArrayList<Node>[] graph;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            while(true){

                int idx=Integer.parseInt(st.nextToken());
                if(idx==-1) break;
                int dist=Integer.parseInt(st.nextToken());
                graph[start].add(new Node(idx,dist));
            }
        }
        node=1;
        visited=new boolean[n+1];
        visited[1]=true;
        dfs(1,0);

        visited=new boolean[n+1];
        visited[node]=true;
        dfs(node,0);

        System.out.println(max);



    }
    public static void dfs(int k,int distance){
        if(distance>max){
            max=distance;
            node=k;
            System.out.println("node: "+node+"  max: "+max);
        }

        for(int i=0;i<graph[k].size();i++){
            Node node1=graph[k].get(i);
            if(visited[node1.idx]==false){
                visited[node1.idx]=true;
                dfs(node1.idx,distance+node1.dist);

            }
        }

    }
    public static class Node{
        int idx;
        int dist;
        public Node(int idx,int dist){
            this.idx=idx;
            this.dist=dist;
        }
    }
}