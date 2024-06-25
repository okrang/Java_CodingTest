package greddy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class NDB03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String st=br.readLine();
        int n=st.length();
        int one=0;
        int zero=0;
        char seq='2';
        for(int i=0;i<n;i++){
            char tmp=st.charAt(i);
            if(tmp!=seq){
                seq=tmp;
                if(seq=='1'){
                    one++;
                }else{
                    zero++;
                }
            }

        }
        System.out.println(Math.min(one,zero));
    }
}
