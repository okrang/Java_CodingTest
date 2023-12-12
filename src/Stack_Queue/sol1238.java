package Stack_Queue;
import java.io.*;
import java.util.*;

public class sol1238 {
    static int n,m,x;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));

        }
        int max1=0;
        for(int i=1;i<n+1;i++){
            int d1=dijk(x,i);
            int d2=dijk(i,x);
            int k=d1+d2;
            Math.max(max1,k);
            System.out.println(d1+" "+d2);
            System.out.println(max1);
        }

        System.out.println(max1);


    }
    public static int dijk(int a,int b) {
        int []distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[a] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(a, 0));
        int max = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.v;
            int dist = node.dist;
            if (distance[v] < dist) {
                continue;
            }
            for (int i = 0; i < graph[v].size(); i++) {
                Node nxt = graph[v].get(i);
                int nxtv = nxt.v;
                int nxtdist = nxt.dist;
                if (distance[nxtv] > nxtdist + dist) {
                    distance[nxtv] = nxtdist + dist;
                    pq.add(new Node(nxtv, nxtdist + dist));

                }
            }
        }
        return(distance[b]);
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