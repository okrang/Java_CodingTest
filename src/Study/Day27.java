package Study;
import java.io.*;
import java.util.*;
public class Day27 {
    static class Node implements Comparable<Node>{
        int y,dist;
        public Node(int y,int dist){
            this.y=y;
            this.dist=dist;
        }
        public int compareTo(Node n1){
            return this.dist-n1.dist;
        }
    }
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Node> [] nodes=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            nodes[i]=new ArrayList<Node>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b,dist));
        }
        int [] distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());
        distance[start]=0;
        PriorityQueue<Node> q=new PriorityQueue<>();
        q.add(new Node(start,0));
        while(!q.isEmpty()){
            Node node=q.poll();
            int idx=node.y;
            int dist=node.dist;
            //System.out.println(idx);
           // System.out.println(dist);
            if(distance[idx]<dist){
                continue;
            }

            for(int i=0;i<nodes[idx].size();i++){
                Node node1=nodes[idx].get(i);
                int sumdist=node1.dist+distance[idx];
                //System.out.println(sumdist);
               // System.out.println(sumdist);
                if(sumdist<distance[node1.y]){
                    distance[node1.y]=sumdist;
                    q.add(new Node(node1.y,sumdist));
                }
            }

        }
        System.out.println(distance[end]);



    }
}
