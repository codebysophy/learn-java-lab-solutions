/**
 * Space Shuttle Fuel Needed
 *
 * Name:    Duke
 * Date:    October 17, 2026
 * Purpose: Bring a space shuttle back to its landing pad. The program takes in
 *          the coordinates of the shuttle and the landing pad, computes the
 *          horizontal, vertical, and straight line distance between them, and
 *          uses the straight line distance and the fuel rate to compute how
 *          much fuel is needed to get the shuttle home.
 *
 * Values stored by the program:
 *   - Shuttle position (x, y)
 *   - Landing pad position (x, y)
 *   - Fuel rate (fuel burned per unit of distance)
 *   - Horizontal, vertical, and straight line distance
 *   - Fuel needed
 */
void main() {

    /*
     * INPUT
     * The program asks for five numbers, one per line, in this order:
     *   1. shuttle x      2. shuttle y
     *   3. landing pad x  4. landing pad y
     *   5. fuel rate
     */
    // where the shuttle is right now
    double shuttleX = Double.parseDouble(IO.readln("Shuttle x: "));
    double shuttleY = Double.parseDouble(IO.readln("Shuttle y: "));

    // where the shuttle needs to land
    double padX = Double.parseDouble(IO.readln("Landing pad x: "));
    double padY = Double.parseDouble(IO.readln("Landing pad y: "));

    // fuel burned for every 1 unit of distance traveled
    double fuelRate = Double.parseDouble(IO.readln("Fuel rate: "));

    /*
     * CALCULATIONS
     * Horizontal distance is the difference in x, vertical distance is the
     * difference in y. Subtracting can give a negative number depending on
     * which point is further left or lower, so Math.abs makes it positive:
     * a distance can't be negative.
     *
     * The straight line distance is the hypotenuse of the right triangle the
     * horizontal and vertical distances make (Pythagorean theorem):
     *   distance = sqrt(horizontal^2 + vertical^2)
     *
     * Fuel needed is the straight line distance times the fuel rate.
     *
     */
    // how far apart the shuttle and pad are left to right (x direction)
    double horizontalDistance = Math.abs(shuttleX - padX);

    // how far apart the shuttle and pad are up and down (y direction)
    double verticalDistance = Math.abs(shuttleY - padY);

    // shortest path from the shuttle straight back to the pad
    double straightLineDistance = Math.sqrt(Math.pow(horizontalDistance, 2)
                                          + Math.pow(verticalDistance, 2));

    // total fuel the shuttle burns flying the straight line path home
    double fuelNeeded = straightLineDistance * fuelRate;

    /*
     * OUTPUT
     * Prints the three distances and the fuel needed to return to the pad.
     *
     * Example 1
     *   Input:  shuttle (3, 4), landing pad (0, 0), fuel rate 2.5
     *   Output: Horizontal distance:    3.0
     *           Vertical distance:      4.0
     *           Straight line distance: 5.0
     *           Fuel needed:            12.5
     *
     * Example 2
     *   Input:  shuttle (-2, 10), landing pad (4, 2), fuel rate 1.5
     *   Output: Horizontal distance:    6.0
     *           Vertical distance:      8.0
     *           Straight line distance: 10.0
     *           Fuel needed:            15.0
     */
    IO.println();
    IO.println("*** Return Flight Report ***");
    IO.println("Horizontal distance:    " + horizontalDistance);
    IO.println("Vertical distance:      " + verticalDistance);
    IO.println("Straight line distance: " + straightLineDistance);
    IO.println("Fuel needed:            " + fuelNeeded);
}
