// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class sol2504 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int n=str.length();
        Stack<Character> stack=new Stack<>();

        int mul=1;
        int result=0;
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(ch=='('){
                stack.push(ch);
                mul*=2;

            }else if(ch=='['){
                stack.push(ch);
                mul*=3;

            }else if(ch==')'){
                if(stack.isEmpty()||stack.peek()!='('){
                    result=0;
                    break;
                }
                if(str.charAt(i-1)=='('){
                    result+=mul;


                }
                stack.pop();
                mul/=2;

            }else if(ch==']'){
                if(stack.isEmpty()||stack.peek()!='['){
                    result=0;
                    break;
                }
                if(str.charAt(i-1)=='['){
                    result+=mul;


                }
                stack.pop();
                mul/=3;


            }




            }
        System.out.println(!stack.isEmpty() ? 0 : result);




    }
}