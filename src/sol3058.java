// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class sol3058 {
    public static void main(String[] args) throws IOException{
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        char [][] graph=new char[n][n];
        String str;
        int count=0;
        for(int i=0;i<n;i++){
            str=br.readLine();
            for(int j=0;j<n;j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        



    }
}