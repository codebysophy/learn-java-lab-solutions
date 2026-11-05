/**
 * Esports Tournament Qualifying and Seeding
 *
 * Name:    Duke
 * Date:    November 13, 2026
 * Purpose: A team needs at least 700 points to play in the esports
 *          tournament. The program asks for the team's name and points.
 *          A team that qualifies is congratulated and given a random seed
 *          number from 2 to 8, the round it plays in first. A team that
 *          doesn't qualify gets a keep-trying message with the number of
 *          points it still needs.
 */
void main() {

    /*
     * QUALIFYING SCORE
     * final means this value can't change while the program runs. Naming it
     * once keeps 700 from being typed in two places.
     */
    final int QUALIFYING_POINTS = 700;

    /*
     * INPUT
     * IO.readln prints the prompt and returns what the user types as a
     * String. Points are a whole number, so Integer.parseInt turns the
     * String into an int we can compare and subtract.
     */
    String teamName = IO.readln("Enter your team name: ");
    int points = Integer.parseInt(IO.readln("Enter your team's points: "));

    /*
     * BOOLEAN EXPRESSION (topic 2.2)
     * A relational operator compares two values and the result is a
     * boolean: true or false. Use >= rather than >: "at least 700" means a
     * team with exactly 700 points qualifies.
     *   650 >= 700  -> false
     *   700 >= 700  -> true
     *   925 >= 700  -> true
     */
    boolean qualifies = points >= QUALIFYING_POINTS;

    /*
     * IF STATEMENT (topic 2.3)
     * Only two outcomes are possible, so one if/else covers every case:
     * the if block runs when qualifies is true, the else block when false.
     */
    if (qualifies) {

        /*
         * SEED NUMBER
         * Math.random() returns a double from 0.0 up to (not including) 1.0.
         *   * 7      -> 0.0 up to 7.0   (7 possible values: 2,3,4,5,6,7,8)
         *   (int)    -> 0 to 6          (casting cuts off the decimal)
         *   + 2      -> 2 to 8          (shift up to the lowest seed)
         * Teams can share a seed, so each team just gets its own random pick.
         */
        int seed = (int) (Math.random() * 7) + 2;

        IO.println("Congratulations, " + teamName + "! With " + points
                + " points, you qualified for the tournament.");
        IO.println("Your tournament seed number is " + seed + ".");
    } else {
        int pointsNeeded = QUALIFYING_POINTS - points;

        IO.println("Sorry, " + teamName + ". With " + points
                + " points, you don't qualify yet.");
        IO.println("Keep trying! Points needed to qualify: " + pointsNeeded);
    }
}
