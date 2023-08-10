// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class sol2644_bfs {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean [] visit;
    static int [] distance;
    static int count;
    static int p1;
    static int p2;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        p1=Integer.parseInt(st.nextToken());
        p2=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(br.readLine());
        graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        visit=new boolean[n+1];
        distance=new int[n+1];
        count=-1;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);

        }

        Queue<Integer> que=new LinkedList<Integer>();

        que.add(p1);
        int tmpcount=0;
        while(!que.isEmpty()){
            int node=que.poll();
            visit[node]=true;
            if(node==p2){
                count=distance[node];
            }
            for(int i=0;i<graph.get(node).size();i++){
                int nextnode=graph.get(node).get(i);
                if(!visit[nextnode]){
                    que.offer(nextnode);
                    distance[nextnode]=distance[node]+1;
                }
            }


        }
        System.out.println(count);




    }
}