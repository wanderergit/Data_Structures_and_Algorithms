package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class ShopInCandyStore {
    static void reverse(int[] sorted){
        int l = 0;
        int h = sorted.length-1;
        while(l < h){
            int temp = sorted[l];
            sorted[l] = sorted[h];
            sorted[h] = temp;
            l++;
            h--;
        }
    }

    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        // for minimum amount to be spent, we can just sort in increasing order of prices
        // and then we maintain count of how many expensive candies (from the back of array)
        // we pick (K for every cheapest candy bought)
        // also track how many candies left to buy

        ArrayList<Integer> result = new ArrayList<>();
        int sorted[] = candies;
        Arrays.sort(sorted);

        int candiesLeftToBuy = N;
        int candiesBought = 0;
        int minSpent = 0;
        for(int i=0; i<N; i++){
            if(candiesLeftToBuy <= 0) break;
            minSpent += sorted[i];
            candiesBought += 1;
            candiesLeftToBuy-=1;
            int freeCandies = Math.min(candiesLeftToBuy, K);
            candiesBought += freeCandies;
            candiesLeftToBuy-=freeCandies;
        }
        result.add(minSpent);
        // System.out.println(minSpent);

        reverse(sorted);

        candiesLeftToBuy = N;
        candiesBought = 0;
        int maxSpent = 0;
        for(int i=0; i<N; i++){
            if(candiesLeftToBuy <= 0) break;
            maxSpent += sorted[i];
            candiesBought += 1;
            candiesLeftToBuy-=1;
            int freeCandies = Math.min(candiesLeftToBuy, K);
            candiesBought += freeCandies;
            candiesLeftToBuy-=freeCandies;
        }

        result.add(maxSpent);
        return result;
    }
}
