package test;

public class Fibo2 {
    public static void main ( String[] args){

        //fibonacci series and previous + Next
        int n= 20; //for printing first 20 terms
        int first = 0; int next=1;
        System.out.print( first +" , " + next);

        for ( int c =2;c<20;c++){
            int sum = first + next;
            System.out.print(" ,"+ sum);
            first  = next ;
            next = sum;
        }

        // code to check if a numver is divisibble by 2
        int number = 10; // Example number
        if (number % 2 == 0) {
            System.out.println("\n" + number + " is divisible by 2.");
        } else {
            System.out.println("\n" + number + " is not divisible by 2.");
        }

    }
}
