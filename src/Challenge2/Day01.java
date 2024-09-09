package Challenge2;
import java.io.*;
import java.util.*;
public class Day01 {
    static class Node{
        int x;
        int count;
        public Node(int x,int count){
            this.x=x;
            this.count=count;
        }

    }
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int [] arr=new int[n+1];
        for(int i=1;i<n+1;i++){
         arr[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());

        boolean [] visited=new boolean [n+1];
        int result=-1;
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(a,0));
        while(!q.isEmpty()){
            Node now=q.poll();
            int num=arr[now.x];
            if(now.x==b){
                result=now.count;
                break;
            }
            for(int i=now.x;i<=n;i+=num){
                if(visited[i]==true) continue;
                visited[i]=true;
                q.add(new Node(i,now.count+1));
            }
            for(int i=now.x;i>=1;i-=num){
                if(visited[i]==true) continue;
                visited[i]=true;
                q.add(new Node(i,now.count+1));
            }
        }
        System.out.println(result);
    }
}
