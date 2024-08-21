package Study;
import java.io.*;
import java.util.*;
public class Day17 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        String str=br.readLine();
        char [] table=new char[n];
        boolean [] burger=new boolean[n];
        for(int i=0;i<n;i++){
            table[i]=str.charAt(i);
            if(table[i]=='P'){
                burger[i]=true;
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(table[i]=='P'){
                for(int j=i-k;j<i+k+1;j++){
                    if(j>=0&&j<n){
                        if(burger[j]==false){
                            burger[j]=true;
                            count++;
                            break;

                        }
                    }
                }
            }
        }
        System.out.println(count);

    }
}
