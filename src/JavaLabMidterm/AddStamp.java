package JavaLabMidterm;

import java.util.Scanner;


class StampBoxFullException extends Exception{
    StampBoxFullException(String s){
        super(s);
    }
}

public class AddStamp {
    int no_of_stamps = 100;
    AddStamp(){
        // do nothing
    };
    AddStamp(int requestedStampsToAdd) {
        /*
            Here we take in the number of threads the user wants to create as input and store in an array.
            And for all we start all those threads one by one, calling the addStamps method to add stamps.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of threads you want to create : ");
        int n = sc.nextInt();
        Thread[] threads = new Thread[n];
        for(int i=0; i<n; i++){
            int finalI = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        addStamps(finalI, requestedStampsToAdd);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
        for(int i=0; i<n; i++){
            try{
                threads[i].join();
            } catch(Exception e){
                System.out.println("Exception occurred.");
            }
        }
        System.out.println("The final number of stamps is :  " + no_of_stamps);
    }

    public void addStamps(int threadId, int requestedStampsToAdd) throws InterruptedException {
        /*
            All the threads call addStamps method but only one can add to the data member at a time.
            If the number of stamps exceeds 800, we throw exception
            Else if the requested number of stamps comes first, we exit the loop and display the final amount of stamps
         */
        while (true){
            synchronized (this){
                try {
                    while (no_of_stamps > 800 ){
                        throw new StampBoxFullException("Stamp Box Full.");
                    }
                    if(no_of_stamps > requestedStampsToAdd){
                        System.out.println("Number of stamps have reached requested limit.");
                        break;
                    }
                    no_of_stamps += 1;
                    System.out.println("Thread " + threadId + " is adding " + 1 + " stamps. Curr total = " + no_of_stamps);
                } catch(StampBoxFullException e){
                    System.out.println(e);
                    wait();
                }
            }
        }
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException{
        System.out.println("GOKUL MADHUSUDHAN 18BCI0152");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the final number of stamps you would like to have : ");
        int requestedStamps = sc.nextInt();

        // create and object and pass the requested number of stamps to add
        // if the requested number is greater than 800, exception will be thrown.
        AddStamp obj = new AddStamp(requestedStamps);
    }
}
