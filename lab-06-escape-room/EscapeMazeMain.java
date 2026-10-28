/**
 * Escape Room Code Decoder
 *
 * Name:    Duke
 * Date:    October 30, 2026
 * Purpose: Decode the code found at the end of an escape room. A room code
 *          looks like TIME-415-CLOCK: a mission clue, a dash, a three-digit
 *          lock code, a dash, and a clearance word. The program splits the
 *          room code into its three pieces, compares the lock code to the
 *          master lock code to tell the team which way to go, and checks
 *          whether the clearance word matches the master clearance word.
 *
 * Test cases (use the testing master code, 415 / CLOCK):
 *   Room code          Lock compare      Clearance match
 *   TIME-723-HOUR      positive (right)  false
 *   TIME-208-HOUR      negative (left)   false
 *   TIME-415-HOUR      0 (exit)          false
 *   TRAVEL-999-CLOCK   positive (right)  true  (exit)
 */
void main() {

    /*
     * MASTER CODE
     * The master code is the answer key for the whole game: a lock code and
     * a clearance word, with no mission clue. The default constructor picks
     * them at random. To run the test cases above, switch to the testing
     * line so the master code is always 415 / CLOCK.
     */
    CodeGenerator masterCode = new CodeGenerator();
    // CodeGenerator masterCode = new CodeGenerator("415", "CLOCK");   // for testing

    /*
     * ROOM CODE
     * The code the team found in this room. It is a plain String, not a
     * CodeGenerator. Change it to try each test case.
     */
    String roomCode = "TIME-415-CLOCK";

    /*
     * BREAK THE ROOM CODE INTO PIECES
     * Draw the indexes above the characters, starting at 0:
     *
     *    0 1 2 3 4 5 6 7 8 9 10 11 12 13
     *    T I M E - 4 1 5 - C L  O  C  K
     *
     * indexOf("-") finds the first dash (index 4 here).
     *   mission clue:   everything before the dash
     *   lock code:      the 3 digits right after the dash
     *   clearance word: everything after those 3 digits and the second dash
     */
    int dashIndex = roomCode.indexOf("-");
    String missionClue = roomCode.substring(0, dashIndex);                 // "TIME"
    String roomLock = roomCode.substring(dashIndex + 1, dashIndex + 4);    // "415"
    String roomClearance = roomCode.substring(dashIndex + 5);              // "CLOCK"

    /*
     * COMPARE THE ROOM CODE TO THE MASTER CODE
     * The lock code tells the team which way to go, which has three possible
     * answers, so it uses compareTo (returns an int):
     *   room lock comes after the master   -> positive (go right)
     *   room lock comes before the master  -> negative (go left)
     *   same lock code                     -> 0        (exit)
     * getLockCode returns a String, so this compares the digits in order.
     * Both codes are three digits, so the order matches the number order.
     *
     * The clearance word is a yes/no question (same word or not), so it
     * uses equals (returns a boolean). equals is case-sensitive.
     */
    String masterLock = masterCode.getLockCode();
    String masterClearance = masterCode.getClearanceWord();

    int nextRoom = roomLock.compareTo(masterLock);
    boolean escaped = roomClearance.equals(masterClearance);

    /*
     * REPORT
     * Joining a String with masterCode calls its toString method.
     */
    IO.println("Master code:     " + masterCode);
    IO.println("Room code:       " + roomCode);
    IO.println();
    IO.println("Mission clue:    " + missionClue);
    IO.println("Lock code:       " + roomLock);
    IO.println("Clearance word:  " + roomClearance);
    IO.println();
    IO.println("Lock compare:    " + nextRoom);
    IO.println("  (positive = go right, negative = go left, 0 = exit the maze)");
    IO.println("Escaped with clearance word? " + escaped);
}
