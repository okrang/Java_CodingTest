package greddy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class NDB05 {
    public static void main(String[] args) throws IOException {
        int[] food_times=new int[]{8,6,4};
        int k=15;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=0;i<food_times.length;i++){
            pq.add(new Node(food_times[i],i+1));
        }
        int count=food_times.length;
        int minus=0;
        while(true){
            Node node=pq.peek();
            int food=node.a;
            food-=minus;
            if(count*food<k){
                k=k-count*food;
                minus+=food;
                count--;
                pq.poll();
            }else{
                break;

            }

        }
        ArrayList<Node> list=new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.b-o2.b;
            }
        });
       System.out.println(list.get(k%count).b);




//        for(int i=0;i<food_times.length;i++){
//            System.out.println(pq.poll().a);
//        }







    }
    public static class Node implements Comparable<Node>{
        int a;
        int b;
        public int getA(){
            return this.a;
        }
        public int getB(){
            return this.b;
        }

        public Node(int a,int b){
            this.a=a;
            this.b=b;
        }
        public int compareTo(Node o){
            return this.a-o.a;
        }
    }
}
