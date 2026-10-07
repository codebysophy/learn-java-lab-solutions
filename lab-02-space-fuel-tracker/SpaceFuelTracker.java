void main() {
    int totalFuel = 1000;
    int missionDays = 0;
    int totalFuelUsed = 0;   // not in the template: fuel burned, separate from what's in the tank

    // ---------- Transmission 1 ----------
    IO.println("--- Transmission 1 ---");
    int days = Integer.parseInt(IO.readln("Days since last transmission: "));
    int fuelUsed = Integer.parseInt(IO.readln("Fuel used: "));
    int fuelFound = Integer.parseInt(IO.readln("Fuel found: "));

    missionDays += days;
    totalFuel -= fuelUsed;
    totalFuel += fuelFound;
    totalFuelUsed += fuelUsed;

    // ---------- Transmission 2 ----------
    IO.println("--- Transmission 2 ---");
    days = Integer.parseInt(IO.readln("Days since last transmission: "));
    fuelUsed = Integer.parseInt(IO.readln("Fuel used: "));
    fuelFound = Integer.parseInt(IO.readln("Fuel found: "));

    missionDays += days;
    totalFuel -= fuelUsed;
    totalFuel += fuelFound;
    totalFuelUsed += fuelUsed;

    // ---------- Transmission 3 ----------
    IO.println("--- Transmission 3 ---");
    days = Integer.parseInt(IO.readln("Days since last transmission: "));
    fuelUsed = Integer.parseInt(IO.readln("Fuel used: "));
    fuelFound = Integer.parseInt(IO.readln("Fuel found: "));

    missionDays += days;
    totalFuel -= fuelUsed;
    totalFuel += fuelFound;
    totalFuelUsed += fuelUsed;

    // ---------- Mission report ----------

    // integer division: decimal is truncated
    int averageInt = totalFuelUsed / missionDays;

    // cast FIRST, then divide
    double averageDouble = (double) totalFuelUsed / missionDays;

    IO.println("--- Mission Report ---");
    IO.println("Mission days: " + missionDays);
    IO.println("Total fuel used: " + totalFuelUsed);
    IO.println("Fuel remaining: " + totalFuel);
    IO.println("Average fuel per day (integer division): " + averageInt);
    IO.println("Average fuel per day (with casting): " + averageDouble);
}
