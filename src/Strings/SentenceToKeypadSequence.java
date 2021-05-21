package Strings;

import java.util.HashMap;

/*
    Store all the possible values in a hashmap and then refer to it
 */
public class SentenceToKeypadSequence {
    public static void main(String[] args) {

        String s = "Hello World";

        HashMap<Character, String> map = new HashMap<>();
        map.put('A', "2");
        map.put('B', "22");
        map.put('C', "222");
        map.put('D', "3");
        map.put('E', "33");
        map.put('F', "333");
        map.put('G', "4");
        map.put('H', "44");
        map.put('I', "444");
        map.put('J', "5");
        map.put('K', "55");
        map.put('L', "555");
        map.put('M', "6");
        map.put('N', "66");
        map.put('O', "666");
        map.put('P', "7");
        map.put('Q', "77");
        map.put('R', "777");
        map.put('S', "7777");
        map.put('T', "8");
        map.put('U', "88");
        map.put('V', "888");
        map.put('W', "9");
        map.put('X', "99");
        map.put('Y', "999");
        map.put('z', "9999");

        String res = "";
        s = s.toUpperCase();
        for(int i=0; i<s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i)))
                res += map.get(s.charAt(i));
        }
        System.out.println(res);
    }
}
