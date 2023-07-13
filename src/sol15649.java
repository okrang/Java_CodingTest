// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.lang.StringBuilder;

public class sol15649 {
    static StringBuilder sb =new StringBuilder();
    static int n;
    static int m;
    static int[] arr;
    static boolean [] visited;



    public static void main(String[] args) throws IOException{
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[m];
        visited=new boolean[n];
        dfs(0);
        System.out.println(sb);

    }

    public static void dfs(int depth){
        if(depth==m){
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                arr[depth]=i+1;
                dfs(depth+1);
                visited[i]=false;
            }
        }

    }
}