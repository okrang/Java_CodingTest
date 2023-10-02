package Stack_Queue;
import java.util.*;
import java.io.*;
public class sol1916 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        ArrayList<Node>[] graph=new ArrayList[n+1];
        int[] distance=new int [n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int node1=Integer.parseInt(st.nextToken());
            int node2=Integer.parseInt(st.nextToken());
            int nodedist=Integer.parseInt(st.nextToken());
            graph[node1].add(new Node(node2,nodedist));

        }
        st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());


        PriorityQueue<Node> pque=new PriorityQueue<>();
        pque.add(new Node(start,0));
        while(!pque.isEmpty()){
            Node node=pque.poll();
            int nodevertex=node.vertex;
            int nodedist=node.dist;
            if(distance[nodevertex]<nodedist){
                continue;
            }
            for(int i=0;i<graph[nodevertex].size();i++){
                int nodeTo=graph[nodevertex].get(i).vertex;
                int nodeToDistance=graph[nodevertex].get(i).dist+nodedist;
                if(distance[nodeTo]>nodeToDistance){
                    distance[nodeTo]=nodeToDistance;
                    pque.add(new Node(nodeTo,nodeToDistance));
                }
            }
        }
       // System.out.println(end);
        System.out.println(distance[end]);




    }
    public static class Node implements Comparable<Node>{
        int vertex;
        int dist;
        public Node(int vertex,int dist){
            this.vertex=vertex;
            this.dist=dist;
        }
        @Override
        public int compareTo(Node o){
            return this.dist-o.dist;
        }

    }
}