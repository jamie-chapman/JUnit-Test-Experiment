import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @author Jamie Chapman
 * @date 15/07/2018
 * Class to manipulate, generate and test prime numbers
 */
public class Primes {

    /**
     * Constructor method for Primes
     */
    public Primes() {
    }

    /**
     * Writes a list of ints from min to max to file
     * @param min Minimum value
     * @param max Maximum value
     * @param filename
     * @return numbers
     */
    public void writeInts(int min, int max, String filename ) {
        //Initialise PrintWriter to write to file
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            Random rand = new Random();

            //Write values
            for(int i = min; i <= max; i++) {
                writer.println(i);
            }
            writer.close();
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (UnsupportedEncodingException e) {e.printStackTrace();}
    }

    /**
     * Genrerates an Array of integers (from 1 to amount) to write to file
     * @param amount Amount of numbers to generate
     * @param min Floor value
     * @param max Ceiling value
     * @param filename File name to write to
     * @return numbers
     */
    public void writeRandomInts(int amount, int min, int max, String filename) {
        try {
            //Initialise Objects
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            Random rand = new Random();

            //Write values
            for(int i = 0; i <= amount; i++) {
                writer.println(rand.nextInt((max - min) + 1) + min);
            }

            writer.close();
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (UnsupportedEncodingException e) {e.printStackTrace();}
    }

    /**
     * Tests a whole numbers (ints) primality
     * @param number
     * @return true or false
     */
    public boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * A faster implementation of isPrime
     * @param number
     * @return true or false
     */
    public boolean fastIsPrime(int number) {
        //check if number is multiple of 2
        if(number % 2 == 0) {
            return false;
        }

        //if not, just check odds
        for(int i = 3; i*i < number; i += 2) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}