import java.util.*;
public class CodeGenerator {
    private String lock; 
    private String clearance; 
    private ArrayList<String> words;

    /**
     * Creates a master code with a random 3 digit lock code and clearance word. 
     * Precondition: the first digit of the lock code will never be 0 and the clearance word is picked randomly from a list of words. 
     */
    public CodeGenerator() {
        words = new ArrayList<>(Arrays.asList("CLOCK", "TIME", "HOUR", "TRAVEL"));
        lock = "" + ((int)(Math.random() * 9) + 1) + (int)(Math.random() * 10) + (int)(Math.random() * 10);
        int index = (int)(Math.random() * words.size());
        clearance = words.get(index);

    }

    /**
     * Creates a master code with lockCode as the lock code and clearanceCode as the clearance word. 
     * This constructor is ideal for testing code. 
     * @param lockCode - the lock
     * @param clearanceCode - the clearance word.
     */
    public CodeGenerator(String lockCode, String clearanceCode) {
        words = new ArrayList<>(Arrays.asList("CLOCK", "TIME", "HOUR", "TRAVEL"));
        lock = lockCode;
        clearance = clearanceCode;
    }

    /**
     * Returns the value of the lock code
     * @return lock
     */
    public String getLockCode() {
        return lock;
    }

    /**
     * Returns the value of the clearance word
     * @return clearance
     */

    public String getClearanceWord() {
        return clearance;
    }

    @Override 
    /**    (non-Javadoc)
     * Returns a string representing the master code generated.
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "lock code: " + lock + " clearance word: " + clearance;
    }
}
