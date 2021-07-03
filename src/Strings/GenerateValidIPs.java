package Strings;

import java.util.ArrayList;

public class GenerateValidIPs {
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(generateValidIP(s).toString());
    }

    public static boolean isValid(String s){
        String[] parts = s.split("[.]");
        for(String part : parts){
            int ip = Integer.parseInt(part);
            // if the length of the part is greater than 3 or ip is not between 0 and 255 -> invalid
            if(part.length() > 3 || ip < 0 || ip > 255)
                return false;
            // if leading 0
            if (part.length() > 1 && ip == 0)
                return false;
            if (part.length() > 1 && ip != 0
                    && part.charAt(0) == '0')
                return false;
        }
        return true;
    }

    public static ArrayList<String> generateValidIP(String s){
        ArrayList<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12){
            return res;
        }
        /*
            Generate all four part combinations of the given string and check validity of the strings formed.
            Time - O(N*3)
         */
        int size = s.length();
        String newString = s;
        for(int i=1; i<size-2; i++){
            for(int j=i+1; j<size-1; j++){
                for(int k=j+1; k<size; k++){
                    newString = newString.substring(0,k) + "." + newString.substring(k);
                    newString = newString.substring(0,j) + "." + newString.substring(j);
                    newString = newString.substring(0,i) + "." + newString.substring(i);
                    if(isValid(newString)){
                        res.add(newString);
                    }
                    newString = s;
                }
            }
        }

        return res;
    }
}
