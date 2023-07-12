// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class sol1012 {
    static boolean [][] visited;
    static int[][] arr;
    static int m;
    static int n;
    public static void main(String[] args) throws IOException{
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());



        for(int a=0;a<t;a++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count=0;


            arr = new int[n][m];
            //Arrays.fill(arr,0);


            for (int i = 0; i < k; i++) {

                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;

            }

            visited=new boolean[n][m];
            for(int i=0;i<arr.length;i++){
                System.out.println(Arrays.toString(arr[i]));
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j]==1&&!visited[i][j]){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            for(int i=0;i<arr.length;i++){
                System.out.println(Arrays.toString(visited[i]));
            }
            System.out.println(count);




        }

    }
    public static void dfs(int y, int x){
        visited[y][x]=true;
        //위 오 아 왼
        int [] dx={0,1,0,-1};
        int [] dy={-1,0,1,0};

        for(int i=0;i<4;i++){
            int cx=x+dx[i];
            int cy=y+dy[i];
            if(cx>=0&&cy>=0&&cx<m&&cy<n){
                if(arr[cy][cx]==1&&!visited[cy][cx]){
                    dfs(cy,cx);
                }
            }
        }


    }
}