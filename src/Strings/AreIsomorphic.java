package Strings;

public class AreIsomorphic {
    public static boolean areIsomorphic(String str1,String str2)
    {
        int[] arr = new int[256];
        int[] arr2 = new int[256];
        if(str1.length() !=str2.length())  return false;

        for(int ptr=0; ptr<str1.length(); ptr++){
            char c1 = str1.charAt(ptr);
            char c2 = str2.charAt(ptr);
            if(arr[c1] == 0 && arr2[c2] == 0){
                arr[c1] = c2;
                arr2[c2] = c1;
            } else {
                if(arr[c1] != c2 && arr2[c2] != c1) return false;
            }
        }

        return true;

    }
}
