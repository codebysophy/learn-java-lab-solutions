void main() {
    // 1. Store the data
    String petName;
    int energyLevel = 100;
    int minutesSlept = 45;
    int minutesExercised = 22;
    int mealsEaten = 2;

    // 2. Input the data
    petName = IO.readln("What would you like to name your pet? ");

    // 3. Process the data
    energyLevel = energyLevel + minutesSlept / 10 * 2;
    energyLevel = energyLevel - minutesExercised / 5 * 7;
    energyLevel = energyLevel + mealsEaten * 5;

    // 4. Output the data
    System.out.print("***");
    System.out.print(petName);
    System.out.print(" has an energy level of ");
    System.out.print(energyLevel);
    System.out.println("***");
}
