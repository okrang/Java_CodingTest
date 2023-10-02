package BFS_DFS;
import java.io.*;
import java.util.*;
public class sol7569 {
    public static void main(String[] args) throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int m=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int h=Integer.parseInt(st.nextToken());
        int [][][] graph=new int[h][n][m];
        Queue<Node1> q=new LinkedList<>();
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++){
                    graph[i][j][k]=Integer.parseInt(st.nextToken());
                    if(graph[i][j][k]==1){
                        q.offer(new Node1(i,j,k));
                    }
                }
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int [] dx={0,1,0,-1};
            int [] dy={1,0,-1,0};
            int [] dz={1,-1};
            int length=q.size();
            for(int k=0;k<length;k++){
                //System.out.println(q.peek());

                Node1 node=q.poll();
                int nodez=node.z;
                int nodex=node.x;
                int nodey=node.y;


                for(int i=0;i<4;i++){
                    int cx=nodex+dx[i];
                    int cy=nodey+dy[i];
                    if(cx>=0&&cy>=0&&cx<n&&cy<m&&graph[nodez][cx][cy]==0){
                        graph[nodez][cx][cy]=1;

                        q.offer(new Node1(nodez,cx,cy));
                    }
                }
                for(int i=0;i<2;i++){
                    int cz=nodez+dz[i];
                    if(cz>=0&&cz<h&&graph[cz][nodex][nodey]==0){
                        graph[cz][nodex][nodey]=1;
                        q.offer(new Node1(cz,nodex,nodey));
                    }
                }

            }
            if(!q.isEmpty()){
                count++;
            }
        }
        loop:
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(graph[i][j][k]==0){
                        count=-1;
                        break loop;
                    }
                }
            }
        }

        System.out.println(count);

    }
    public static class Node1{
        int x;
        int y;
        int z;
        public Node1(int z,int x,int y){
            this.x=x;
            this.y=y;
            this.z=z;
        }
//        public String toString(){
//            System.out.println("z: "+this.z+" x: "+this.x+" y: "+this.y);
//        }
    }
}