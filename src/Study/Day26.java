package Study;
import java.io.*;
import java.util.*;

public class Day26 {
    static class Node{
        int x,dist;
        public Node(int x,int dist){
            this.x=x;
            this.dist=dist;
        }
    }
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());
        ArrayList<Integer> [] arr=new ArrayList [n+1];
        for(int i=1;i<n+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            arr[start].add(end);
        }

        ArrayList<Integer> result=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(x,0));
        while(!q.isEmpty()){
            Node node=q.poll();
            for(int i=0;i<n;i++){

            }
        }

        if(result.size()==0){
            System.out.println(-1);
        }else{
            for(int i=0;i<result.size();i++){
                System.out.println(result.get(i));
            }
        }


    }


}
