import java.io.*;
import java.util.*;
import java.util.Collections;
public class sol24463 {
    static int n,m;
    static int count;
    static String [][] graph;
    static int [][] distance;
    static boolean [][] checkroute;
    static int endx,endy;
    static boolean [][] visited;
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException{
        //Stack<Integer> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        graph=new String[n][m];
        visited=new boolean[n][m];
        distance=new int[n][m];
        checkroute=new boolean[n][m];
        String str;
        ArrayList<int[]> arrlist=new ArrayList<>();
        for(int i=0;i<n;i++){
            str= br.readLine();;
            for(int j=0;j<m;j++){
                graph[i][j]=Character.toString(str.charAt(j));
                if((i==0||j==0)&&graph[i][j].equals(".")){
                    arrlist.add(new int[]{i,j});
                }
                if((i==n-1||j==m-1)&&graph[i][j].equals(".")){
                    arrlist.add(new int[]{i,j});
                }
            }
        }

        endx=arrlist.get(1)[0];
        endy=arrlist.get(1)[1];
        count=n*m;

        finding(arrlist.get(0)[0],arrlist.get(0)[1]);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j].equals(".")&&checkroute[i][j]==false){
                    graph[i][j]="@";
                }
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

    public static boolean finding(int x,int y){
        int[] dx={1,0,-1,0};
        int[] dy={0,1,0,-1};
        visited[x][y]=true;
        if(x==endx&&y==endy){
            if(distance[x][y]<count){
                count=distance[x][y];
                checkroute[x][y]=true;
                return true;
            }else{
                checkroute[x][y]=false;
                return false;
            }
        }
        boolean [] checktf=new boolean[4];
        for(int i=0;i<4;i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cx < n && cy >= 0 && cy < m && visited[cx][cy] == false && graph[cx][cy].equals(".")) {
                visited[cx][cy] = true;
                distance[cx][cy]=distance[x][y]+1;
                boolean tf=finding(cx, cy);
                checktf[i]=tf;
            }else{
                checktf[i]=false;
            }
        }
        for(int i=0;i<4;i++){
            if(checktf[i]==true){
                checkroute[x][y]=true;
                return true;
            }
        }
        checkroute[x][y]=false;
        return false;
    }


}