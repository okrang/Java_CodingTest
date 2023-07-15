// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol15650 {
    static boolean[] graph;;
    static int depth;
    static int n;
    static int [] printnum;
    public static void main(String[] args) throws IOException{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            depth=Integer.parseInt(st.nextToken());
            graph=new boolean[n];
            printnum=new int[depth];

            dfs(0,0);
    }
    public static void dfs(int at, int dep){
        if(dep==depth){
            for(int i=0;i<depth;i++){
                System.out.print(printnum[i]+" ");
            }

            System.out.println();
            return;
        }



        for(int i=at;i<n;i++){

                printnum[dep] = i + 1;

                dfs(i+1,dep + 1);


        }





    }
}