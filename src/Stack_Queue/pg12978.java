package Stack_Queue;
import java.util.*;
public class pg12978 {
    public static void main(String[] args) {


    }

    class Solution {
        static int [] dist;
        static ArrayList<Node>[] graph;
        public int solution(int N, int[][] road, int K) {
            int answer = 0;
            dist=new int[N+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            graph=new ArrayList[N+1];
            for(int i=0;i<dist.length;i++){
                graph[i]=new ArrayList<>();
            }
            for(int i=0;i<road.length;i++){
                graph[road[i][0]].add(new Node(road[i][1],road[i][2]));
                graph[road[i][1]].add(new Node(road[i][0],road[i][2]));
            }
            PriorityQueue<Node> que=new PriorityQueue<>();
            que.offer(new Node(1,0));
            while(!que.isEmpty()){
                Node node=que.poll();


            }


            return answer;
        }
        static class Node implements Comparable<Node>{
            int vertex;
            int dist;
            public Node(int vertex, int dist){
                this.vertex=vertex;
                this.dist=dist;
            }
            @Override
            public int compareTo(Node o){
                return this.dist-o.dist;
            }


        }
    }
}