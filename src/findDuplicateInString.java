import java.util.HashMap;

class FindDuplicateInString
{
    public static void main(String[] args) {
        String st = "abcde";
        System.out.println(findDups(st));
    }
    public static boolean findDups(String s){
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char item : charArray) {
            if(map.get(item) != null)
                map.put(item, map.get(item) + 1);
            else
                map.put(item, 1);
            if(map.get(item)>1)
                return false;
        }
        return true;
    }
}