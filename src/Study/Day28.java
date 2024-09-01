package Study;
import java.io.*;
import java.util.*;

public class Day28 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int casenumber=0;
        while(true){
            casenumber++;
            int count=0;
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            if(n==0&&m==0){
                break;
            }
            ArrayList<Integer> [] nodes=new ArrayList[n+1];
            boolean [] visited=new boolean[n+1];
            for(int i=1;i<n+1;i++){
                nodes[i]=new ArrayList<>();
            }
            for(int i=0;i<m;i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                nodes[a].add(b);
                nodes[b].add(a);
            }

            for(int i=1;i<n+1;i++){
                if(nodes[i].size()==0&&visited[i]==false){
                    count++;
                    visited[i]=true;
                }else if(visited[i]==false){

                    int nodecount=0;
                    int roadcount=0;
                    Queue<Integer> q=new LinkedList<>();
                    q.add(i);
                    while(!q.isEmpty()){
                        int k=q.poll();
                        if(visited[k]==true){
                            continue;
                        }
                        visited[k]=true;
                        nodecount++;

                        for(int j=0;j<nodes[k].size();j++){
                            int l=nodes[k].get(j);
                            roadcount++;
                            if(visited[l]==false) {
                                q.add(l);
                            }
                        }
                    }
                    if((roadcount/2==nodecount-1)&&roadcount%2==0){
                        count++;
                    }

                }
            }



            if(count==0){
                System.out.println("Case "+casenumber+": No trees.");
            }else if(count==1){
                System.out.println("Case "+casenumber+": There is one tree.");
            }else{
                System.out.println("Case "+casenumber+": A forest of "+count+" trees.");
            }



        }
    }

}
