package Strings;

/*
Transform One String to Another using Minimum Number of Given Operation
Operation is just deleting any character and inserting it into the front of the string
 */

public class TransformationCount {
    public static void main(String[] args) {
        System.out.println(transformCount("EACBD", "EABCD"));
    }
    static boolean anagrams(String s1, String s2){
        int[] freq = new int[26];
        if(s1.length() != s2.length())  return false;
        for(int i=0; i<s1.length(); i++)
            freq[s1.charAt(i)-'A']++;
        for(int i=0; i<s2.length(); i++)
            freq[s2.charAt(i)-'A']--;
        for(int i=0; i<26; i++){
            if(freq[i] > 0)
                return false;
        }
        return true;
    }


    static int transformCount(String s1, String s2){

        StringBuffer sb1 = new StringBuffer(s1);
        StringBuffer sb2 = new StringBuffer(s2);

        // check whether they are anagrams

        if(!anagrams(s1, s2)) return -1;

        // if the chars at index is same, continue
        // else delete char(index) from s1 and push to front, stay at the current index and check again

        int count = 0;
        int size = s1.length();
        for(int i=size-1; i>=0;){
            if(sb1.charAt(i) == sb2.charAt(i)){
                i--;
            } else {
                char toBeDeleted = sb1.charAt(i);
                sb1.delete(i,i+1);
                sb1.insert(0, toBeDeleted);
                count++;
            }
        }

        return count;

    }
}
