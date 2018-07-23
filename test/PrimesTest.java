import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class PrimesTest {
    public final int knownPrime = 7;
    public final int knownNotPrime = 4;
    public final int size = 100000;

    @Test
    @DisplayName("Testing isPrimes returns true when input is prime whole number and false when not prime.")
    void testIsPrime() {
        //Setting up test
        Primes primes = new Primes();

        //Running test
        assertEquals(primes.isPrime(knownPrime), true);
        assertEquals(primes.isPrime(knownNotPrime), false);
    }

    @Test
    @DisplayName("Time the execution of isPrime being used to evaluate a readFile containing whole numbers")
    void timeFastIsPrime() throws IOException {
        //Setting up test
        long startTime; //Time variables for timing function
        long endTime;
        long duration;

        Primes primes = new Primes();
        PrintWriter writer = new PrintWriter("primes.txt");
        File readFile = new File("numbers.txt");

        primes.writeInts(1, size, "numbers.txt");

        //Running test
        startTime = System.nanoTime();

        try(BufferedReader br = new BufferedReader(new FileReader(readFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(primes.fastIsPrime(Integer.parseInt(line)) == true) {
                    writer.println(line);
                }
            }
        }

        endTime = System.nanoTime();
        duration = (endTime - startTime) / 10000000;

        System.out.println("fastIsPrime execution time :> " + duration + "ms");
    }

    @Test
    @DisplayName("Time the execution of isPrime being used to evaluate a readFile containing whole numbers")
    void timeIsPrime() throws IOException {
        //Setting up test
        long startTime; //Time variables for timing function
        long endTime;
        long duration;

        Primes primes = new Primes();
        PrintWriter writer = new PrintWriter("primes.txt");
        File readFile = new File("numbers.txt");

        primes.writeInts(1, size, "numbers.txt");

        //Running test
        startTime = System.nanoTime();

        try(BufferedReader br = new BufferedReader(new FileReader(readFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(primes.isPrime(Integer.parseInt(line)) == true) {
                    writer.println(line);
                }
            }
        }

        endTime = System.nanoTime();
        duration = (endTime - startTime) / 10000000;

        System.out.println("isPrime execution time :> " + duration + "ms");
    }
}