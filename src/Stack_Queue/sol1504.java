package Stack_Queue;
import java.io.*;
import java.util.*;

public class sol1504 {
    static ArrayList<Node>[] graph;
    static int n,m,v1,v2;
    static boolean v1v2;
    static int min=Integer.MAX_VALUE;
    static boolean visited[];
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        visited=new boolean[n+1];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }
        st=new StringTokenizer(br.readLine());

        v1=Integer.parseInt(st.nextToken());
        v2=Integer.parseInt(st.nextToken());
        long distv1=0;
        long distv2=0;
        distv1+=dijk(1,v1);
        distv1+=dijk(v1,v2);
        distv1+=dijk(v2,n);
        distv2+=dijk(1,v2);
        distv2+=dijk(v2,v1);
        distv2+=dijk(v1,n);


        System.out.println(distv2>=Long.MAX_VALUE&&distv1>=Long.MAX_VALUE?-1:Math.min(distv1,distv2));

    }
    public static int dijk(int a,int b){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        int distance[]=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        pq.add(new Node(a,0));
        distance[a]=0;
        while(!pq.isEmpty()){
            Node node=pq.poll();
            int v=node.v;
            int dist=node.dist;
            if(distance[v]<dist){
                continue;
            }
            for(Node nxt: graph[v]){
                int nxtv=nxt.v;
                int nxtdist=nxt.dist;
                int tmp=nxtdist+dist;
                if(tmp<distance[nxtv]){
                    distance[nxtv]=tmp;
                    pq.add(new Node(nxtv,tmp));

                }

            }


        }

        return distance[b];

    }



    public static class Node implements Comparable<Node>{
        int v;
        int dist;
        public Node(int v,int dist){
            this.v=v;
            this.dist=dist;
        }
        @Override
        public int compareTo(Node o){
            return this.dist-o.dist;

        }

    }
}