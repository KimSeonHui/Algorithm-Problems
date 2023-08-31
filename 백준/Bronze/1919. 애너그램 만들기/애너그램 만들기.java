
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        
        for(int i = 0; i<str1.length(); i++) {
            arr1[str1.charAt(i) - 'a']++;
        }
        for(int i = 0; i<str2.length(); i++) {
            arr2[str2.charAt(i) - 'a']++;
        }
        
        
        for(int i = 0; i<str2.length(); i++) {
            if(arr1[str2.charAt(i) - 'a'] != 0) arr1[str2.charAt(i) - 'a']--;
//            System.out.println(str2.charAt(i) + " " + (str2.charAt(i) - 'a') + " " + arr[str2.charAt(i) - 'a']);
        }
        for(int i = 0; i<str1.length(); i++) {
            if(arr2[str1.charAt(i) - 'a'] != 0) arr2[str1.charAt(i) - 'a']--;
//            System.out.println(str2.charAt(i) + " " + (str2.charAt(i) - 'a') + " " + arr[str2.charAt(i) - 'a']);
        }


        int sum = 0;
        for(int i=0; i<arr1.length; i++) {
            sum += arr1[i];
        }
        for(int i=0; i<arr2.length; i++) {
            sum += arr2[i];
        }

        System.out.println(sum);
    }
}