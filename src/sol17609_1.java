import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class sol17609_1 {
    static String str;
    static class Position{
        int left;
        int right;
        public Position(int left,int right){
            this.left=left;
            this.right=right;
        }


    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            int lang = str.length();
            Position pos=new Position(0,lang-1);
            if(check(pos)){
                System.out.println(0);
            }else{
                if(check(new Position(pos.left+1,pos.right))||check(new Position(pos.left,pos.right-1))){
                    System.out.println(1);
                }else{
                    System.out.println(2);
                }
            }
        }
    }
    public static boolean check(Position pos){
        while(pos.left<=pos.right){
            if(str.charAt(pos.left)==str.charAt(pos.right)){
                pos.left++;
                pos.right--;
            }else{
                return false;
            }
        }
        return true;
    }
}