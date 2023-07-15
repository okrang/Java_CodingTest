// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter.
// You can now see whitespace characters in your code.

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class sol2667 {
    static int [][] graph;
    static int count;
    static int n;


    public static void main(String[] args) throws IOException{
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        graph=new int[n][n];
        for(int i=0;i<n;i++){
            String st=br.readLine();
            for(int j=0;j<n;j++) {
                graph[i][j] = Character.getNumericValue(st.charAt(j));
            }


        }
        ArrayList housecount=new ArrayList();
        count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j]==1){
                    dfs(i,j);
                    housecount.add(count);
                    count=0;
                }
            }
        }
        System.out.println(housecount.size());
        Collections.sort(housecount);
        for(int i=0;i<housecount.size();i++){
            System.out.println(housecount.get(i));
        }



    }
    public static void dfs(int i, int j){
        graph[i][j]=0;
        count++;
        int [] di={-1,0,1,0};
        int [] dj={0,1,0,-1};

        for(int a=0;a<4;a++){
            int ci=i+di[a];
            int cj=j+dj[a];
            if(ci>=0&&cj>=0&&ci<n&&cj<n){
                if(graph[ci][cj]==1){
                    dfs(ci,cj);
                }
            }
        }

    }
}