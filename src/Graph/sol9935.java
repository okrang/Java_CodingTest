package Graph;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;

public class sol9935 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String str=br.readLine();
        String answer="FRULA";
        String bomb=br.readLine();
        int bombleng=bomb.length();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++) {
            int count=0;
            stack.push(str.charAt(i));
            if(stack.size()>=bombleng) {
                for(int j=0;j<bombleng;j++) {
                    if(stack.get(stack.size()-bombleng+j)==bomb.charAt(j)) {
                        count++;
                    }
                    if(count==bomb.length()) {
                        for(int k=0;k<bombleng;k++) {
                            stack.pop();
                        }

                    }
                }

            }
        }
        if(stack.isEmpty()) {
            System.out.println(answer);
        }else{
            for(char ch:stack)
                sb.append(ch);
            System.out.println(sb.toString());

        }



    }

}
