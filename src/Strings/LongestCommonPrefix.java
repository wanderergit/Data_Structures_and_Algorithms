package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {

    }
    public String longestCommonPrefix(String[] strs) {

        if(strs.length < 0)
            return "";
        else if(strs.length == 1){
            return strs[0];
        }

        int ptr1 = 0, ptr2 = 0;
        int smallestCommonPrefix = Integer.MAX_VALUE;

        for(int i=0; i<strs.length-1; i++){
            String curr = strs[i];
            String next = strs[i+1];
            int temp = 0;
            while(ptr1 < curr.length() && ptr2 < next.length()){
                if(curr.charAt(ptr1) == next.charAt(ptr2)){
                    ptr1++;
                    ptr2++;
                    temp++;
                } else break;
            }
            if(temp < smallestCommonPrefix)
                smallestCommonPrefix = temp;
            ptr1 = 0;
            ptr2 = 0;
        }

        if(smallestCommonPrefix == 0) return "";
        return strs[0].substring(0,smallestCommonPrefix);

    }
}
