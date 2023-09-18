import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sol1043 {
    static int n,m;
    static int [][] graph;
    static boolean [][] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        count=m;
        st=new StringTokenizer(br.readLine());

        int trueperson=Integer.parseInt(st.nextToken());
        ArrayList<Integer> persons=new ArrayList<>();
        for(int i=0;i<trueperson;i++){
            persons.add(Integer.parseInt(st.nextToken()));
        }
        if(trueperson==0){
            System.out.println(m);
        }else {
            graph=new int [m][n];
            visited=new boolean[m][n];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                for (int j = 0; j < p; j++) {
                    //참석: 1
                    int k=Integer.parseInt(st.nextToken());
                    graph[i][k-1]=1;
                    //알고있는 사람:2
                    if(persons.contains(k)){
                        graph[i][k]=2;
                    }

                }

            }

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(graph[i][j]==2&&visited[i][j]==false){
                        dfs(i,j);
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(graph[i][j]==2){
                       count--;
                       break;
                    }
                }
            }
            System.out.println(count);


        }

    }
    static void dfs(int i,int j){
        visited[i][j]=true;
        int[] dx=new int[]{1,0,-1,0};
        int[] dy=new int[]{0,1,0,-1};
        for(int k=0;k<4;k++){
            int cx=i+dx[k];
            int cy=j+dy[k];
            if(cx>=0&&cy>=0&&cx<m&&cy<n){
                if(graph[cx][cy]==0){
                    visited[cx][cy]=true;
                    dfs(cx+dx[k],cy+dy[k]);
                }
                if(graph[cx][cy]==1){
                    graph[cx][cy]=2;
                    visited[cx][cy]=true;
                }
                if(graph[cx][cy]==2&&visited[cx][cy]==false){
                    dfs(cx,cy);
                }

            }


        }

    }
}