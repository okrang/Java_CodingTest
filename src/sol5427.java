// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class sol5427 {
    static int x,y;
    static char [][] graph;
    static boolean [][] road;
    static Queue<int[]> q;
    static Queue<int[]> fire;
    static int count;
    public static void main(String[] args) throws IOException{
        // Press Opt+Enter with your caret at the highlighted text to see how
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int testcase=Integer.parseInt(br.readLine());
            StringTokenizer st;
            for(int t=0;t<testcase;t++){
                st=new StringTokenizer(br.readLine());
                x=Integer.parseInt(st.nextToken());
                y=Integer.parseInt(st.nextToken());
                graph=new char[y][x];
                road=new boolean [y][x];
                q=new LinkedList<>();
                fire=new LinkedList<>();

                for(int i=0;i<y;i++){
                    String str=br.readLine();
                    for(int j=0;j<x;j++){
                        graph[i][j]=str.charAt(j);
                        if(graph[i][j]=='*'){
                            fire.offer(new int[]{i,j});
                        } else if (graph[i][j] == '@') {
                            q.offer(new int[]{i,j});
                            graph[i][j]='0';
                        }else if(graph[i][j]=='.'){
                            road[i][j]=true;

                        }
                    }

                }





        System.out.println(graph[1][2]);




            }

    }
}