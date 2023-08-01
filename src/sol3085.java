// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class sol3085 {
    static int n;
    static int max;
    static char[][] graph;
    public static void main(String[] args) throws IOException{
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        graph=new char[n][n];
        String str;
        max=1;
        char tmp;

        for(int i=0;i<n;i++){
            str=br.readLine();
            for(int j=0;j<n;j++) {
                graph[i][j] = str.charAt(j);

            }

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                tmp=graph[i][j];
                graph[i][j]=graph[i][j+1];
                graph[i][j+1]=tmp;

                search();

                tmp=graph[i][j];
                graph[i][j]=graph[i][j+1];
                graph[i][j+1]=tmp;

            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                tmp=graph[j][i];
                graph[j][i]=graph[j+1][i];
                graph[j+1][i]=tmp;

                search();

                tmp=graph[j][i];
                graph[j][i]=graph[j+1][i];
                graph[j+1][i]=tmp;

            }
        }
        System.out.println(max);



    }
    public static void search(){
        int tmp=1;
        for(int i=0;i<n;i++){
            tmp=1;
            for(int j=0;j<n-1;j++) {
                if (graph[i][j] == graph[i][j + 1]) {
                    tmp++;
                }else{
                    tmp=1;
                }
                max=Math.max(tmp,max);
            }
            max=Math.max(tmp,max);

        }


        for(int i=0;i<n;i++){
            tmp=1;
            for(int j=0;j<n-1;j++) {
                if (graph[j][i] == graph[j+1][i]) {
                    tmp++;
                }else{
                    tmp=1;
                }
                max=Math.max(tmp,max);
            }
            max=Math.max(tmp,max);

        }




    }
}