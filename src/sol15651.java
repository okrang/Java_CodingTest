import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class sol15651 {
    static int n,m;
    static StringBuilder sb=new StringBuilder();
    static int graph[];
    public static void main(String[] args) throws IOException {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        graph=new int[m];
        back(0);
        System.out.println(sb);



    }
    public static void back(int depth){
        if(depth==m){
            for(int i=0;i<m;i++){
                sb.append(graph[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=n;i++){
            graph[depth]=i;
            back(depth+1);

        }

    }

}