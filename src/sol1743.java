// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. Y
// ou can now see whitespace characters in your code.
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class sol1743 {
    static int n;
    static int m;
    static int k;
    static int tsize;
    static int tmp;

    static boolean [][] graph;
    //static boolean [][] visited;

    public static void main(String[] args) throws IOException{
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        graph=new boolean[n][m];

        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph[a-1][b-1]=true;

        }
        tsize=0;
        tmp=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j]){
                    dfs(i,j);
                    if(tmp>tsize){
                        tsize=tmp;
                    }
                    tmp=0;
                }
            }
        }


    System.out.println(tsize);




    }
    public static void dfs(int a,int b){
        int [] da={-1,0,1,0};
        int [] db={0,1,0,-1};
        graph[a][b]=false;
        tmp++;

        for(int i=0;i<4;i++){
            int ca=a+da[i];
            int cb=b+db[i];
            if(ca>=0&&cb>=0&&ca<n&&cb<m){
                if(graph[ca][cb]==true){
                    dfs(ca,cb);
                }
            }
        }




    }
}