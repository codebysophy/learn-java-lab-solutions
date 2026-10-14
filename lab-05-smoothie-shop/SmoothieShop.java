/**
 * Smoothie Shop Rewards
 *
 * Name:    Duke
 * Date:    October 23, 2026
 * Purpose: Use the provided SmoothieCard class to run a smoothie shop's
 *          reward program. The program creates a reward card for two
 *          customers, builds a smoothie on each card, sends both orders, and
 *          reports each order with the points left on the card. It then adds
 *          bonus points to one card and shows the new balance.
 */
void main() {

    /*
     * CREATE THE CARDS
     * SmoothieCard is a class, so each card is an object made with the
     * constructor: new SmoothieCard(customer name, starting points).
     * The variable type is SmoothieCard, the same name as the class.
     */
    SmoothieCard card1 = new SmoothieCard("Maya", 500);
    SmoothieCard card2 = new SmoothieCard("Jordan", 400);

    /*
     * MAYA'S ORDER (card1): 2 scoops of fruit, 1 scoop of protein, granola
     * Each method is called on card1 with the dot operator, so every add-in
     * lands on Maya's card and nobody else's. Points come off the card as
     * each item is added.
     */
    card1.addFruit(2);
    card1.addProtein();
    card1.addTopping("granola");

    /*
     * JORDAN'S ORDER (card2): 3 scoops of fruit, honey
     * Same methods, different object, so this order is kept separate.
     */
    card2.addFruit(3);
    card2.addTopping("honey");

    /*
     * SEND THE ORDERS
     * sendOrder adds the 50 points earned for ordering, builds a receipt
     * String (name, order, points used, remaining balance), clears the
     * order off the card, and returns the receipt. It does not print, so
     * the call is wrapped in IO.println or nothing shows up.
     */
    IO.println("*** Orders ***");
    IO.println(card1.sendOrder());
    IO.println();
    IO.println(card2.sendOrder());

    /*
     * BONUS POINTS
     * Maya buys 200 more points. earnBonusPoints raises the balance on her
     * card only, so card2 is unchanged.
     */
    card1.earnBonusPoints(200);
    IO.println();
    IO.println(card1.getCustomerName() + " added 200 points. New balance: "
            + card1.getPointsBalance());
}
