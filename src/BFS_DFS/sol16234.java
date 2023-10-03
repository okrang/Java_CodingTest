package BFS_DFS;
import java.io.*;
import java.util.*;
public class sol16234 {
    static int n,l,r;
    static int[][] graph;
    static boolean[][] visited;
    static int count;
    static Queue<int[]> que;
    static boolean move;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
         n=Integer.parseInt(st.nextToken());
         l=Integer.parseInt(st.nextToken());
         r=Integer.parseInt(st.nextToken());
        graph=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        count=0;
        move=false;
        que=new LinkedList<>();
        visited=new boolean[n][n];
        while(true) {
            move=false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == false) {
                        visited[i][j] = true;
                        que.offer(new int[]{i, j});
                        BFS(que);
                    }
                }
            }

            if(move==true){
                count++;
            }else{
                break;
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }

        }
        System.out.println(count);


    }
    public static void BFS(Queue<int[]> q){
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        int sum=graph[q.peek()[0]][q.peek()[1]];
        int countirescount=1;
        ArrayList<int[]> countries=new ArrayList<>();
        countries.add(new int []{q.peek()[0],q.peek()[1]});
        while(!q.isEmpty()){
            int[] country=q.poll();
            //visited[country[0]][country[1]]=true;
            for(int i=0;i<4;i++){
                int cx=country[0]+dx[i];
                int cy=country[1]+dy[i];

                if(cx>=0&&cy>=0&&cx<n&&cy<n&&visited[cx][cy]==false&&Math.abs(graph[cx][cy]-graph[country[0]][country[1]])>=l&&Math.abs(graph[cx][cy]-graph[country[0]][country[1]])<=r){
                    move=true;
                    visited[cx][cy]=true;
                    q.offer(new int[]{cx,cy});
                    countries.add(new int[]{cx,cy});
                    sum+=graph[cx][cy];
                    countirescount++;
                }
            }

        }
        int result=sum/countirescount;
        for(int i=0;i<countries.size();i++){
            int[] c=countries.get(i);
            graph[c[0]][c[1]]=result;
        }




    }
}