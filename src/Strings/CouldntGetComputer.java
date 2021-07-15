package Strings;

import java.util.HashSet;

public class CouldntGetComputer {
    public static void main(String[] args) {
        System.out.println(runCustomerSimulation(1, "ABCBCADEED"));
    }
    public static int runCustomerSimulation(int n, String s){

        int freeComputers = n;
        boolean gotComputer[] = new boolean[26];
        HashSet<Integer> notGotComputer = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            int customer = s.charAt(i)-'A';
            if(gotComputer[customer]){
                gotComputer[customer] = false;
                freeComputers++;
            } else {
                if(freeComputers == 0){
                    if(!notGotComputer.contains(customer))notGotComputer.add(customer);
                } else {
                    gotComputer[customer] = true;
                    freeComputers--;
                }
            }
        }

        return notGotComputer.size();

    }
}
