package CrackTheCode;
import java.io.*;
/**
 * Created by Ash on 5/12/2017.
 * Print all the permutations of a string.
 */
public class StringPermutation {

    private void permutation(String input) {
        permutation(input, "");
    }

    private void permutation(String str, String prefix){
        if(str.length() == 0){
            System.out.println(prefix);
        }
        else{
            for(int i = 0; i < str.length(); i++){
                String rem = str.substring(0,i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void main(String[] args){
        //System.out.println("Input: ");
        String input = "";
        /*
        Uncomment these lines if you want to take input from the user.
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try{
//            input = br.readLine();
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
        input = "Ash";
        StringPermutation sp = new StringPermutation();
        sp.permutation(input);
    }
}
