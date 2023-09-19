import java.io.*;
import java.util.ArrayList;

public class sol17609 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String str=br.readLine();
            int lang=str.length();
            ArrayList<Character> charlist=new ArrayList<>();
            for(int j=0;j<lang;j++){
                charlist.add(str.charAt(j));
            }
            boolean similar=false;
            int result=0;
            while(true){
                if(charlist.size()<=1){
                    break;
                }
                if(charlist.get(0)==charlist.get(charlist.size()-1)){
                    charlist.remove(0);
                    charlist.remove(charlist.size()-1);
                }else{
                    if(similar==true){
                        result=0;
                        break;
                    }else{
                        if(charlist.get(0)==charlist.get(charlist.size()-2)){
                            charlist.remove(0);
                            charlist.remove(charlist.size()-2);
                            charlist.remove(charlist.size()-1);
                            similar=true;
                            result=1;
                        }else if(charlist.get(1)==charlist.get(charlist.size()-1)){
                            charlist.remove(0);
                            charlist.remove(1);
                            charlist.remove(charlist.size()-1);
                            similar=true;
                            result=1;
                        }else{
                            result=2;
                            break;
                        }
                    }
                }
            }

            System.out.println(result);


        }


    }
}