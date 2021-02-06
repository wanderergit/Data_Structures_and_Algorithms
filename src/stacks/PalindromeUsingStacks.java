package stacks;

import java.util.Scanner;
import java.util.Stack;

public class PalindromeUsingStacks {
    public static void main(String[] args) {
        //we will take in a string.
        //until half of the sting we will push items onto the stack
        //for the remaining half, we will next character with top of the stack,
        //if equal we will pop the item.
        //in the end if stack is empty, it is a Palindrome.

        Stack<Character> stack = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        for(int i=0; i<input.length(); i++){
            if(i<=input.length()/2){
                stack.push(input.charAt(i));
            }
            else{
                Character newChar = stack.pop();
                if(newChar != input.charAt(i)){
                    System.out.println("Not a palindrome!");
                    break;
                }
            }
            if(i == input.length()/2 && input.length()%2 != 0)
                stack.pop();
        }

        if(stack.isEmpty())
            System.out.println("Palindrome!");

    }
}
