import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class sol1074 {
    static int n,r,c,count,result;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
         n=Integer.parseInt(st.nextToken());
         r=Integer.parseInt(st.nextToken());
         r++;
         c= Integer.parseInt(st.nextToken());
         c++;
        result=0;
       recur(n);
        System.out.println(result);


    }
    public static void recur(int k){
        if(k==0){
            return;
        }
        int div=(int)Math.pow(2,k-1);
        int square=div*div;
        if(div>=r&&div>=c){
            recur(k-1);
        }else if(div>=r&&div<c){
            result+=square;
            c-=div;
            recur(k-1);

        }else if(div<r&&div>=c){
            result+=(square*2);
            r-=div;
            recur(k-1);

        }else{
            result+=(square*3);
            r-=div;
            c-=div;
            recur(k-1);

        }
    }
}