/**
 * Pet Recommender
 *
 * Name:    Duke
 * Date:    November 20, 2026
 * Purpose: Recommend a dog or a cat. The program asks whether the person
 *          has a backyard, how many minutes of outside activity they want
 *          each day, and how many hours they are out of the house each day.
 *          Dogs need time outside and company, so a dog is recommended:
 *            - with a backyard: when the activity time is more than 60
 *              minutes OR they are out of the house less than 8 hours
 *            - without a backyard: when the activity time is more than 60
 *              minutes AND they are out of the house less than 8 hours
 *          In every other case, the program recommends a cat.
 */
void main() {

    /*
     * INPUT
     * The backyard answer stays a String ("yes" or "no"). The two times are
     * whole numbers, so Integer.parseInt turns them into ints.
     */
    String backyardAnswer = IO.readln("Do you have a backyard? (yes/no): ");
    int activityMinutes = Integer.parseInt(
            IO.readln("How many minutes of outside activity do you want each day? "));
    int hoursAway = Integer.parseInt(
            IO.readln("How many hours are you out of the house each day? "));

    /*
     * THE THREE CONDITIONS
     * Each one is a boolean, so we name it once and reuse it. These are the
     * three columns of the truth table above.
     *
     * == vs .equals (topic 2.6.B)
     * A String is an object. == checks whether two variables hold the same
     * reference; .equals checks whether the characters are the same.
     * "yes" in the code is a literal from the string constant pool, but the
     * String that IO.readln returns is a brand-new object. So
     *   backyardAnswer == "yes"       -> false, even when the user typed yes
     *   backyardAnswer.equals("yes")  -> true
     */
    boolean hasBackyard = backyardAnswer.equals("yes");
    boolean veryActive = activityMinutes > 60;      // 60 exactly is NOT enough
    boolean homeEnough = hoursAway < 8;             // 8 exactly is NOT enough

    /*
     * NESTED IF (topic 2.4)
     * The first question splits people into two groups: backyard or no
     * backyard. Each group has its own rule, so the second if sits inside
     * the first. The inner if in the else only runs when the first
     * condition is false.
     *
     * COMPOUND BOOLEAN EXPRESSIONS (topic 2.5)
     *   ||  true when at least one expression is true
     *   &&  true only when both expressions are true
     * A backyard makes up for some missing time, so one condition is
     * enough (||). Without a backyard, a dog needs both (&&).
     */
    String pet;
    if (hasBackyard) {
        if (veryActive || homeEnough) {
            pet = "dog";
        } else {
            pet = "cat";
        }
    } else {
        if (veryActive && homeEnough) {
            pet = "dog";
        } else {
            pet = "cat";
        }
    }

    /*
     * OUTPUT
     */
    IO.println();
    IO.println("We recommend a " + pet + "!");
}
