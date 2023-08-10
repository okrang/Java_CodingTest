// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class sol1541 {
    public static void main(String[] args){
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=str.length();
        String tmpint="";
        int result=0;
        int tmpminus=0;
        boolean minusplus=false;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='-'){
                if(minusplus==false){
                    result+=Integer.parseInt(tmpint);
                    minusplus=true;
                    tmpint="";
                }else{
                    tmpminus+=Integer.parseInt(tmpint);
                    result-=tmpminus;
                    tmpminus=0;
                    tmpint="";

                }



            }else if(str.charAt(i)=='+'){
                if(minusplus==false){
                    result+=Integer.parseInt(tmpint);
                    tmpint="";
                }else{
                    tmpminus+=Integer.parseInt(tmpint);
                    tmpint="";

                }


            }else{
                if(str.charAt(i)=='0'){
                    if(tmpint!=""){
                        tmpint+=str.charAt(i);
                    }

                }else {
                    tmpint += str.charAt(i);
                }
            }
        }
        if(minusplus==false){
            result+=Integer.parseInt(tmpint);
        }else{
            tmpminus+=Integer.parseInt(tmpint);
            result-=tmpminus;
        }

        System.out.println(result);

    }
}