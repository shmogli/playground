package test;
//wroting code for fibonacci series in java
public class Fibo {
    public static void main(String[] args) {
        // Fibonacci series in Java
        int n = 20; // Number of terms in the Fibonacci series
        int firstTerm = 0, secondTerm = 1;

        System.out.println("Fibonacci Series up to " + n + " terms:");

        for (int i = 1; i <= n; ++i) {
            System.out.print(firstTerm + ", ");

            // Compute the next term
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }

}
