package stacks.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RainWaterTrapping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for(int i=0; i<n; i++)
            array[i] = Integer.parseInt(br.readLine());
        System.out.println("The amount of rain water trapped : " + solver(array));
    }
    public static int solver(int[] array) {
        


        int sum = 0;
        return sum;
    }
}
