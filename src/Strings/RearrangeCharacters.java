package Strings;

import java.util.Scanner;

/*
https://practice.geeksforgeeks.org/contest/coding-try-outs-amazon/problems
 */
public class RearrangeCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            int[] freq = new int[26];
            boolean isOddLength = (s.length()%2 != 0);
            boolean isPossible = true;
            for(int i=0; i<s.length(); i++){
                freq[s.charAt(i)-'a']++;
                if(isOddLength && freq[s.charAt(i)-'a'] > s.length()/2+1){
                    isPossible = false;
                    break;
                } else if(!isOddLength && freq[s.charAt(i)-'a'] > s.length()/2){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible){
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
