// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Queue;
public class sol7562 {
    static int testcase;
    static int chess;
    static int[] start;
    static int[] end;
    static int count=0;


    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        testcase=Integer.parseInt(br.readLine());
        for(int i=0;i<testcase;i++){
            chess=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            start=new int[2];
            start[0]=Integer.parseInt(st.nextToken());
            start[1]=Integer.parseInt(st.nextToken());
            end=new int[2];
            end[0]=Integer.parseInt(st.nextToken());
            end[1]=Integer.parseInt(st.nextToken());
            count=0;
            bfs(start[0],start[1]);





        }


    }
    public static void bfs(int y,int x){
        
    }
}