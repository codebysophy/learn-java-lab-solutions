/**
 * Music Fest Merch Inventory
 *
 * Name:    Duke
 * Date:    October 10, 2026
 * Purpose: Track the merchandise inventory for a music festival. The program
 *          starts with a stock count for each item, takes in the number sold
 *          and the number restocked for each item, and prints the updated
 *          inventory count for every item.
 *
 * Items stored in inventory:
 *   - Wristbands
 *   - Posters
 *   - Water bottles
 *
 * Precondition:  Every sales and restock value entered is a whole number that
 *                is zero or greater, and sales never exceed the current stock
 *                of that item.
 * Postcondition: Each inventory variable holds its starting count, minus the
 *                number sold, plus the number restocked.
 */
void main() {

    // Inventory counts: start with what is on hand, updated as the day goes on
    int wristbands = 500;    // wristbands currently in inventory
    int posters = 200;       // posters currently in inventory
    int waterBottles = 350;  // water bottles currently in inventory

    /*
     * INPUT
     * The program asks for six whole numbers, one per line, in this order:
     *   1. wristbands sold        2. wristbands restocked
     *   3. posters sold           4. posters restocked
     *   5. water bottles sold     6. water bottles restocked
     * IO.readln shows the prompt and returns what was typed as a String, and
     * Integer.parseInt converts that String into an int.
     */
    // wristbands sold today, and wristbands received in a new shipment
    int wristbandsSold = Integer.parseInt(IO.readln("Wristbands sold: "));
    int wristbandsRestocked = Integer.parseInt(IO.readln("Wristbands restocked: "));

    // posters sold today, and posters received in a new shipment
    int postersSold = Integer.parseInt(IO.readln("Posters sold: "));
    int postersRestocked = Integer.parseInt(IO.readln("Posters restocked: "));

    // water bottles sold today, and water bottles received in a new shipment
    int bottlesSold = Integer.parseInt(IO.readln("Water bottles sold: "));
    int bottlesRestocked = Integer.parseInt(IO.readln("Water bottles restocked: "));

    /*
     * CALCULATIONS
     * For every item: subtract what was sold, then add what was restocked.
     * Sales leave the shelf, so -= lowers the count. Restock arrives on the
     * shelf, so += raises it. Each inventory variable is updated in place,
     * so after these lines it holds the current count.
     */
    wristbands -= wristbandsSold;
    wristbands += wristbandsRestocked;

    posters -= postersSold;
    posters += postersRestocked;

    waterBottles -= bottlesSold;
    waterBottles += bottlesRestocked;

    /*
     * OUTPUT
     * Prints the current inventory count for each of the three items.
     *
     * Example 1
     *   Input:  wristbands sold 120, restocked 50
     *           posters sold 35, restocked 0
     *           water bottles sold 210, restocked 100
     *   Output: Wristbands:    430
     *           Posters:       165
     *           Water bottles: 240
     *
     * Example 2
     *   Input:  wristbands sold 0, restocked 25
     *           posters sold 200, restocked 75
     *           water bottles sold 350, restocked 0
     *   Output: Wristbands:    525
     *           Posters:       75
     *           Water bottles: 0
     */
    IO.println();
    IO.println("*** Current Inventory ***");
    IO.println("Wristbands:    " + wristbands);
    IO.println("Posters:       " + posters);
    IO.println("Water bottles: " + waterBottles);
}
